package com.workloadaccount.app.service.impl;

import com.workloadaccount.app.entity.ProjectDO;
import com.workloadaccount.app.entity.UserDO;
import com.workloadaccount.app.entity.WorkloadRecordDO;
import com.workloadaccount.app.mapper.ProjectDao;
import com.workloadaccount.app.mapper.UserDao;
import com.workloadaccount.app.mapper.WorkloadRecordDao;
import com.workloadaccount.app.service.AdminWorkloadService;
import com.workloadaccount.app.transfer.WorkloadTransfer;
import com.workloadaccount.app.vo.ProjectUserVO;
import com.workloadaccount.app.vo.ProjectWorkloadVO;
import com.workloadaccount.app.vo.UserWorkloadVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Service
@Slf4j
public class AdminWorkloadServiceImpl implements AdminWorkloadService {
    private final ProjectDao projectDao;

    private final WorkloadRecordDao workloadRecordDao;

    private final UserDao userDao;

    @Autowired(required = false)
    public AdminWorkloadServiceImpl(final ProjectDao projectDao,
                                    final WorkloadRecordDao workloadRecordDao,
                                    final UserDao userDao) {
        this.projectDao = projectDao;
        this.workloadRecordDao = workloadRecordDao;
        this.userDao = userDao;
    }

    @Override
    public List<ProjectWorkloadVO> getWorkloadByProject(String year) {
        // 返回值
        List<ProjectWorkloadVO> projectWorkloadVOList = new ArrayList<>();

        // 首先查询某年的所有的项目
        List<ProjectDO> projectDOList = projectDao.listProjects();

        // 查询所有用户
        List<UserDO> userDOList = userDao.listUsers();

        // 根据项目查询项目下的用户该月工作时间
        workloadRecordDao.listProjectByWorkload(year).forEach(project -> {
            ProjectWorkloadVO projectWorkloadVO = new ProjectWorkloadVO();
            // 设置项目相关信息
            ProjectDO projectDO = projectDOList.stream()
                    .filter(projectDO1 -> projectDO1.getId().equals(project))
                    .findFirst().orElse(null);
            assert projectDO != null;
            projectWorkloadVO.setProjectId(projectDO.getId());
            projectWorkloadVO.setProjectName(projectDO.getName());

            // 获取用户
            List<String> projectUserList = workloadRecordDao.listUserByProjectId(projectDO.getId(), year);
            List<ProjectUserVO> projectUserVoList = new ArrayList<>();
            projectUserList.forEach(projectUser -> {
                ProjectUserVO projectUserVO = new ProjectUserVO();

                // 设置用户名
                UserDO userResult = userDOList.stream()
                        .filter(userDO -> userDO.getUserid().equals(projectUser))
                        .findFirst().orElse(null);
                assert userResult != null;
                projectUserVO.setUsername(userResult.getUsername());
                projectUserVO.setRealName(userResult.getRealName());
                List<WorkloadRecordDO> workloadRecordDOList = workloadRecordDao.listWorkloadByUserAndProjectId(projectUser,
                        projectDO.getId(), year);
                projectUserVO.setUserWorkload(workloadRecordDOList);
                projectUserVoList.add(projectUserVO);
            });
            projectWorkloadVO.setProjectUser(projectUserVoList);
            projectWorkloadVOList.add(projectWorkloadVO);
        });
        return projectWorkloadVOList;
    }

    @Override
    public List<UserWorkloadVO> getWorkloadByUser(String date) {
        List<UserWorkloadVO> userWorkloadVOList = new ArrayList<>();
        List<UserDO> userDOList = userDao.listUsers();
        // 查询所有项目记录下的用户
        workloadRecordDao.listUserByWorkload(date).forEach(user -> {
            UserWorkloadVO userWorkloadVO = new UserWorkloadVO();
            userWorkloadVO.setUserid(user);
            UserDO userResult = userDOList.stream()
                    .filter(userDO -> userDO.getUserid().equals(user))
                    .findFirst().orElse(null);
            assert userResult != null;
            userWorkloadVO.setUsername(userResult.getUsername());
            userWorkloadVO.setRealName(userResult.getRealName());
            // 根据用户分组查询用户工作时间
            userWorkloadVO.setUserMonthWorkload(workloadRecordDao.listWorkloadByUserIdAndDate(user, date)
                    .stream()
                    .map(WorkloadTransfer.INSTANCE::mapToUserWorkloadVO)
                    .collect(Collectors.toList()));
            userWorkloadVOList.add(userWorkloadVO);
        });
        return userWorkloadVOList;
    }
}
