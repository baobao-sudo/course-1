package com.course.dao;

import com.course.model.MajorCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



/**
 * @Description TODO
 * @ClassName MajorCourseMapperTest
 * @Author: baobao
 * @Date: Created in 20:06 2020/12/6
 */
@SpringBootTest
class MajorCourseMapperTest {

    @Autowired
    private MajorCourseMapper majorCourseMapper;

    @Test
    public void insert(){
        MajorCourse majorCourse = new MajorCourse();
        majorCourse.setTypeId(1);
        majorCourse.setGrade(2018);
        majorCourse.setMajorId(2);
        majorCourse.setCourseId(95);
        majorCourseMapper.insert(majorCourse);
        System.out.println(majorCourse.getMajorCourseId());

    }

}