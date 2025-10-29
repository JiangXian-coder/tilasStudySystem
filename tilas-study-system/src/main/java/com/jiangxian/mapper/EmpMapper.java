package com.jiangxian.mapper;

import com.jiangxian.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    //查询数据

    public List<Emp> list(String name, Integer gender, LocalDate begin,LocalDate end);
}
