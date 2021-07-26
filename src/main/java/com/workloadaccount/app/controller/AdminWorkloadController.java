package com.workloadaccount.app.controller;

import com.workloadaccount.app.service.impl.AdminWorkloadServiceImpl;
import com.workloadaccount.system.response.Result;
import com.workloadaccount.system.response.ResultUtil;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AdminWorkloadController {

    @Autowired
    AdminWorkloadServiceImpl adminWorkloadService;

    @GetMapping("/count/user")
    public Result countByUser(@RequestParam(value = "date") String date) {
        return ResultUtil.success(GLOBAL_SUCCESS.getCode(),
                GLOBAL_SUCCESS.getMessage(),
                adminWorkloadService.getWorkloadByUser(date));
    }

    @GetMapping("/count/project")
    public Result countByProject(@RequestParam(value = "year") String year) {
        return ResultUtil.success(GLOBAL_SUCCESS.getCode(),
                GLOBAL_SUCCESS.getMessage(),
                adminWorkloadService.getWorkloadByProject(year));
    }
}
