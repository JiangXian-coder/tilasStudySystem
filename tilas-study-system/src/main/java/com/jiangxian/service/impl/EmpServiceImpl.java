package com.jiangxian.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jiangxian.mapper.EmpMapper;
import com.jiangxian.pojo.Emp;
import com.jiangxian.pojo.EmpQueryParams;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


//    @Override
//    public ResultPage list(Integer page, Integer pageSize) {
//        PageHelper.startPage(page, pageSize);
//        List<Emp> empList = empMapper.list();
//        Page<Emp> empPage=(Page<Emp>) empList;
//        return new ResultPage(empPage.getTotal(),empPage.getResult());
//    }

    @Override
    public ResultPage list(EmpQueryParams empQueryParams) {
        PageHelper.startPage(empQueryParams.getPage(),
                empQueryParams.getPageSize());
        List<Emp> list = empMapper.list(empQueryParams);
        Page<Emp> empPage=(Page<Emp>) list;
        return new ResultPage(empPage.getTotal(),empPage.getResult());
    }
}
