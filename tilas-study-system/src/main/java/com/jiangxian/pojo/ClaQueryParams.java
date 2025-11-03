package com.jiangxian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClaQueryParams {
    // 班级名称查询条件
    private String name;
    // 查询开始时间
    private LocalDateTime begin;
    // 查询结束时间
    private LocalDateTime end;
    // 当前页码，默认为第1页
    private Integer page = 1;
    // 每页显示记录数，默认为10条
    private Integer pageSize = 10;
}
