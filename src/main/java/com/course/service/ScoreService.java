package com.course.service;

import com.course.form.MatrixAttachedFrom;
import com.course.vo.ResultVO;

import java.util.List;
import java.util.Map;

/**
 * @Description 学生成绩接口
 * @ClassName ScoreService
 * @Author: baobao
 * @Date: Created in 13:35 2020/12/4
 */
public interface ScoreService {

    /**
     * 计算成绩
     *
     * @param planId
     * @return
     */
    ResultVO calculate(Integer planId);

    /**
     * 查看该老师的所有学生成绩
     *
     * @param planId
     * @return
     */
    ResultVO allStudentScore(Integer planId);

}
