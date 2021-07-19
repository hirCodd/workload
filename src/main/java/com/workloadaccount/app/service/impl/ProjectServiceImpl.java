package com.workloadaccount.app.service.impl;

import com.github.pagehelper.PageInfo;
import com.workloadaccount.app.mapper.ProjectDao;
import com.workloadaccount.app.mapper.UserDao;
import com.workloadaccount.app.mapper.UserProjectDao;
import com.workloadaccount.app.mapper.WorkloadDao;
import com.workloadaccount.app.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final ProjectDao projectDao;

    private final UserProjectDao userProjectDao;

    private final UserDao userDao;

    private final WorkloadDao workloadDao;

    @Autowired(required = false)
    public ProjectServiceImpl(final ProjectDao projectDao,
                              final UserProjectDao userProjectDao,
                              final UserDao userDao,
                              final WorkloadDao workloadDao) {
        this.projectDao = projectDao;
        this.userProjectDao = userProjectDao;
        this.userDao = userDao;
        this.workloadDao = workloadDao;
    }

//    @Override
//    public PageInfo<ProjectPageVO> listProjectByPage(int pageIndex, int pageSize) {
//        PageHelper.startPage(pageIndex, pageSize);
//        List<ProjectDO> projects = projectDao.listProjects();
//        PageInfo<ProjectDO> pageInfoSource = new PageInfo<>(projects);
//        List<ProjectPageVO> projectTargetList = pageInfoSource.getList()
//                .stream()
//                .map(ProjectTransfer.INSTANCE::mapToVo)
//                .collect(Collectors.toList());
//        PageInfo<ProjectPageVO> pageInfoTarget = new PageInfo<>();
//
//        return buildPageInfo(pageInfoSource, pageInfoTarget, projectTargetList);
//    }
//
//    @Override
//    public ProjectDetailVO findProjectById(Integer projectId) {
//        // 查询某个项目
//        ProjectDetailVO projectDetailVO = ProjectTransfer.INSTANCE.mapToDetailVo(projectDao.findProjectById(projectId));
//
//        // 根据project_id查询所有用户的工作时间
//        List<UserProjectDO> userProjectDOList = userProjectDao.findUserProjectById(projectId);
//
//        // 查询所有用户的总的工作时间
//        projectDetailVO.setTotalWorkTime(userProjectDOList.stream()
//                .mapToLong(UserProjectDO::getWorkTime).
//                reduce(0, Long::sum));
//
//        // 设置用户工作列表
//        projectDetailVO.setProjectWorkTimeList(userProjectDOList.stream().map(userProjectDO -> {
//            ProjectWorkTimeVO projectWorkTimeVO = new ProjectWorkTimeVO();
//            projectWorkTimeVO.setName(userDao.findUserById(userProjectDO.getUserId()).getName());
//            projectWorkTimeVO.setWorkTime(userProjectDO.getWorkTime());
//            return projectWorkTimeVO;
//        }).collect(Collectors.toList()));
//        logger.info(projectDetailVO.toString());
//        return projectDetailVO;
//    }
//
//    @Override
//    public PageInfo<ProjectPageVO> listCompletedProjectByUserId(Integer userId, Integer projectStatus) {
//        // 查询该用户的所有项目
//        List<UserProjectDO> userProjectDOList = userProjectDao.findUserProjectByUserId(userId);
//
//        // 遍历查询所有的userProjectDOList并且返回List<ProjectPageVO>
//        List<ProjectPageVO> projectPageVOS = new ArrayList<ProjectPageVO>();
//        userProjectDOList.forEach(item -> {
//            ProjectPageVO projectPageVO = ProjectTransfer.INSTANCE.mapToVo(projectDao.findProjectByStatusAndId(item.getProjectId(), projectStatus));
//            if (projectPageVO != null) {
//                projectPageVOS.add(projectPageVO);
//            }
//        });
//        return new PageInfo<>(projectPageVOS);
//    }

//    @Transactional
//    @Override
//    public void recordWorkload(RecordWorkloadDTO recordWorkloadDTO) {
//        WorkloadLogDO workloadLogDO = WorkloadTransfer.INSTANCE.mapToEntity(recordWorkloadDTO);
//        // 计算workloadTime
//        workloadLogDO.setWorkloadTime(ChronoUnit.SECONDS.between(recordWorkloadDTO.getWorkStartTime().toLocalDateTime(),
//                recordWorkloadDTO.getWorkEndTime().toLocalDateTime()));
//        logger.info(workloadLogDO.toString());
//
//        // 更新workload_log
//        workloadDao.insertWorkload(workloadLogDO);
//
//        // 更新项目总的工作时间
//        userProjectDao.updateWorkloadTime(recordWorkloadDTO.getProjectId(), recordWorkloadDTO.getUserId(),
//                ChronoUnit.SECONDS.between(recordWorkloadDTO.getWorkStartTime().toLocalDateTime(),
//                        recordWorkloadDTO.getWorkEndTime().toLocalDateTime()));
//    }

//    @Override
//    public UserAllProjectVO getAllUserProjectsByUserId(Integer userId) {
//        // 获取该用户全部项目id
//        UserAllProjectVO userAllProjectVO = new UserAllProjectVO();
//        List<UserProjectDO> userProjectDOList = userProjectDao.findUserProjectByUserId(userId);
//        // 设置用户的项目总数
//        userAllProjectVO.setTotalProject(userProjectDOList.size());
//
//        // 通过查到的项目id获取项目全部项目信息
//        List<ProjectPageVO> projectPageVOS = new ArrayList<ProjectPageVO>();
//        userProjectDOList.forEach(userProjectDO -> {
//            projectPageVOS.add(ProjectTransfer.INSTANCE.mapToVo(projectDao.findProjectById(userProjectDO.getProjectId())));
//        });
//        userAllProjectVO.setProjectPageVOPageInfo(new PageInfo<>(projectPageVOS));
//
//        userAllProjectVO.setProcessingProject((int) projectPageVOS
//                .stream()
//                .filter(projectPageVO -> projectPageVO.getProjectStatus().equals(ProjectStatus.PROCESSING.getId()))
//                .count());
//
//        userAllProjectVO.setCompletedProject((int) projectPageVOS
//                .stream()
//                .filter(projectPageVO -> projectPageVO.getProjectStatus().equals(ProjectStatus.COMPLETED.getId()))
//                .count()
//        );
//        userAllProjectVO.setUserInfoVO(UserTransfer.INSTANCE.mapToUserInfoVO(userDao.findUserById(userId)));
//
//        return userAllProjectVO;
//    }

    private static <T, S> PageInfo<T> buildPageInfo(PageInfo<S> source, PageInfo<T> target, List<T> sourceList) {
        target.setList(sourceList);
        target.setEndRow(source.getEndRow());
        target.setHasNextPage(source.isHasNextPage());
        target.setIsFirstPage(source.isIsFirstPage());
        target.setIsLastPage(source.isIsLastPage());
        target.setHasPreviousPage(source.isHasPreviousPage());
        target.setNavigateFirstPage(source.getNavigateFirstPage());
        target.setNavigatepageNums(source.getNavigatepageNums());
        target.setNavigateLastPage(source.getNavigateLastPage());
        target.setNavigatePages(source.getNavigatePages());
        target.setNextPage(source.getNextPage());
        target.setPageNum(source.getPageNum());
        target.setPages(source.getPages());
        target.setPageSize(source.getPageSize());
        target.setPrePage(source.getPrePage());
        target.setSize(source.getSize());
        target.setStartRow(source.getStartRow());
        target.setTotal(source.getTotal());
        return target;
    }


}
