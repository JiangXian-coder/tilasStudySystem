package com.jiangxian.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jiangxian.mapper.ClaMapper;
import com.jiangxian.pojo.ClaQueryParams;
import com.jiangxian.pojo.Clazz;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.service.ClaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClaServiceImpl implements ClaService {
    @Autowired
    private ClaMapper claMapper;

    @Override  //分页查询班级
    public ResultPage pageQuery(ClaQueryParams claQueryParams) {
        PageHelper.startPage(claQueryParams.getPage(),claQueryParams.getPageSize());
        List<Clazz> clazzes = claMapper.pageQuery(claQueryParams);
        Page<Clazz> pageList = (Page<Clazz>) clazzes;
        return new ResultPage(pageList.getTotal(),pageList.getResult());
    }

    @Override
    public void deleteById(Integer id) {
        claMapper.deleteById(id);
    }

    @Override
    public void addCla(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        claMapper.addCla(clazz);
    }

    @Override
    public Clazz getClaById(Integer id) {
        Clazz clazz = claMapper.getClaById(id);
        return clazz;
    }

    @Override
    public List<Clazz> getAllCla() {
        List<Clazz> allCla = claMapper.getAllCla();
        return allCla;
    }
}
