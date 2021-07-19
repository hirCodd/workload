package com.workloadaccount.app.controller;

import com.workloadaccount.app.dto.RecordWorkTimeDTO;
import com.workloadaccount.system.response.Result;
import com.workloadaccount.system.response.ResultUtil;
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
public class UserWorkloadController {
    @PostMapping("/record")
    public Result recordWorkTime(@RequestBody RecordWorkTimeDTO recordWorkTimeDTO) {

        return ResultUtil.success(GLOBAL_SUCCESS.getCode(), GLOBAL_SUCCESS.getMessage());
    }
}
