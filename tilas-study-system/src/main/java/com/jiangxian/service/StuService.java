package com.jiangxian.service;

import com.jiangxian.pojo.ClaQueryParams;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.pojo.StuQueryParams;
import com.jiangxian.pojo.Student;

import java.util.List;

public interface StuService {

    ResultPage pageQuery(StuQueryParams stuQueryParams);

    void deleteByIds(List<Integer> ids);

    void addStudent(Student student);

    Student queryStuById(Integer id);

    void updateStu(Student student);

    void violationInfo(Integer id, Short score);
}
