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
public class UserDO extends BaseDO{
    private static final long serialVersionUID = -8765178865080756261L;

    /**
     * 用户名
     */
    private String name;

    /**
     * 登录用户名
     */
    private String loginName;

    private String password;

    /**
     * 用户角色
     */
    private Integer userRole;

    /**
     * 用户工作角色
     */
    private Integer userWorkRole;
}
