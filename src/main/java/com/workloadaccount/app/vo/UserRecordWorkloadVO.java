package com.workloadaccount.app.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
@SuperBuilder
@Builder
public class UserRecordWorkloadVO {
    private String userid;

    private Integer projectId;

    private String projectName;

    private String workloadDate;

    private BigDecimal workloadTime;

}
