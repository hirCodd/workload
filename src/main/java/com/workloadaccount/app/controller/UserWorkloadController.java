package com.workloadaccount.app.controller;

import com.workloadaccount.app.dto.RecordWorkTimeDTO;
import com.workloadaccount.app.service.impl.UserWorkloadServiceImpl;
import com.workloadaccount.system.response.Result;
import com.workloadaccount.system.response.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        userWorkloadService.insertWorkload(recordWorkTimeDTO);
        log.info(recordWorkTimeDTO.toString());
        return ResultUtil.success(GLOBAL_SUCCESS.getCode(), GLOBAL_SUCCESS.getMessage());
    }
}
