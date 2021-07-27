package com.workloadaccount.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

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
public class EarlyDateDTO implements Serializable {
    private static final long serialVersionUID = 2449469751431242286L;
    private String startDate;
    private String endDate;
    private String userid;
}
