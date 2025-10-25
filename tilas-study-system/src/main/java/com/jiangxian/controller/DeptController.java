package com.jiangxian.controller;

import com.jiangxian.pojo.Dept;
import com.jiangxian.pojo.Result;
import com.jiangxian.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    //    查询所有部门
    @GetMapping("/depts")
    public Result list() {
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    //    删除指定部门
    @DeleteMapping("/depts")
    public Result deleteById(Integer id) {
        deptService.deleteById(id);
        return Result.success();
    }

    //    新增部门
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
//        System.out.println("新增部门" + dept.getName());
        log.info("新增部门：{}",dept.getName());
        deptService.add(dept);
        return Result.success();
    }
//    查询部门
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable Integer id) {
//        System.out.println("查询部门"+id);
        log.error("查询部门：{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
//    改部门名字
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
//        System.out.println("修改"+dept.getName());
        log.warn("修改：{}",dept.getName());
        deptService.update(dept);
        return Result.success();
    }
}
