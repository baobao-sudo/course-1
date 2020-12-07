package com.course.service.impl;

import com.course.dao.FirstRequirementMapper;
import com.course.dao.SecondRequirementMapper;
import com.course.enums.ResultEnum;
import com.course.form.SecondRequirementForm;
import com.course.form.SecondRequirementUpdateFrom;
import com.course.model.FirstRequirement;
import com.course.model.SecondRequirement;
import com.course.service.SecondRequirementService;
import com.course.utils.ResultVOUtil;
import com.course.vo.FirstSecondRequirementsVO;
import com.course.vo.ResultVO;
import com.course.vo.SecondRequirementVO;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 实现二级指标点
 * @ClassName SecondRequirementServiceImpl
 * @Author: baobao
 * @Date: Created in 20:25 2020/10/10
 */
@Service
@Slf4j
public class SecondRequirementServiceImpl implements SecondRequirementService {

    @Autowired
    private SecondRequirementMapper secondRequirementMapper;

    @Autowired
    private FirstRequirementMapper firstRequirementMapper;


    @Override
    public ResultVO addSecondRequirement(SecondRequirementForm secondRequirementForm) {
        SecondRequirement secondRequirement = new SecondRequirement();
        BeanUtils.copyProperties(secondRequirementForm,secondRequirement);
        int firstRequirementNo = firstRequirementMapper.getFirstRequirementNo(secondRequirementForm.getFirstRequirementId());
        secondRequirement.setFirstRequirementNo(firstRequirementNo);
        int res = secondRequirementMapper.insert(secondRequirement);
        if(res == -1){
            ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO editSecondRequirement(SecondRequirementUpdateFrom secondRequirementUpdateFrom) {
        SecondRequirement secondRequirement = secondRequirementMapper.selectByPrimaryKey(secondRequirementUpdateFrom.getSecondRequirementId());
        BeanUtils.copyProperties(secondRequirementUpdateFrom,secondRequirement);
        int res = secondRequirementMapper.updateByPrimaryKey(secondRequirement);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO deleteSecondRequirement(Integer secondRequirementId) {
        int res = secondRequirementMapper.deleteByPrimaryKey(secondRequirementId);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO findAllSecondRequirement(Integer firstRequirementId) {
        List<SecondRequirement> secondRequirements = secondRequirementMapper.selectByFirstRequirement(firstRequirementId);
        if(secondRequirements == null){
            ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        List<SecondRequirementVO> secondRequirementVOS = new ArrayList<>();
        for(SecondRequirement secondRequirement:secondRequirements){
            SecondRequirementVO secondRequirementVO = new SecondRequirementVO();
            BeanUtils.copyProperties(secondRequirement ,secondRequirementVO);
            secondRequirementVO.setSecondRequirementSequence(secondRequirement.getFirstRequirementNo()+"." +secondRequirement.getSecondRequirementNo());
            secondRequirementVOS.add(secondRequirementVO);
        }
        FirstSecondRequirementsVO firstSecondRequirementsVO = new FirstSecondRequirementsVO();
        FirstRequirement firstRequirement = firstRequirementMapper.selectByPrimaryKey(firstRequirementId);
        BeanUtils.copyProperties(firstRequirement,firstSecondRequirementsVO);
        firstSecondRequirementsVO.setSecondRequirementVOS(secondRequirementVOS);
        return ResultVOUtil.success(firstSecondRequirementsVO);
    }
}
