package com.jiangxian.service;

import com.jiangxian.pojo.*;

import java.util.List;
import java.util.Map;

public interface StuService {

    ResultPage pageQuery(StuQueryParams stuQueryParams);

    void deleteByIds(List<Integer> ids);

    void addStudent(Student student);

    Student queryStuById(Integer id);

    void updateStu(Student student);

    void violationInfo(Integer id, Short score);

}
