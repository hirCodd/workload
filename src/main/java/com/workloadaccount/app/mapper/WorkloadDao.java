package com.workloadaccount.app.mapper;

import com.workloadaccount.app.entity.WorkloadLogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Mapper
public interface WorkloadDao {

    /**
     * 插入工作量统计
     * @param workloadLogDO
     */
    void insertWorkload(WorkloadLogDO workloadLogDO);
}
