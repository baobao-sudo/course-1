package com.course.service;

import com.course.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description 专业相关的操作
 * @ClassName MajorService
 * @Author: baobao
 * @Date: Created in 19:00 2020/10/10
 */
public interface MajorService {


    /**
     * 得到所有的专业
     * @return
     */
    ResultVO findAll();


    /**
     * 新增专业
     * @param majorName 专业名称
     * @return
     */
    ResultVO addMajor(String majorName);
}
