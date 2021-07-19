package com.workloadaccount.app.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
public class WorkloadLogDO extends BaseDO {
    private static final long serialVersionUID = 5914342016508695142L;

    private Integer userId;
    private Integer projectId;

    /**
     * 工作时间(秒)
     */
    private Long workloadTime;

    /**
     * 工作概述
     */
    private String workloadDescription;

    /**
     * 工作细节
     */
    private String workloadDetail;

    private Timestamp workStartTime;

    private Timestamp workEndTime;

}
