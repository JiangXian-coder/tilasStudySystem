package com.jiangxian.mapper;

import com.jiangxian.pojo.Emp;
import com.jiangxian.pojo.EmpQueryParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    //查询数据
    public List<Emp> list(EmpQueryParams empQueryParams);

    //插入员工数据
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone," +
            " job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender}," +
            "#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId}," +
            "#{createTime},#{updateTime})")
    void save(Emp emp);
}
