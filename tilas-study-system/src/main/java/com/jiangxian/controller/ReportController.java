package com.jiangxian.controller;

import com.jiangxian.pojo.JobOption;
import com.jiangxian.pojo.Result;
import com.jiangxian.pojo.StuCountOption;
import com.jiangxian.service.ReportService;
import com.jiangxian.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 报表控制器类
 * 提供各类数据统计和报表接口
 */
@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private StuService stuService;

    /**
     * 获取员工就业数据
     * @return Result 包含就业数据的响应结果
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("getEmpJobData:{}",reportService.getEmpJobData().toString());
        JobOption empJobData = reportService.getEmpJobData();
        return Result.success(empJobData);
    }

    /**
     * 获取员工性别统计数据
     * @return Result 包含性别统计数据的响应结果
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        List<Map> genderData = reportService.getGenderData();
        return Result.success(genderData);
    }

    /**
     * 获取学生学历分布数据
     * @return Result 包含学历分布数据的响应结果
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        List<Map> studentDegreeData = reportService.getStudentDegreeData();
        return Result.success(studentDegreeData);
    }

    /**
     * 获取学生总数统计数据
     * @return Result 包含学生总数统计数据的响应结果
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        StuCountOption studentCountData = reportService.getStudentCountData();
        return Result.success(studentCountData);
    }

    //写于2025/11/5|| 17:33,学生图标统计功能开发完毕
}
