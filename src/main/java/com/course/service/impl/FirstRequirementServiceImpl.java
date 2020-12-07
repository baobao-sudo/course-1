package com.course.service.impl;

import com.course.dao.FirstRequirementMapper;
import com.course.enums.ResultEnum;
import com.course.form.FirstRequirementForm;
import com.course.form.FirstRequirementUpdateForm;
import com.course.model.FirstRequirement;
import com.course.service.FirstRequirementService;
import com.course.service.UserService;
import com.course.utils.ResultVOUtil;
import com.course.vo.FirstRequirementVO;
import com.course.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 一级指标点的实现
 * @ClassName FirstRequirementServiceImpl
 * @Author: baobao
 * @Date: Created in 19:29 2020/10/10
 */
@Service
@Slf4j
public class FirstRequirementServiceImpl implements FirstRequirementService {

    @Autowired
    private FirstRequirementMapper firstRequirementMapper;

    @Autowired
    private UserService userService;

    @Override
    public ResultVO insertFirstRequirement(FirstRequirementForm firstRequirementForm) {
        FirstRequirement firstRequirement = new FirstRequirement();
        BeanUtils.copyProperties(firstRequirementForm,firstRequirement);
        firstRequirement.setMajorId(userService.getCurrentUser().getMajorId());
        int res = firstRequirementMapper.insert(firstRequirement);
        if(res == -1){
            ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO updateFirstRequirement(FirstRequirementUpdateForm firstRequirementUpdateForm) {
        FirstRequirement firstRequirement = firstRequirementMapper.selectByPrimaryKey(firstRequirementUpdateForm.getFirstRequirementId());
        BeanUtils.copyProperties(firstRequirementUpdateForm,firstRequirement);
        int res = firstRequirementMapper.updateByPrimaryKey(firstRequirement);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO findAllFirstRequirement() {
        List<FirstRequirementVO> firstRequirementVOS = new ArrayList<>();
        List<FirstRequirement> firstRequirements = firstRequirementMapper.selectAll();
        if(firstRequirements == null){
            ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        for(FirstRequirement firstRequirement:firstRequirements){
            FirstRequirementVO firstRequirementVO = new FirstRequirementVO();
            BeanUtils.copyProperties(firstRequirement,firstRequirementVO);
            firstRequirementVOS.add(firstRequirementVO);
        }
        return ResultVOUtil.success(firstRequirementVOS);
    }

    @Override
    public ResultVO deleteFirstRequirement(Integer firstRequirementId) {
        int res = firstRequirementMapper.deleteByPrimaryKey(firstRequirementId);
        if(res == -1){
            ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }
}
