package com.course.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 展示所有教学计划
 * @ClassName PlanVO
 * @Author: baobao
 * @Date: Created in 10:27 2020/10/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanVO  implements Serializable {

    private static final long serialVersionUID = -2102227759683681544L;

    private Integer planId;

    private Integer term;

    private String cardId;

    private String teacherName;

    private Integer status;
}
