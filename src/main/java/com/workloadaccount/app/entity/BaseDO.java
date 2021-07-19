package com.workloadaccount.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Date;
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
@AllArgsConstructor
public class BaseDO implements Serializable {
    private static final long serialVersionUID = -8907483775858410899L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;
}
