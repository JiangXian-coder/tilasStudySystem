package com.jiangxian.controller;

import com.jiangxian.pojo.ClaQueryParams;
import com.jiangxian.pojo.Clazz;
import com.jiangxian.pojo.Result;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.service.ClaService;
import com.jiangxian.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClaController {
    @Autowired
    private StuService stuService;
    @Autowired
    private ClaService claService;

    /**
     * 分页查询班级列表
     *
     * @param claQueryParams 班级查询参数
     * @return 班级分页结果
     */
    @GetMapping
    public Result pageQuery(ClaQueryParams claQueryParams) {
        ResultPage resultPage = claService.pageQuery(claQueryParams);
        log.info("resultPage:{}", resultPage.toString());
        return Result.success(resultPage);
    }

    /**
     * 根据ID删除班级
     *
     * @param id 班级ID
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public Result deleteClaById(@PathVariable Integer id) {
        log.info("删除id为{}的班级", id);
        claService.deleteById(id);
        return Result.success();
    }

    /**
     * 添加班级
     *
     * @param clazz 班级信息
     * @return 添加结果
     */
    @PostMapping
    public Result addCla(@RequestBody Clazz clazz) {
        log.info("添加班级:{}", clazz.toString());
        claService.addCla(clazz);
        return Result.success();
    }
    //查询回显(根据前端的id查询教室)
    @GetMapping("/{id}")
    public Result getClaById(@PathVariable Integer id){
        log.info("查询id为{}的班级",id);
        Clazz clazz = claService.getClaById(id);
        return Result.success(clazz);
    }
    //查询所有的班级信息
    @GetMapping("/list")
    public Result getAllCla(){
        List<Clazz> allCla = claService.getAllCla();
        return Result.success(allCla);
    }
}
