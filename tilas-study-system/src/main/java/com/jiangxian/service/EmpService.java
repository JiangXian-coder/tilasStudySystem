package com.jiangxian.service;

import com.jiangxian.pojo.Emp;
import com.jiangxian.pojo.EmpQueryParams;
import com.jiangxian.pojo.ResultPage;

import java.time.LocalDate;


public interface EmpService {

//    public ResultPage list(Integer page, Integer pageSize);

    public ResultPage list(EmpQueryParams empQueryParams);
    public void save(Emp emp);
}

