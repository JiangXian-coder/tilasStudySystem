package com.jiangxian.controller;

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
    public Result queryFenYe(@RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10") Integer pageSize,
                             String name, Integer gender,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.warn("查询参数：{} {} {} {} {} {}",page,pageSize,name,gender,begin,end);
        ResultPage ResultPage = empService.list(page, pageSize,name,gender,begin,end);
        return Result.success(ResultPage);
    }

}
