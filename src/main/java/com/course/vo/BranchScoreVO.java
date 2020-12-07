package com.course.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description 小题展示的数据
 * @ClassName BranchScoreVO
 * @Author: baobao
 * @Date: Created in 15:07 2020/11/26
 */
@Data
public class BranchScoreVO {

    private Integer moduleBranchScoreId;

    private Integer moduleBranchId;

    private BigDecimal point;
}
