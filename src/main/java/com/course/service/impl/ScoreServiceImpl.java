package com.course.service.impl;

import com.course.dao.*;
import com.course.form.MatrixAttachedFrom;
import com.course.model.*;
import com.course.service.ScoreService;

import com.course.utils.ResultVOUtil;
import com.course.vo.CourseStudentScoreVO;
import com.course.vo.ResultVO;
import com.course.vo.StudentBranchScoreVO;
import com.course.vo.StudentScoreVO;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description 成绩计算
 * @ClassName ScoreServiceImpl
 * @Author: baobao
 * @Date: Created in 15:08 2020/12/5
 */
@Service
@Slf4j
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private ScoreModuleMapper scoreModuleMapper;

    @Autowired
    private MajorCourseMapper majorCourseMapper;

    @Autowired
    private PlanMapper planMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ModuleScoreMapper moduleScoreMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public ResultVO calculate(Integer planId) {
        //获取课程的所有的模块及他们的百分比
        List<ScoreModule> scoreModules = scoreModuleMapper.selectByPlanId(planId);
        Plan plan = planMapper.selectByPrimaryKey(planId);
        //获取这个课程的信息
        MajorCourse majorCourse = majorCourseMapper.selectByPrimaryKey(plan.getMajorCourseId());
        //获取所有的学生
        List<Student> students = studentMapper.selectStudents(majorCourse.getMajorId(),majorCourse.getGrade());
        for(Student student:students){
            BigDecimal studentScore = new BigDecimal(0);
            for(ScoreModule scoreModule:scoreModules){
                ModuleScore moduleScore = moduleScoreMapper.selectByStudentAndModuleId(student.getStuNo(),scoreModule.getModuleId());
                studentScore = studentScore.add(moduleScore.getPoint().multiply(scoreModule.getPercentage()));
            }
            Score score = new Score();
            score.setMajorCourseId(plan.getMajorCourseId());
            score.setStuNo(student.getStuNo());
            score.setTotalScore(studentScore);
            scoreMapper.insert(score);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO allStudentScore(Integer planId) {

        Plan plan = planMapper.selectByPrimaryKey(planId);
        //获取这个课程的信息
        MajorCourse majorCourse = majorCourseMapper.selectByPrimaryKey(plan.getMajorCourseId());
        //获取课程信息
        Course course = courseMapper.selectByPrimaryKey(majorCourse.getCourseId());
        //获取所有的学生
        List<Student> students = studentMapper.selectStudents(majorCourse.getMajorId(),majorCourse.getGrade());
        CourseStudentScoreVO courseStudentScoreVO = new CourseStudentScoreVO();
        courseStudentScoreVO.setMajorCourseId(majorCourse.getMajorCourseId());
        courseStudentScoreVO.setCourseName(course.getName());
        List<StudentScoreVO> studentScoreVOS = new ArrayList<>();
        for(Student student:students){
           StudentScoreVO studentScoreVO = new StudentScoreVO();
           Score score = scoreMapper.selectByPrimaryKey(student.getStuNo());
            BeanUtils.copyProperties(score,studentScoreVO);
            studentScoreVOS.add(studentScoreVO);
        }
        courseStudentScoreVO.setStudentScoreVOS(studentScoreVOS);
        return ResultVOUtil.success(studentScoreVOS);
    }

}
