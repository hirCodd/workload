package com.workloadaccount.app.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
public class UserProjectDO extends BaseDO{
    private static final long serialVersionUID = -3698255028637501701L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 项目id
     */
    private Integer projectId;

    /**
     * 工作时间
     */
    private Long workTime;
}
