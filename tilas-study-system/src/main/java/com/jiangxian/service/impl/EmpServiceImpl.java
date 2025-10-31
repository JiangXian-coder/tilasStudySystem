package com.jiangxian.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jiangxian.mapper.EmpExperMapper;
import com.jiangxian.mapper.EmpMapper;
import com.jiangxian.pojo.Emp;
import com.jiangxian.pojo.EmpExpr;
import com.jiangxian.pojo.EmpQueryParams;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExperMapper empExperMapper;

//    @Override
//    public ResultPage list(Integer page, Integer pageSize) {
//        PageHelper.startPage(page, pageSize);
//        List<Emp> empList = empMapper.list();
//        Page<Emp> empPage=(Page<Emp>) empList;
//        return new ResultPage(empPage.getTotal(),empPage.getResult());
//    }

    @Override
    public ResultPage list(EmpQueryParams empQueryParams) {
        PageHelper.startPage(empQueryParams.getPage(),
                empQueryParams.getPageSize());
        List<Emp> list = empMapper.list(empQueryParams);
        Page<Emp> empPage = (Page<Emp>) list;
        return new ResultPage(empPage.getTotal(), empPage.getResult());
    }


    @Transactional(rollbackFor = Exception.class)//事务控制，两个成功操作之后才会提交，
    // 否则回滚,添加属性保证发生任何异常都能回滚
    @Override
    public void save(Emp emp) {
        //设置员工的基本信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.save(emp);

        //插入员工经历
        //获取员工id
        Integer empId = emp.getId();
        //获取经历集合
        List<EmpExpr> exprList = emp.getExprList();
        //判断集合是否为空，并进行插入
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empExperMapper.insertBatch(exprList);
        }
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteEmpByIds(ids);
        empExperMapper.deleteEmpExperByIds(ids);
    }
}
