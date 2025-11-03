package com.jiangxian.pojo;

import java.time.LocalDateTime;

public class StuQueryParams {
    private String name;// 姓名
    private LocalDateTime begin;// 开始时间
    private LocalDateTime end;// 结束时间
    private Integer page = 1;// 页码，默认第1页
    private Integer pageSize = 10;// 每页大小，默认10条记录
}
