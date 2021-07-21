package com.workloadaccount.app.controller;

import com.workloadaccount.app.dto.RecordWorkTimeDTO;
import com.workloadaccount.app.service.impl.AdminWorkloadServiceImpl;
import com.workloadaccount.system.response.Result;
import com.workloadaccount.system.response.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.workloadaccount.system.response.ResultEnum.GLOBAL_SUCCESS;

/**
 * @author
 * @description
 * @see
 * @since
 */
@RestController
@RequestMapping("/admin")
public class AdminWorkloadController {

    @Autowired
    AdminWorkloadServiceImpl adminWorkloadService;

    @GetMapping("/count/user")
    public Result countByUser() {
        adminWorkloadService.getWorkloadByUser();
        return ResultUtil.success(GLOBAL_SUCCESS.getCode(), GLOBAL_SUCCESS.getMessage());
    }

    @GetMapping("/count/project")
    public Result countByProject() {
        adminWorkloadService.getWorkloadByProject();
        return ResultUtil.success(GLOBAL_SUCCESS.getCode(), GLOBAL_SUCCESS.getMessage(), adminWorkloadService.getWorkloadByProject());
    }
}
