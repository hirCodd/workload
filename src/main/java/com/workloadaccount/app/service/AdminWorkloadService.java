package com.workloadaccount.app.service;

import com.workloadaccount.app.vo.ProjectWorkloadVO;

import java.util.List;

/**
 * @author
 * @description
 * @see
 * @since
 */
public interface AdminWorkloadService {
    /**
     * 通过项目获取工作时长
     */
    List<ProjectWorkloadVO> getWorkloadByProject();

    void getWorkloadByUser();
}
