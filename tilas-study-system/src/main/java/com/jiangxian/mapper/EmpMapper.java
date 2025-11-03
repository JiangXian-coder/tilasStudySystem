package com.jiangxian.mapper;

import com.jiangxian.pojo.Emp;
import com.jiangxian.pojo.EmpQueryParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    //查询数据
    public List<Emp> list(EmpQueryParams empQueryParams);

    //插入员工数据
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone," +
            " job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender}," +
            "#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId}," +
            "#{createTime},#{updateTime})")
    void save(Emp emp);

    //批量删除员工基本信息
    void deleteEmpByIds(List<Integer> ids);

    Emp getEmpAndExperById(Integer id);

    void updateById(Emp emp);

    List<Map<String,Object>> getJobDataMap();

    List<Map> getGenderData();

    @Select("select e.* from emp as e")
    List<Emp> queryAllEmp();
}
