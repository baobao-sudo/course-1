package com.course.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description 返回学生成绩
 * @ClassName StudentScoreVO
 * @Author: baobao
 * @Date: Created in 0:35 2020/12/7
 */
@Data
public class StudentScoreVO {

    private String stuNo;

    private BigDecimal totalScore;

}
