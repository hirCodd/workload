package com.workloadaccount.app.controller;

import com.workloadaccount.app.dto.RecordWorkTimeDTO;
import com.workloadaccount.app.service.impl.AdminWorkloadServiceImpl;
import com.workloadaccount.system.response.Result;
import com.workloadaccount.system.response.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.workloadaccount.system.response.ResultEnum.GLOBAL_SUCCESS;

/**
 * @author
 * @description
 * @see
 * @since
 */
@RestController
public class AdminWorkloadController {

    @Autowired
    AdminWorkloadServiceImpl adminWorkloadService;


}
