package com.course.controller;

import com.course.service.MajorService;
import com.course.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 专业相关空控制器
 * @ClassName MajorController
 * @Author: baobao
 * @Date: Created in 18:55 2020/10/10
 */
@RestController
@CrossOrigin
@RequestMapping("/api/major")
@Slf4j
@Api(tags = "专业接口")
public class MajorController {

    @Autowired
    private MajorService majorService;

    @GetMapping("/all")
    @ApiOperation("获取所有的专业")
    public ResultVO findAll(){
    return majorService.findAll();
    }

    @PostMapping("/add")
    @ApiOperation("新增专业")
    public ResultVO addMajor(String majorName){
        return majorService.addMajor(majorName);
    }
}
