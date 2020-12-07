package com.course.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 用于展示所有的学生给专业负责人
 * @ClassName StudentVO
 * @Author: baobao
 * @Date: Created in 15:51 2020/10/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVO implements Serializable {
    private static final long serialVersionUID = -4157037691425252181L;

    private Integer stuId;

    private String stuNo;

    private String name;

    private String phone;

    private String email;
}
