package com.course.dto;

import lombok.Data;

/**
 * @Description TODO
 * @ClassName StudentDto
 * @Author: baobao
 * @Date: Created in 13:52 2020/10/4
 */
@Data
public class StudentDTO {

    private Integer stuNo;

    private Integer grade;

    private String major;

    private String name;

    private String phone;

    private String email;
}
