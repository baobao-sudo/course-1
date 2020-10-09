package com.course.service.impl;

import com.course.dao.PlanMapper;
import com.course.form.PlanForm;
import com.course.form.UpdatePlanForm;
import com.course.model.Plan;
import com.course.service.PlanService;
import com.course.utils.ResultVOUtil;
import com.course.vo.PlanVO;
import com.course.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @ClassName PlanServiceImpl
 * @Author: baobao
 * @Date: Created in 15:40 2020/10/4
 */
@Service
@Slf4j
public class PlanServiceImpl  implements PlanService {

    @Autowired
    private PlanMapper planMapper;

    @Override
    public ResultVO addPlan(PlanForm planForm) {
        Plan plan = new Plan();
        BeanUtils.copyProperties(planForm,plan);
        plan.setStatus(0);
        planMapper.insert(plan);
        return ResultVOUtil.success();
    }



    @Override
    public ResultVO deletePlan(Integer planId) {
        planMapper.deleteByPrimaryKey(planId);
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO allPlan() {
        List<PlanVO> planVOList = new ArrayList<>();
        List<Plan> plans = planMapper.selectAll();

        return null;
    }

    @Override
    public ResultVO editPlan(UpdatePlanForm updatePlanForm) {

        return null;
    }
}
