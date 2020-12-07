package com.course.service.impl;

import com.alibaba.excel.EasyExcel;
import com.course.dao.CourseMapper;
import com.course.dto.CourseDTO;
import com.course.enums.ResultEnum;
import com.course.form.CourseForm;
import com.course.form.UpdateCourseForm;
import com.course.listenter.CourseListener;
import com.course.model.Course;
import com.course.service.CourseService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Description 课程接口
 * @ClassName CourseServiceImpl
 * @Author: baobao
 * @Date: Created in 22:04 2020/12/3
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public ResultVO uploadCourse(MultipartFile multipartFile) {
        try {
            EasyExcel.read(multipartFile.getInputStream(), CourseDTO.class, new CourseListener(courseMapper)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO addCourse(CourseForm courseForm) {

        Course course = new Course();
        BeanUtils.copyProperties(courseForm,course);

        int res = courseMapper.insert(course);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }

        return ResultVOUtil.success();
    }

    @Override
    public ResultVO updateCourse(UpdateCourseForm updateCourseForm) {
        Course course = new Course();

        BeanUtils.copyProperties(updateCourseForm,course);

        int res = courseMapper.updateByPrimaryKey(course);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }
}
