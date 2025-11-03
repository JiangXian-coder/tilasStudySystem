package com.jiangxian.controller;

import com.jiangxian.pojo.Emp;
import com.jiangxian.pojo.EmpQueryParams;
import com.jiangxian.pojo.Result;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result queryFenYe(EmpQueryParams empQueryParams) {
        log.warn("查询参数：{} ", empQueryParams);
        ResultPage ResultPage = empService.list(empQueryParams);
        return Result.success(ResultPage);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.warn("保存的员工数据：{} ", emp);
        empService.save(emp);
        return Result.success();
    }

    //删除员工
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("删除id为：{}", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    //查询回显员工
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    //更新员工信息
    @PutMapping
    public Result updateEmp(@RequestBody Emp emp) {
        log.info("更新的员工:{}", emp.toString());
        empService.updateEmp(emp);
        return Result.success();
    }

    //查询所有员工
    @GetMapping("/list")
    public Result queryAllEmp() {
        List<Emp> emps = empService.queryAllEmp();
        return Result.success(emps);
    }

}
