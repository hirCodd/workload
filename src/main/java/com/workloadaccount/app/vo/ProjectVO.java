package com.workloadaccount.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class ProjectVO implements Serializable {
    private static final long serialVersionUID = 1725919553735503073L;
    private Integer id;
    /**
     * 项目名称
     */
    private String name;
}
