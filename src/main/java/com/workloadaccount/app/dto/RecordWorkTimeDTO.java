package com.workloadaccount.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
public class RecordWorkTimeDTO {
    private List<RecordWorkTimeBaseDTO> data;
    private BigDecimal workHour;
    private BigDecimal workDays;
}
