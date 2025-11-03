package com.jiangxian.service.impl;

import com.github.pagehelper.PageHelper;
import com.jiangxian.mapper.StuMapper;
import com.jiangxian.pojo.ClaQueryParams;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.pojo.StuQueryParams;
import com.jiangxian.pojo.Student;
import com.jiangxian.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;

}
