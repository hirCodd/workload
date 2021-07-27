package com.workloadaccount.app.service.impl;

import com.github.pagehelper.PageInfo;
import com.workloadaccount.app.mapper.ProjectDao;
import com.workloadaccount.app.mapper.UserDao;
import com.workloadaccount.app.mapper.WorkloadRecordDao;
import com.workloadaccount.app.service.ProjectService;
import com.workloadaccount.app.transfer.ProjectTransfer;
import com.workloadaccount.app.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDao projectDao;

    @Autowired(required = false)
    public ProjectServiceImpl(final ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public List<ProjectVO> listProject() {
        log.info(projectDao.listProjects().toString());
        return projectDao.listProjects().stream()
                .map(ProjectTransfer.INSTANCE::mapToVO)
                .collect(Collectors.toList());
    }
}
