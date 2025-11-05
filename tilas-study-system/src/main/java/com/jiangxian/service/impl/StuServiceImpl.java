package com.jiangxian.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jiangxian.mapper.StuMapper;
import com.jiangxian.pojo.ClaQueryParams;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.pojo.StuQueryParams;
import com.jiangxian.pojo.Student;
import com.jiangxian.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;

    /**
     * 分页查询学生信息
     * @param stuQueryParams 学生查询参数对象，包含页码、每页数量等分页信息
     * @return ResultPage 包含总记录数和当前页数据的结果封装对象
     */
    @Override
    public ResultPage pageQuery(StuQueryParams stuQueryParams) {
        // 使用PageHelper进行分页设置，指定当前页码和每页显示记录数
        PageHelper.startPage(stuQueryParams.getPage(),stuQueryParams.getPageSize());
        // 调用mapper执行分页查询，获取学生列表
        List<Student> students = stuMapper.pageQuery(stuQueryParams);
        // 将查询结果转换为Page对象，以便获取分页相关信息
        Page<Student> studentPage = (Page<Student>) students;
        // 构造并返回分页结果对象，包含总记录数和当前页数据列表
        return new ResultPage(studentPage.getTotal(),studentPage.getResult());
    }

    /**
     * 根据ID列表批量删除学生信息
     * @param ids 需要删除的学生ID列表
     */
    @Override
    public void deleteByIds(List<Integer> ids) {
        stuMapper.deleteByIds(ids);
    }

    /**
     * 添加学生信息
     * @param student 待添加的学生对象
     */
    @Override
    public void addStudent(Student student) {
        // 设置创建时间和更新时间
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        stuMapper.addStudent(student);
    }

    /**
     * 根据ID查询学生信息
     * @param id 学生ID
     * @return 查询到的学生对象
     */
    @Override
    public Student queryStuById(Integer id) {
        Student student = stuMapper.queryStuById(id);
        return student;
    }

    /**
     * 更新学生信息
     * @param student 更新后的学生对象
     */
    @Override
    public void updateStu(Student student) {
        // 设置更新时间
        student.setUpdateTime(LocalDateTime.now());
        stuMapper.updateStu(student);
    }

    /**
     * 更新学生违规信息
     * @param id 学生ID
     * @param score 违规分数
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void violationInfo(Integer id, Short score) {
        // 根据ID查询学生信息
        Student student = stuMapper.queryStuById(id);
        // 判断学生是否有违规记录
        if (student.getViolationScore()==null){
            // 如果没有违规记录，则直接设置违规分数和次数
            student.setViolationScore(score);
            student.setViolationCount((short) 1);
        }else {
            // 如果已有违规记录，则累加违规分数和次数
            student.setViolationScore((short) (student.getViolationScore()+score));
            student.setViolationCount((short) (student.getViolationCount()+1));
        }
        // 更新修改时间
        student.setUpdateTime(LocalDateTime.now());
        // 更新学生信息
        stuMapper.updateStu(student);
    }
}
