package com.course.vo;

import lombok.Data;

/**
 * @Description 选课的时候返回老师
 * @ClassName TeacherVO
 * @Author: baobao
 * @Date: Created in 22:06 2020/12/6
 */
@Data
public class TeacherVO {

    private Integer userId;

    private String cardId;

    private String name;
}
