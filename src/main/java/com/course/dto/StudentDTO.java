package com.course.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Description TODO
 * @ClassName StudentDto
 * @Author: baobao
 * @Date: Created in 13:52 2020/10/4
 */
@Data
public class StudentDTO {

    @ExcelProperty("学号")
    private String stuNo;

    @ExcelProperty("年级")
    private Integer grade;

    @ExcelProperty("专业")
    private String majorName;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("手机")
    private String phone;

    @ExcelProperty("邮箱")
    private String email;
}
