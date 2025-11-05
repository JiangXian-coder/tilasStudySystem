package com.jiangxian.service.impl;

import com.jiangxian.mapper.EmpMapper;
import com.jiangxian.mapper.StuMapper;
import com.jiangxian.pojo.JobOption;
import com.jiangxian.pojo.StuCountOption;
import com.jiangxian.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 报表服务实现类
 * 提供各类统计报表数据的查询服务
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StuMapper stuMapper;

    /**
     * 获取员工职位统计图表数据
     * 通过查询员工职位分布情况，封装成JobOption对象返回
     * @return JobOption 职位统计图表数据对象
     */
    @Override
    public JobOption getEmpJobData() {
        // 查询员工职位统计数据
        List<Map<String, Object>> jobDataMapList = empMapper.getJobDataMap();
        // 提取职位名称列表
        List<Object> jobList = jobDataMapList.stream().map(dataMap
                -> dataMap.get("pos")).toList();
        // 提取对应职位人数列表
        List<Object> dataList = jobDataMapList.stream().map(dataMap
                -> dataMap.get("total")).toList();
        // 封装成JobOption对象返回
        return new JobOption(jobList, dataList);
    }

    /**
     * 获取员工性别统计图表数据
     * 直接查询员工性别分布情况并返回
     * @return List<Map> 性别统计图表数据列表
     */
    @Override
    public List<Map> getGenderData() {
        // 查询员工性别统计数据
        List<Map> genderDataList = empMapper.getGenderData();
        return genderDataList;
    }

    /**
     * 获取学生学历统计图表数据
     * 直接查询学生学历分布情况并返回
     * @return List<Map> 学历统计图表数据列表
     */
    @Override
    public List<Map> getStudentDegreeData() {
        // 查询学生学历统计数据
        List<Map> studentDegreeData = stuMapper.getStudentDegreeData();
        return studentDegreeData;
    }

    /**
     * 获取学生班级统计图表数据
     * 通过查询各班级学生人数，封装成StuCountOption对象返回
     * @return StuCountOption 班级学生人数统计图表数据对象
     */
    @Override
    public StuCountOption getStudentCountData() {
        // 查询学生班级统计数据
        List<Map<String, Object>> studentAndClazzData = stuMapper.getStudentClazzData();
        // 提取班级名称列表
        List<Object> clazzList = studentAndClazzData.stream().map(dataMap
                -> dataMap.get("clazzName")).toList();
        // 提取对应班级人数列表
        List<Object> countList = studentAndClazzData.stream().map(dataMap
                -> dataMap.get("count")).toList();
        // 封装成StuCountOption对象返回
        return new StuCountOption(clazzList, countList);
    }
}
