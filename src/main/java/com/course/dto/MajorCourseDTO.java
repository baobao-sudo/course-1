package com.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description TODO
 * @ClassName MajorCourceVO
 * @Author: baobao
 * @Date: Created in 20:21 2020/10/9
 */
@Data
public class MajorCourseDTO implements Serializable {

    private Integer majorCourseId;

    private String  courseName;

    private Integer grade;

}
