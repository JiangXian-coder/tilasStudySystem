package com.jiangxian.mapper;

import com.jiangxian.pojo.StuQueryParams;
import com.jiangxian.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StuMapper {
    /**
     * 分页查询学生信息
     * @param stuQueryParams 查询参数对象，包含分页和搜索条件
     * @return 学生列表
     */
    List<Student> pageQuery(StuQueryParams stuQueryParams);

    /**
     * 根据ID列表批量删除学生信息
     * @param ids 要删除的学生ID列表
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 添加学生信息
     * @param student 学生对象
     */
    void addStudent(Student student);

    /**
     * 根据ID查询学生信息
     * @param id 学生ID
     * @return 学生对象
     */
    Student queryStuById(Integer id);

    /**
     * 更新学生信息
     * @param student 学生对象
     */
    void updateStu(Student student);

    List<Map> getStudentDegreeData();

    List<Map<String, Object>> getStudentClazzData();
}
