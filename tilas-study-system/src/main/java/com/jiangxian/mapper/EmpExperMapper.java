package com.jiangxian.mapper;

import com.jiangxian.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExperMapper {

    //批量插入员工经历
    public void insertBatch(List<EmpExpr> exprList);

    //批量删除工作经历
    void deleteEmpExperByIds(List<Integer> ids);
}
