package com.jiangxian.service.impl;

import com.jiangxian.mapper.EmpMapper;
import com.jiangxian.pojo.Emp;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public ResultPage list(Integer page, Integer pageSize) {
        Long total = empMapper.count();
        Integer start = (page-1)*pageSize;
        List<Emp> list = empMapper.list(start, pageSize);
        return new ResultPage(total,list);
    }
}
