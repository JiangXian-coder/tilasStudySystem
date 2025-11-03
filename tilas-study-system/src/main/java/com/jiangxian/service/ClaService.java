package com.jiangxian.service;

import com.jiangxian.pojo.ClaQueryParams;
import com.jiangxian.pojo.Clazz;
import com.jiangxian.pojo.ResultPage;

import java.util.List;

public interface ClaService {
    /**
     * 分页查询班级信息
     * @param claQueryParams 班级查询参数
     * @return 班级分页结果
     */
    ResultPage pageQuery(ClaQueryParams claQueryParams);

    /**
     * 根据ID删除班级
     * @param id 班级ID
     */
    void deleteById(Integer id);

    /**
     * 添加班级
     * @param clazz 班级对象
     */
    void addCla(Clazz clazz);

    /**
     * 根据ID获取班级信息
     * @param id 班级ID
     * @return 班级对象
     */
    Clazz getClaById(Integer id);

    /**
     * 获取所有班级列表
     * @return 班级列表
     */
    List<Clazz> getAllCla();

    /**
     * 更新班级信息
     * @param clazz 班级对象
     */
    void updateCla(Clazz clazz);
}
