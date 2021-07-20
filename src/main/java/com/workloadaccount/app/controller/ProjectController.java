package com.workloadaccount.app.controller;

import com.workloadaccount.app.service.impl.ProjectServiceImpl;
import com.workloadaccount.system.response.Result;
import com.workloadaccount.system.response.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.workloadaccount.system.response.ResultEnum.GLOBAL_SUCCESS;

/**
 * @author
 * @description
 * @see
 * @since
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectServiceImpl projectService;

    @GetMapping("/list")
    public Result getProject() {
        return ResultUtil.success(GLOBAL_SUCCESS.getCode(), GLOBAL_SUCCESS.getMessage(), projectService.listProject());
    }
}
