package com.course.service.impl;

import com.alibaba.excel.EasyExcel;
import com.course.dao.*;
import com.course.enums.ResultEnum;
import com.course.form.ListMatrixForm;
import com.course.form.MatrixAttachedFrom;
import com.course.form.MatrixForm;
import com.course.listenter.MatrixListener;
import com.course.model.*;
import com.course.service.MajorCourseService;
import com.course.service.MatrixService;
import com.course.service.UserService;
import com.course.utils.ResultVOUtil;
import com.course.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description 有关课程矩阵相关的
 * @ClassName MatrixServiceImpl
 * @Author: baobao
 * @Date: Created in 21:03 2020/12/2
 */
@Service
@Slf4j
public class MatrixServiceImpl implements MatrixService {

    @Autowired
    private UserService userService;

    @Autowired
    private FirstRequirementMapper firstRequirementMapper;

    @Autowired
    private SecondRequirementMapper secondRequirementMapper;

    @Autowired
    private MajorCourseService majorCourseService;

    @Autowired
    private MajorCourseMapper majorCourseMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private MatrixMapper matrixMapper;


    @Override
    public ResultVO upload(MatrixForm matrixForm) {
        try {
            MatrixAttachedFrom matrixAttachedFrom = new MatrixAttachedFrom();
            matrixAttachedFrom.setGrade(matrixForm.getGrade());
            matrixAttachedFrom.setMajorId(userService.getCurrentUser().getMajorId());
            EasyExcel.read(matrixForm.getMultipartFile().getInputStream(), new MatrixListener(majorCourseService, matrixAttachedFrom)).sheet().doRead();
        } catch (IOException e) {
            return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO list(ListMatrixForm listMatrixForm) {
        List<MajorCourse> majorCourses = majorCourseMapper.selectAllMajorCourse(userService.getCurrentUser().getMajorId(), listMatrixForm.getGrade());
        List<MatrixVO> matrixVOS = new ArrayList<>();
        for (MajorCourse majorCourse : majorCourses) {
            MatrixVO matrixVO = new MatrixVO();
            List<CoursePointVO> coursePointVOS = new ArrayList<>();
            Type type = typeMapper.selectByPrimaryKey(majorCourse.getTypeId());
            Course course = courseMapper.selectByPrimaryKey(majorCourse.getCourseId());
            matrixVO.setCourse(course);
            matrixVO.setType(type);
            List<Matrix> matrices = matrixMapper.selectByMajorCourseId(majorCourse.getMajorCourseId());
            for(Matrix matrix: matrices){
                CoursePointVO coursePointVO = new CoursePointVO();
                SecondRequirement secondRequirement= secondRequirementMapper.selectByMajorCourseId(majorCourse.getMajorId(),matrix.getFirstRequirementNo(),matrix.getSecondRequirementNo());
                coursePointVO.setSecondRequirementId(secondRequirement.getSecondRequirementId());
                coursePointVO.setSecondPoint(matrix.getFirstRequirementNo()+ "." + matrix.getSecondRequirementNo());
                coursePointVO.setWeight(matrix.getWeight());
                coursePointVOS.add(coursePointVO);
            }
            matrixVO.setCoursePointVOS(coursePointVOS);
            matrixVOS.add(matrixVO);
        }
        return ResultVOUtil.success(matrixVOS);
    }

    @Override
    public ResultVO getRequirementByMajor() {
        List<RequirementVO> requirementVOS = new ArrayList<>();
        List<FirstRequirement> firstRequirements = firstRequirementMapper.selectByMajorId(userService.getCurrentUser().getMajorId());
        for (FirstRequirement firstRequirement : firstRequirements) {
            RequirementVO requirementVO = new RequirementVO();
            BeanUtils.copyProperties(firstRequirement, requirementVO);
            List<RequirementVOAttached> requirementVOAttacheds = new ArrayList<>();
            List<SecondRequirement> secondRequirements = secondRequirementMapper.selectByFirstRequirement(firstRequirement.getFirstRequirementId());
            for (SecondRequirement secondRequirement : secondRequirements) {
                RequirementVOAttached requirementVOAttached = new RequirementVOAttached();
                BeanUtils.copyProperties(secondRequirement, requirementVOAttached);
                requirementVOAttached.setSecondRequirementNumber(secondRequirement.getFirstRequirementNo() + "." + secondRequirement.getSecondRequirementNo());
                requirementVOAttacheds.add(requirementVOAttached);
            }
            requirementVO.setRequirementVOAttacheds(requirementVOAttacheds);
            requirementVOS.add(requirementVO);
        }
        return ResultVOUtil.success(requirementVOS);
    }
}
