package com.course.service;

import com.course.form.PlanForm;
import com.course.form.UpdatePlanForm;
import com.course.model.Plan;
import com.course.vo.ResultVO;

/**
 * @Description TODO
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
     * @return
     */
    ResultVO allPlan();


    /**
     * 编辑教学计划
     * @param updatePlanForm
     * @return
     */
    ResultVO editPlan(UpdatePlanForm updatePlanForm);

}
