package com.jiangxian.mapper;

import com.jiangxian.pojo.ClaQueryParams;
import com.jiangxian.pojo.Clazz;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClaMapper {
    List<Clazz> pageQuery(ClaQueryParams claQueryParams);

    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    void addCla(Clazz clazz);

    @Select("select c.* from clazz as c where id = #{id}")
    Clazz getClaById(Integer id);


    List<Clazz> getAllCla();
}
