package com.workloadaccount.app.service.impl;

import com.workloadaccount.app.dto.RecordWorkTimeDTO;
import com.workloadaccount.app.entity.ProjectDO;
import com.workloadaccount.app.entity.WorkloadRecordDO;
import com.workloadaccount.app.mapper.ProjectDao;
import com.workloadaccount.app.mapper.WorkloadRecordDao;
import com.workloadaccount.app.service.UserWorkloadService;
import com.workloadaccount.app.transfer.WorkloadTransfer;
import com.workloadaccount.app.vo.UserRecordWorkloadVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class UserWorkloadServiceImpl implements UserWorkloadService {

    private final ProjectDao projectDao;

    private final WorkloadRecordDao workloadRecordDao;

    @Autowired
    public UserWorkloadServiceImpl(ProjectDao projectDao, WorkloadRecordDao workloadRecordDao) {
        this.projectDao = projectDao;
        this.workloadRecordDao = workloadRecordDao;
    }

    @Override
    public void insertWorkload(List<RecordWorkTimeDTO> recordWorkTimeDTOList) {
        List<WorkloadRecordDO> workloadRecordDOList = new ArrayList<>();
        recordWorkTimeDTOList.forEach(recordWorkTimeDTO -> {
            WorkloadRecordDO workloadRecordDO = new WorkloadRecordDO();
            workloadRecordDO.setUserid(recordWorkTimeDTO.getUserid());
            workloadRecordDO.setProjectId(Integer.parseInt(recordWorkTimeDTO.getProjectId()));
            workloadRecordDO.setWorkloadDate(recordWorkTimeDTO.getDate());
            workloadRecordDO.setWorkloadTime(recordWorkTimeDTO.getWorkTime());
            workloadRecordDOList.add(workloadRecordDO);
        });
        log.info(workloadRecordDOList.toString());

        workloadRecordDao.insertWorkload(workloadRecordDOList);

    }

    @Override
    public List<UserRecordWorkloadVO> listEarlyDate(String startDate, String endDate, String userid) {
        List<ProjectDO> projectDOList = projectDao.listProjects();
        return workloadRecordDao.listEarlyData(startDate, endDate, userid).stream()
                .map(workloadRecordDO -> {
                    ProjectDO project = projectDOList.stream()
                            .filter(projectDO -> projectDO.getId().equals(workloadRecordDO.getProjectId()))
                            .findFirst().orElse(null);
                    assert project != null;
                    return UserRecordWorkloadVO.builder()
                            .userid(workloadRecordDO.getUserid())
                            .projectId(workloadRecordDO.getProjectId())
                            .projectName(project.getName())
                            .workloadDate(workloadRecordDO.getWorkloadDate())
                            .workloadTime(workloadRecordDO.getWorkloadTime())
                            .build();
                }).collect(Collectors.toList());
    }
}
