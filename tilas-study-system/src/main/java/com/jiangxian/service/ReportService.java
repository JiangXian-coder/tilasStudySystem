package com.jiangxian.service;

import com.jiangxian.pojo.JobOption;
import com.jiangxian.pojo.StuCountOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 获取员工职位数据
     * @return JobOption 职位数据选项
     */
    JobOption getEmpJobData();

    /**
     * 获取性别统计数据
     * @return List<Map> 性别统计列表
     */
    List<Map> getGenderData();

    /**
     * 获取学生学历分布数据
     * @return List<Map> 学历分布列表
     */
    List<Map> getStudentDegreeData();

    /**
     * 获取学生数量统计数据
     * @return StuCountOption 学生数量统计选项
     */
    StuCountOption getStudentCountData();
}
