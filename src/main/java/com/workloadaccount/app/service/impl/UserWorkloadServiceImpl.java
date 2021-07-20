package com.workloadaccount.app.service.impl;

import com.workloadaccount.app.dto.RecordWorkTimeDTO;
import com.workloadaccount.app.entity.WorkloadRecordDO;
import com.workloadaccount.app.mapper.WorkloadRecordDao;
import com.workloadaccount.app.service.UserWorkloadService;
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
public class UserWorkloadServiceImpl implements UserWorkloadService {

    @Autowired
    WorkloadRecordDao workloadRecordDao;

    @Override
    public void insertWorkload(List<RecordWorkTimeDTO> recordWorkTimeDTOList) {
        List<WorkloadRecordDO> workloadRecordDOList = new ArrayList<>();
        recordWorkTimeDTOList.forEach(recordWorkTimeDTO -> {
            WorkloadRecordDO workloadRecordDO = new WorkloadRecordDO();
            workloadRecordDO.setUserId(1);
            workloadRecordDO.setProjectId(Integer.parseInt(recordWorkTimeDTO.getProjectId()));
            workloadRecordDO.setWorkloadDate(recordWorkTimeDTO.getDate());
            workloadRecordDO.setWorkloadTime(recordWorkTimeDTO.getWorkTime());
            workloadRecordDOList.add(workloadRecordDO);
        });
        log.info(workloadRecordDOList.toString());

        workloadRecordDao.insertWorkload(workloadRecordDOList);

    }
}
