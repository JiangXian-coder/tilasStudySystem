package com.jiangxian.controller;

import com.jiangxian.pojo.Result;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.pojo.StuQueryParams;
import com.jiangxian.pojo.Student;
import com.jiangxian.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生管理控制器
 * 提供学生信息的增删改查、分页查询、违纪扣分等功能
 */
@Slf4j
@RestController
public class StuController {

    @Autowired
    private StuService stuService;

    /**
     * 分页查询学生信息
     * @param stuQueryParams 查询参数对象，包含页码、每页条数、搜索关键字等
     * @return 返回分页查询结果
     */
    @GetMapping("/students")
    public Result pageQuery(StuQueryParams stuQueryParams) {
        log.info("分页查询学生信息:{}", stuQueryParams.toString());
        ResultPage resultPage = stuService.pageQuery(stuQueryParams);
        return Result.success(resultPage);
    }

    /**
     * 根据ID列表批量删除学生信息
     * @param ids 要删除的学生ID列表
     * @return 删除结果
     */
    @DeleteMapping("/students/{ids}")
    public Result deleteStuByIds(@PathVariable List<Integer> ids) {
        log.info("删除id为{}的学生", ids.toString());
        stuService.deleteByIds(ids);
        return Result.success();
    }

    /**
     * 添加学生信息
     * @param student 学生对象，包含学生的基本信息
     * @return 添加结果
     */
    @PostMapping("/students")
    public Result addStudent(@RequestBody Student student) {
        log.info("添加学生信息:{}", student.getName());
        stuService.addStudent(student);
        return Result.success();
    }

    /**
     * 根据ID查询学生信息（用于信息回显）
     * @param id 学生ID
     * @return 查询到的学生信息
     */
    @GetMapping("/students/{id}")
    public Result queryStuById(@PathVariable Integer id) {
        log.info("查询id为{}的学生信息", id);
        Student student = stuService.queryStuById(id);
        return Result.success(student);
    }

    /**
     * 更新学生信息
     * @param student 学生对象，包含更新后的学生信息
     * @return 更新结果
     */
    @PutMapping("/students")
    public Result updateStu(@RequestBody Student student){
        log.info("修改学生信息:{}", student.getName());
        stuService.updateStu(student);
        return Result.success();
    }

    /**
     * 学生违纪扣分处理
     * @param id 学生ID
     * @param score 扣分数值
     * @return 处理结果
     */
    @PutMapping("/students/violation/{id}/{score}")
    public Result violationInfo(@PathVariable Integer id,
                                @PathVariable Short score){
        log.info("学生id为{}的违纪扣分:{}", id, score);
        stuService.violationInfo(id, score);
        return Result.success();
    }


//    写于2025/11/5 13：25，实现了学生的分页查询，批量删除，添加，
//    信息回显，修改，违纪扣分功能。

}
