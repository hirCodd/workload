package com.workloadaccount.app.mapper;

import com.workloadaccount.app.entity.WorkloadRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Mapper
public interface WorkloadRecordDao {

    /**
     * 插入工作量统计
     * @param workloadLogDO
     */
    void insertWorkload(List<WorkloadRecordDO> workloadLogDO);
}
