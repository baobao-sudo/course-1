package com.course.service;

import com.course.form.MatrixAttachedFrom;
import com.course.vo.ResultVO;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @ClassName MajorCourseService
 * @Author: baobao
 * @Date: Created in 21:46 2020/10/9
 */
public interface MajorCourseService {

    /**
     * 获取当前专业年级的所有课程
     * @param grade
     * @return
     */
    ResultVO findAllMajorCourse(Integer grade);

    /**
     * 存储所有的课程约束
     *
     * @param matrixAttachedFrom
     * @param list               数据list
     */
    void saveData(MatrixAttachedFrom matrixAttachedFrom, List<Map<Integer, String>> list);
}
