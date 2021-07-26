package com.workloadaccount.app.transfer;

import com.workloadaccount.app.entity.WorkloadRecordDO;
import com.workloadaccount.app.vo.UserWorkloadMonthVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Mapper
public interface WorkloadTransfer {
    WorkloadTransfer INSTANCE = Mappers.getMapper(WorkloadTransfer.class);

    /**
     * 将实体转为视图
     * @param workloadRecordDO
     * @return
     */
    UserWorkloadMonthVO mapToUserWorkloadVO(WorkloadRecordDO workloadRecordDO);
}
