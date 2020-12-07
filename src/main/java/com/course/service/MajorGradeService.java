package com.course.service;

import com.course.form.MajorGradeForm;
import com.course.vo.ResultVO;

/**
 * @Description TODO
 * @ClassName MajorGradeService
 * @Author: baobao
 * @Date: Created in 16:57 2020/10/29
 */
public interface MajorGradeService {

    /**
     * 新增年级
     * @param majorGradeForm
     * @return
     */
    ResultVO addGrade(MajorGradeForm majorGradeForm);

    /**
     * 删除年级
     * @param grade
     * @return
     */
    ResultVO deleteGrade(Integer grade);


}
