package com.workloadaccount.app.service.impl;

import com.workloadaccount.app.entity.ProjectDO;
import com.workloadaccount.app.entity.WorkloadRecordDO;
import com.workloadaccount.app.mapper.ProjectDao;
import com.workloadaccount.app.mapper.WorkloadRecordDao;
import com.workloadaccount.app.service.AdminWorkloadService;
import com.workloadaccount.app.vo.ProjectUserVo;
import com.workloadaccount.app.vo.ProjectWorkloadVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired(required = false)
    public AdminWorkloadServiceImpl(ProjectDao projectDao, WorkloadRecordDao workloadRecordDao) {
        this.projectDao = projectDao;
        this.workloadRecordDao = workloadRecordDao;
    }

    @Override
    public List<ProjectWorkloadVO> getWorkloadByProject() {
        // 返回值
        List<ProjectWorkloadVO> projectWorkloadVOList = new ArrayList<>();

        // 首先查询所有的项目
        List<ProjectDO> projectDOList = projectDao.listProjects();



        // 根据项目查询项目下的用户该月工作时间
        projectDOList.forEach(projectDO -> {
            ProjectWorkloadVO projectWorkloadVO = new ProjectWorkloadVO();
            projectWorkloadVO.setProjectId(projectDO.getId());
            projectWorkloadVO.setProjectName(projectDO.getName());

            // 获取用户
            List<Integer> projectUserList = workloadRecordDao.listUserByProjectId(projectDO.getId());
            List<ProjectUserVo> projectUserVoList = new ArrayList<>();
            projectUserList.forEach(projectUser -> {
                ProjectUserVo projectUserVo = new ProjectUserVo();
                projectUserVo.setUsername(projectUser.toString());
                List<WorkloadRecordDO> workloadRecordDOList = workloadRecordDao.findByUserAndProjectId(projectUser, projectDO.getId());
                projectUserVo.setUserWorkload(workloadRecordDOList);
                projectUserVoList.add(projectUserVo);
            });
            projectWorkloadVO.setProjectUser(projectUserVoList);
            projectWorkloadVOList.add(projectWorkloadVO);
//            projectWorkloadVOList.set(projectUserVoList);
//            log.info(projectDO.getId() + " ProjectName:" + projectDO.getName() + projectUserList.toString());
//            projectUserList.forEach(userLists-> {
//                log.info(userLists.toString());
//                userLists.forEach(users -> {
//                    // 单个元素
//                    ProjectWorkloadVO projectWorkloadVO = new ProjectWorkloadVO();
//                    List<ProjectUserVo> projectWorkloadUserVOList = new ArrayList<>();
//                    ProjectUserVo projectWorkloadUserVO = new ProjectUserVo();
//                    projectWorkloadUserVO.setUsername("");
//                    projectWorkloadUserVO.setTotal(10);
//                    List<WorkloadRecordDO> workloadRecordDOList = workloadRecordDao.findByUserAndProjectId(users, projectDO.getId());
//                    projectWorkloadUserVO.setWorkloadRecordDOList(workloadRecordDOList);
//                    log.info(workloadRecordDOList.toString());
//                    projectWorkloadVO.setProjectId(projectDO.getId());
//                    projectWorkloadVO.setProjectName(projectDO.getName());
//                    projectWorkloadVO.setProjectWorkloadUserVoList(projectWorkloadUserVOList);
//                    projectWorkloadUserVOList.add(projectWorkloadUserVO);
//                    projectWorkloadVOList.add(projectWorkloadVO);
////                    projectWorkloadVOList.add(projectWorkloadUserVOList);
////                    log.info("sss::" + workloadRecordDao.findByUserAndProjectId(users, projectDO.getId()).toString());
////                    workloadRecordDao.findByUserAndProjectId(users, projectDO.getId());
//                });
//            });
        });
        return projectWorkloadVOList;
    }

    @Override
    public void getWorkloadByUser() {

    }
}
