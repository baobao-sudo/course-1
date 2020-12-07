package com.course.service.impl;

import com.course.dao.*;
import com.course.dto.MajorCourseDTO;
import com.course.enums.ResultEnum;
import com.course.form.PlanForm;
import com.course.form.UpdatePlanForm;
import com.course.model.*;
import com.course.service.PlanService;
import com.course.service.UserService;
import com.course.utils.ResultVOUtil;
import com.course.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 教学计划的接口
 * @ClassName PlanServiceImpl
 * @Author: baobao
 * @Date: Created in 15:40 2020/10/4
 */
@Service
@Slf4j
public class PlanServiceImpl  implements PlanService {

    @Autowired
    private PlanMapper planMapper;

    @Autowired
    private MajorCourseMapper majorCourseMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private MatrixMapper matrixMapper;

    @Autowired
    private SecondRequirementMapper secondRequirementMapper;

    @Autowired
    private TargetMapper targetMapper;


    @Override
    public ResultVO addPlan(PlanForm planForm) {
        Plan plan = new Plan();
        BeanUtils.copyProperties(planForm,plan);
        plan.setStatus(0);
        plan.setCardId(planForm.getTeacherId());
        planMapper.insert(plan);
        MajorCourse majorCourse = majorCourseMapper.selectByPrimaryKey(plan.getMajorCourseId());
        List<Matrix> matrices = matrixMapper.selectByMajorCourseId(plan.getMajorCourseId());
        int i = 1;
        for(Matrix matrix: matrices){
            SecondRequirement secondRequirement= secondRequirementMapper.selectByMajorCourseId(majorCourse.getMajorId(),matrix.getFirstRequirementNo(),matrix.getSecondRequirementNo());
            Target target = new Target();
            target.setSecondRequirementId(secondRequirement.getSecondRequirementId());
            target.setPlanId(plan.getPlanId());
            target.setOrder(0);
            target.setDescription("请填写该二级指标点对应课程目标");
            target.setTargetName("课程目标" + i++);
            targetMapper.insert(target);

        }
        return ResultVOUtil.success();
    }



    @Override
    public ResultVO deletePlan(Integer planId) {
        planMapper.deleteByPrimaryKey(planId);
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO allPlan(Integer grade) {
//        List<PlanVO> planVOList = new ArrayList<>();
//        List<Plan> plans = planMapper.selectAllByMajor(userService.getCurrentUser().getMajorId());
//        if(plans == null){
//            ResultVOUtil.error(ResultEnum.NO_RESULTS_WERE_QUERIED);
//        }
//        for (Plan plan:plans) {
//            PlanVO planVO = new PlanVO();
//            BeanUtils.copyProperties(plan,planVO);
//            planVO.setMajorCourseName(majorCourseMapper.selectCourseName(plan.getMajorCourseId()));
//            planVO.setTeacherName(userMapper.selectUserName(plan.getCardId()));
//            planVOList.add(planVO);
//        }
//        return ResultVOUtil.success(planVOList);
       List<MajorCourseVO> majorCourseVOS = new ArrayList<>();
        List<MajorCourseDTO> majorCourseDTOS =  majorCourseMapper.selectMajorCourse(userService.getCurrentUser().getMajorId(),grade);
        for(MajorCourseDTO majorCourseDTO:majorCourseDTOS){
            MajorCourseVO majorCourseVO = new MajorCourseVO();
            BeanUtils.copyProperties(majorCourseDTO,majorCourseVO);
            Plan plan = planMapper.selectByMajorCourseId(majorCourseDTO.getMajorCourseId());
            if(plan == null){
                majorCourseVO.setMajorCourseStatus(false);
            }else{
                PlanVO planVO = new PlanVO();
                BeanUtils.copyProperties(plan,planVO);
                planVO.setTeacherName(userMapper.selectUserName(plan.getCardId()));
                majorCourseVO.setMajorCourseStatus(true);
                majorCourseVO.setPlanVO(planVO);
            }
            majorCourseVOS.add(majorCourseVO);

        }
        return ResultVOUtil.success(majorCourseVOS);

    }

    @Override
    public ResultVO editPlan(UpdatePlanForm updatePlanForm) {
        Plan plan = planMapper.selectByPrimaryKey(updatePlanForm.getPlanId());
        if(plan != null){
            ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }

        BeanUtils.copyProperties(updatePlanForm,plan);
        plan.setCardId(updatePlanForm.getTeacherId());
        int update = planMapper.updateByPrimaryKey(plan);
        if(update != 1){
            return  ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO teacherPlan() {
        //思路是先查询出所有的plan，然后根绝plan查询到所有的MajorCourse，然后开始复制
        List<TeacherPlanVO> teacherPlanVOS = new ArrayList<>();
        List<Plan> plans = planMapper.selectByTeacher(userService.getCurrentUser().getCardId());
        for(Plan plan:plans){
            TeacherPlanVO teacherPlanVO = new TeacherPlanVO();
            MajorCourse majorCourse = majorCourseMapper.selectByPrimaryKey(plan.getMajorCourseId());
            Course course = courseMapper.selectByPrimaryKey(majorCourse.getCourseId());
            teacherPlanVO.setGrade(majorCourse.getGrade());
            teacherPlanVO.setMajorName(majorMapper.selectByPrimaryKey(majorCourse.getMajorId()).getMajorName());
            teacherPlanVO.setCourseName(course.getName());
            teacherPlanVO.setStatus(plan.getStatus());
            teacherPlanVO.setComputeTime(plan.getComputeTime());
            teacherPlanVOS.add(teacherPlanVO);
        }
        return ResultVOUtil.success(teacherPlanVOS);
    }
}
