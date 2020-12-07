package com.course.dto;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Description 批量上传课程
 * @ClassName CourseDTO
 * @Author: baobao
 * @Date: Created in 22:07 2020/12/3
 */
@Data
public class CourseDTO {

    @ExcelProperty("学分")
    private Double credit;

    @ExcelProperty("课程名")
    private String name;
}
