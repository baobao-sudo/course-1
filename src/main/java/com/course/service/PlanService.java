package com.course.service;

import com.course.form.PlanForm;
import com.course.form.UpdatePlanForm;
import com.course.vo.ResultVO;

/**
 * @Description 教学计划的设置
 * @ClassName PlanService
 * @Author: baobao
 * @Date: Created in 15:19 2020/10/4
 */
public interface PlanService {

    /**
     * 新增一条教学计划
     * @param planForm
     * @return
     */
    ResultVO addPlan(PlanForm planForm);

    /**
     * 删除教学计划
     * @param planId
     * @return
     */
    ResultVO deletePlan(Integer planId);

    /**
     * 查看所有教学计划
     * @param grade
     * @return
     */
    ResultVO allPlan(Integer grade);


    /**
     * 编辑教学计划
     * @param updatePlanForm
     * @return
     */
    ResultVO editPlan(UpdatePlanForm updatePlanForm);


    /**
     * 获取老师所有的教授的课程
     * @return
     */
    ResultVO teacherPlan();

}
