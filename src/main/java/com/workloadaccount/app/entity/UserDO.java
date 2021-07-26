package com.workloadaccount.app.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
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
public class UserDO implements Serializable {
    private static final long serialVersionUID = -8765178865080756261L;

    private String userid;

    /**
     * 部门
     */
    private String dept;

    /**
     * 真实用户名
     */
    private String realName;

    private Integer seqNo;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private Integer roleCode;

    private char flag;

    private Timestamp createTime;

    private String ip;

    /**
     * 停止时间
     */
    private Timestamp quitTime;

    /**
     * 工作代码
     */
    private String workCode;

}
