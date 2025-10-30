package com.jiangxian.controller;

import com.jiangxian.pojo.Emp;
import com.jiangxian.pojo.EmpQueryParams;
import com.jiangxian.pojo.Result;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result queryFenYe(EmpQueryParams empQueryParams){
        log.warn("查询参数：{} ",empQueryParams);
        ResultPage ResultPage = empService.list(empQueryParams);
        return Result.success(ResultPage);
    }
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.warn("保存的员工数据：{} ",emp);
        empService.save(emp);
        return Result.success();
    }

}
