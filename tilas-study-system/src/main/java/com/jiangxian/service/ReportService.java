package com.jiangxian.service;

import com.jiangxian.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map> getGenderData();
}
