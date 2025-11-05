package com.jiangxian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class StuQueryParams {
    private String name;// 姓名
    private Integer degree;//学历
    private Integer clazzId;//班级id
    private Integer page = 1;// 页码，默认第1页
    private Integer pageSize = 10;// 每页大小，默认10条记录
}
