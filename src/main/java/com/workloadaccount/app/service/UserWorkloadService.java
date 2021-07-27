package com.workloadaccount.app.service;

import com.workloadaccount.app.dto.RecordWorkTimeDTO;
import com.workloadaccount.app.vo.UserRecordWorkloadVO;

import java.util.List;

/**
 * @author
 * @description
 * @see
 * @since
 */
public interface UserWorkloadService {
    /**
     * 插入工作记录
     * @param recordWorkTimeDTOList
     */
    void insertWorkload(List<RecordWorkTimeDTO> recordWorkTimeDTOList);

    /**
     * 查询早期数据
     * @param startDate
     * @param endDate
     * @param userid
     * @return
     */
    List<UserRecordWorkloadVO> listEarlyDate(String startDate, String endDate, String userid);
}
