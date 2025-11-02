package com.jiangxian.service.impl;

import com.jiangxian.mapper.EmpMapper;
import com.jiangxian.pojo.JobOption;
import com.jiangxian.service.ReportService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> jobDataMapList = empMapper.getJobDataMap();
        List<Object> jobList = jobDataMapList.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = jobDataMapList.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getGenderData() {
        List<Map> genderDataList = empMapper.getGenderData();
        return genderDataList;
    }
}
