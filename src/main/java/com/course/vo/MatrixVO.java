package com.course.vo;

import com.course.model.Course;
import com.course.model.Type;
import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @ClassName MatrixVO
 * @Author: baobao
 * @Date: Created in 17:37 2020/12/5
 */
@Data
public class MatrixVO {

    private Type type;

    private Course course;

    private List<CoursePointVO> coursePointVOS;

}
