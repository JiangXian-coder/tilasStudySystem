package com.jiangxian.service;


import com.jiangxian.pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
