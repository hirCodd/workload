package com.workloadaccount.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
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
@ToString
public class RecordWorkTimeDTO implements Serializable {
    private static final long serialVersionUID = -923812743340476523L;
    private String userid;
    private String projectId;
    private String date;
    private BigDecimal workTime;

}
