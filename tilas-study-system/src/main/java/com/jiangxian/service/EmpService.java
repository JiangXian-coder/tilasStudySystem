package com.jiangxian.service;

import com.jiangxian.pojo.ResultPage;

import java.time.LocalDate;


public interface EmpService {

//    public ResultPage list(Integer page, Integer pageSize);

    public ResultPage list(Integer page, Integer pageSize, String name,
                           Integer gender, LocalDate begin, LocalDate end);
}

