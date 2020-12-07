package com.course.dao;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description 测试二级指标点
 * @ClassName SecondRequirementMapperTest
 * @Author: baobao
 * @Date: Created in 20:23 2020/11/8
 */

@SpringBootTest
class SecondRequirementMapperTest {

    @Autowired
    private SecondRequirementMapper secondRequirementMapper;

    @Test
    public void test(){
        System.out.println(secondRequirementMapper.selectByFirstRequirement(1));
    }

}