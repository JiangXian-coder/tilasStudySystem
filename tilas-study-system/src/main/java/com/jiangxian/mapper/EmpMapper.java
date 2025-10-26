package com.jiangxian.mapper;

import com.jiangxian.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    //查询数据
    @Select("select e.*,d.name as DeptName from emp e left join dept d on e.dept_id=d.id")
    public List<Emp> list();
}
