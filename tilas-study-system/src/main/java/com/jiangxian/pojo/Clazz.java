package com.jiangxian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 班级实体类
 * 用于表示系统中的班级信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private Integer id;//Id - 班级唯一标识符
    private String name;//班级名称 - 班级的名称
    private Integer room;//班级教室 - 教室编号
    private LocalDate beginDate;//开始日期 - 班级开课日期
    private LocalDate endDate;//结束日期 - 班级结课日期
    private Integer masterId;//班主任ID - 负责该班级的教师ID
    private Integer subject;//科目 - 班级所学的科目
    private LocalDateTime createTime;//创建时间 - 记录创建时间
    private LocalDateTime updateTime;//更新时间 - 记录最后更新时间


    private String masterName;//班主任姓名 - 负责该班级的教师姓名
    private String status;//班级状态 - 班级当前的状态(如:进行中、已结束等)
}