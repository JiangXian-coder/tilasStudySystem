package com.jiangxian.mapper;

import com.jiangxian.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuMapper {
    List<Student> pageQuery();
}
