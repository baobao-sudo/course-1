package com.course.service;

import com.course.form.CourseForm;
import com.course.form.UpdateCourseForm;
import com.course.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 课程的service 进行课程的增加查询之类的
 * @ClassName CourseService
 * @Author: baobao
 * @Date: Created in 22:15 2020/12/2
 */
public interface CourseService {

    /**
     * 通过文件新增课程
     * @param multipartFile
     * @return
     */
    ResultVO uploadCourse(MultipartFile multipartFile);

    /**
     * 单个新增课程
     * @param courseForm
     * @return
     */
    ResultVO addCourse(CourseForm courseForm);

    /**
     * 更新课程
     * @param updateCourseForm
     * @return
     */
    ResultVO updateCourse(UpdateCourseForm updateCourseForm);
}
