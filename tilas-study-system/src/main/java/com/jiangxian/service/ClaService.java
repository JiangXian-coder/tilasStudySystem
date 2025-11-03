package com.jiangxian.service;

import com.jiangxian.pojo.ClaQueryParams;
import com.jiangxian.pojo.Clazz;
import com.jiangxian.pojo.ResultPage;

import java.util.List;

public interface ClaService {
    //分页查询班级
    ResultPage pageQuery(ClaQueryParams claQueryParams);

    void deleteById(Integer id);

    void addCla(Clazz clazz);

    Clazz getClaById(Integer id);

    List<Clazz> getAllCla();
}
