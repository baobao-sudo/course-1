package com.course.service.impl;

import com.course.dao.MajorMapper;
import com.course.enums.ResultEnum;
import com.course.model.Major;
import com.course.service.MajorService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 专业
 * @ClassName MajorServiceImpl
 * @Author: baobao
 * @Date: Created in 19:03 2020/10/10
 */
@Service
@Slf4j
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public ResultVO findAll() {
        List<Major> majors = majorMapper.selectAll();
        if (majors == null) {
            ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success(majors);
    }

    @Override
    public ResultVO addMajor(String majorName) {
        Major major = new Major();
        major.setMajorName(majorName);
        int inset = majorMapper.insert(major);
        if (inset != 1) {
            ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }
}
