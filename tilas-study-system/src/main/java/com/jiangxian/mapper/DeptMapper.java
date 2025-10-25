package com.jiangxian.mapper;

import com.jiangxian.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    //    查询所有部门
    @Select("select dept.id,dept.name,dept.create_time,dept.update_time from dept order by update_time desc")
    List<Dept> findAll();

    //    删除部门
    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);

    //    增加部门
    @Insert("insert into dept(name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);
    //    查询部门
    @Select("select id,name,create_time,update_time from dept where id=#{id}")
    Dept getById(Integer id);
    //修改部门
    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);
}
