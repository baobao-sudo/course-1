package com.course.service.impl;

import com.course.dao.SecondRequirementMapper;
import com.course.dao.TargetMapper;
import com.course.enums.ResultEnum;
import com.course.form.TargetForm;
import com.course.form.TargetUpdateFrom;
import com.course.model.Target;
import com.course.service.TargetService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import com.course.vo.TargetVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 教学目标的接口
 * @ClassName TargetServiceImpl
 * @Author: baobao
 * @Date: Created in 20:22 2020/10/14
 */
@Service
@Slf4j
public class TargetServiceImpl implements TargetService {

    @Autowired
    private TargetMapper targetMapper;

    @Autowired
    private SecondRequirementMapper secondRequirementMapper;

    @Override
    public ResultVO addTarget(TargetForm targetForm) {
        Target target = new Target();
        BeanUtils.copyProperties(targetForm,target);
        int res = targetMapper.insert(target);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO editTarget(TargetUpdateFrom updateFrom) {
        Target target = targetMapper.selectByPrimaryKey(updateFrom.getTargetId());
        BeanUtils.copyProperties(updateFrom,target);
        int res = targetMapper.updateByPrimaryKey(target);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO deleteTarget(Integer targetId) {
        int res = targetMapper.deleteByPrimaryKey(targetId);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO findAll(Integer planId) {
        List<Target> targets = targetMapper.selectByPlanId(planId);
        List<TargetVO> targetVOS = new ArrayList<>();
        if(targets == null){
            ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        for(Target target:targets){
            TargetVO targetVO = new TargetVO();
            BeanUtils.copyProperties(target,targetVO);
            targetVO.setSecondRequirementSequence(secondRequirementMapper.selectSecondRequirementSequence(target.getSecondRequirementId()));
            targetVOS.add(targetVO);
        }
        return ResultVOUtil.success(targetVOS);
    }
}
