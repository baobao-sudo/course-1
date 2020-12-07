package com.course.controller;

import com.course.enums.ResultEnum;
import com.course.form.CourseForm;
import com.course.form.UpdateCourseForm;
import com.course.service.CourseService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * @Description 课程控制器
 * @ClassName CourseController
 * @Author: baobao
 * @Date: Created in 9:22 2020/12/4
 */
@RestController
@CrossOrigin
@Slf4j
@Api(tags = "课程")
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping("/upload")
    @ApiOperation("批量上传课程")
    ResultVO uploadCourse(MultipartFile multipartFile) {
        return courseService.uploadCourse(multipartFile);
    }

    @PostMapping("/add")
    @ApiOperation("新增课程")
    ResultVO addCourse(@Valid CourseForm courseForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return courseService.addCourse(courseForm);
    }

    @PostMapping("/update")
    @ApiOperation("更新课程")
    ResultVO updateCourse(@Valid UpdateCourseForm updateCourseForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return courseService.updateCourse(updateCourseForm);
    }
}
