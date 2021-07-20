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
public class ProjectWorkloadVO {
    private String projectName;
    private List<ProjectWorkloadUserVO> projectWorkloadUserVoList;
}
