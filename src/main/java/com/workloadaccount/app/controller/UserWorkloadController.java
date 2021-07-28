package com.workloadaccount.app.controller;

import com.workloadaccount.app.dto.RecordWorkTimeDTO;
import com.workloadaccount.app.service.impl.UserWorkloadServiceImpl;
import com.workloadaccount.system.response.Result;
import com.workloadaccount.system.response.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.workloadaccount.system.response.ResultEnum.GLOBAL_SUCCESS;

/**
 * @author
 * @description
 * @see
 * @since
 */
@RestController
@Slf4j
public class UserWorkloadController {

    @Autowired
    UserWorkloadServiceImpl userWorkloadService;

    @PostMapping("/record")
    public Result recordWorkTime(@RequestBody List<RecordWorkTimeDTO> recordWorkTimeDTO) {
        log.info(recordWorkTimeDTO.toString());
        userWorkloadService.insertWorkload(recordWorkTimeDTO);

        return ResultUtil.success(GLOBAL_SUCCESS.getCode(), GLOBAL_SUCCESS.getMessage());
    }

    @GetMapping("/early-data")
    public Result getEarlyDate(@RequestParam("startDate") String startDate,
                               @RequestParam("endDate") String endDate,
                               @RequestParam("userid") String userid) {
        return ResultUtil.success(GLOBAL_SUCCESS.getCode(), GLOBAL_SUCCESS.getMessage(),
                userWorkloadService.listEarlyDate(startDate, endDate, userid));
    }

}
