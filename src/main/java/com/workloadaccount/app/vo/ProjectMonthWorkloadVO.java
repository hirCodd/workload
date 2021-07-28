package com.workloadaccount.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMonthWorkloadVO {
    private String workDate;
    private BigDecimal workloadTime;
}
