package com.workloadaccount.app.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WorkloadRecordDO extends BaseDO {
    private static final long serialVersionUID = 5914342016508695142L;

    private String userid;
    private Integer projectId;

    /**
     * 工作概述
     */
    private String workloadDate;

    /**
     * 工作时间(秒)
     */
    private BigDecimal workloadTime;
}
