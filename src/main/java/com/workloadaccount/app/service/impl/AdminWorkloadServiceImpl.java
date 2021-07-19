package com.workloadaccount.app.service.impl;

import com.workloadaccount.app.service.AdminWorkloadService;
import com.workloadaccount.app.vo.ProjectWorkloadVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Service
public class AdminWorkloadServiceImpl implements AdminWorkloadService {
    @Override
    public List<ProjectWorkloadVO> getWorkloadByProject() {
        // 首先查询所有的项目

        // 根据项目查询项目下的用户该月工作时间
        return null;
    }

    @Override
    public void getWorkloadByUser() {

    }
}
