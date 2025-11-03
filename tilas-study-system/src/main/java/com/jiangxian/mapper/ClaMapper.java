package com.jiangxian.mapper;

import com.jiangxian.pojo.ClaQueryParams;
import com.jiangxian.pojo.Clazz;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClaMapper {
    /**
     * 分页查询班级信息
     * @param claQueryParams 查询参数对象，包含分页和搜索条件
     * @return 班级列表
     */
    List<Clazz> pageQuery(ClaQueryParams claQueryParams);

    /**
     * 根据ID删除班级信息
     * @param id 班级ID
     */
    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    /**
     * 添加班级信息
     * @param clazz 班级对象
     */
    void addCla(Clazz clazz);

    /**
     * 根据ID获取班级信息
     * @param id 班级ID
     * @return 班级对象
     */
    @Select("select c.* from clazz as c where id = #{id}")
    Clazz getClaById(Integer id);

    /**
     * 获取所有班级信息
     * @return 班级列表
     */
    List<Clazz> getAllCla();

    /**
     * 根据ID更新班级信息
     * @param clazz 班级对象，包含要更新的信息
     */
    void updateClaById(Clazz clazz);
}
