package com.jiangxian.controller;

import com.jiangxian.pojo.Result;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result count(@RequestParam(defaultValue = "1") Integer page
            ,@RequestParam(defaultValue = "10") Integer pageSize){
        log.warn("页码：{},每页条数：{}",page,pageSize);
        ResultPage ResultPage = empService.list(page, pageSize);
        return Result.success(ResultPage);
    }

}
