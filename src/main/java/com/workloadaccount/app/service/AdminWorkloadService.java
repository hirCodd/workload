package com.workloadaccount.app.service;

import com.workloadaccount.app.vo.ProjectWorkloadVO;
import com.workloadaccount.app.vo.UserWorkloadVO;

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
    List<ProjectWorkloadVO> getWorkloadByProject(String year);

    /**
     * 查询所有用户的工时
     * @param date
     * @return
     */
    List<UserWorkloadVO> getWorkloadByUser(String date);
}
