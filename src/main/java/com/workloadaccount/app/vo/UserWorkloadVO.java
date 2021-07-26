package com.workloadaccount.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWorkloadVO {
    private String userid;
    private String username;
    private String realName;
    private List<UserWorkloadMonthVO> userMonthWorkload;
}
