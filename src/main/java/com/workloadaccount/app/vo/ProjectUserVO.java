package com.workloadaccount.app.vo;

import com.workloadaccount.app.entity.WorkloadRecordDO;
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
public class ProjectUserVO {
    private String username;
    private String realName;
    /**
     * 用户每月的工作时间
     */
    private List<WorkloadRecordDO> userWorkload;
}
