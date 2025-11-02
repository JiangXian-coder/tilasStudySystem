package com.jiangxian.controller;

import com.jiangxian.pojo.JobOption;
import com.jiangxian.pojo.Result;
import com.jiangxian.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("getEmpJobData:{}",reportService.getEmpJobData().toString());
        JobOption empJobData = reportService.getEmpJobData();
        return Result.success(empJobData);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        List<Map> genderData = reportService.getGenderData();
        return Result.success(genderData);
    }
}
