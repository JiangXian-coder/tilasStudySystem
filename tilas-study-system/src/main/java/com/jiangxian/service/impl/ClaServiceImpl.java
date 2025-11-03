package com.jiangxian.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jiangxian.mapper.ClaMapper;
import com.jiangxian.pojo.ClaQueryParams;
import com.jiangxian.pojo.Clazz;
import com.jiangxian.pojo.ResultPage;
import com.jiangxian.service.ClaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClaServiceImpl implements ClaService {
    @Autowired
    private ClaMapper claMapper;

    /**
     * 分页查询班级信息
     * @param claQueryParams 查询参数对象，包含页码和每页大小等信息
     * @return 返回封装了总记录数和当前页数据的结果对象
     */
    @Override
    public ResultPage pageQuery(ClaQueryParams claQueryParams) {
        // 使用PageHelper进行分页设置
        PageHelper.startPage(claQueryParams.getPage(), claQueryParams.getPageSize());
        // 执行查询获取班级列表
        List<Clazz> clazzes = claMapper.pageQuery(claQueryParams);
        // 转换为Page对象以获取分页信息
        Page<Clazz> pageList = (Page<Clazz>) clazzes;
        // 封装分页结果
        return new ResultPage(pageList.getTotal(), pageList.getResult());
    }

    /**
     * 根据ID删除班级信息
     * @param id 班级ID
     */
    @Override
    public void deleteById(Integer id) {
        claMapper.deleteById(id);
    }

    /**
     * 添加新的班级信息
     * @param clazz 班级对象
     */
    @Override
    public void addCla(Clazz clazz) {
        // 设置创建时间和更新时间
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        // 执行添加操作
        claMapper.addCla(clazz);
    }

    /**
     * 根据ID获取班级详细信息
     * @param id 班级ID
     * @return 班级对象
     */
    @Override
    public Clazz getClaById(Integer id) {
        Clazz clazz = claMapper.getClaById(id);
        return clazz;
    }

    /**
     * 获取所有班级信息
     * @return 班级列表
     */
    @Override
    public List<Clazz> getAllCla() {
        List<Clazz> allCla = claMapper.getAllCla();
        return allCla;
    }

    /**
     * 更新班级信息
     * @param clazz 班级对象
     */
    @Override
    public void updateCla(Clazz clazz) {
        // 更新最后修改时间
        clazz.setUpdateTime(LocalDateTime.now());
        // 执行更新操作
        claMapper.updateClaById(clazz);
    }
}
