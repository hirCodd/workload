package com.workloadaccount.app.service;

import com.workloadaccount.app.dto.RecordWorkTimeDTO;

import java.util.List;

/**
 * @author
 * @description
 * @see
 * @since
 */
public interface UserWorkloadService {
    void insertWorkload(List<RecordWorkTimeDTO> recordWorkTimeDTOList);
}
