package com.course.service.impl;

import com.course.dao.ScoreModuleMapper;
import com.course.enums.ResultEnum;
import com.course.form.ModuleForm;
import com.course.form.ModuleUpdateForm;
import com.course.model.ScoreModule;
import com.course.service.ModuleService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 模块
 * @ClassName ModuleServiceImpl
 * @Author: baobao
 * @Date: Created in 11:10 2020/10/24
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ScoreModuleMapper scoreModuleMapper;

    @Override
    public ResultVO addModule(ModuleForm moduleForm) {
        ScoreModule scoreModule = new ScoreModule();
        BeanUtils.copyProperties(moduleForm,scoreModule);
        int res = scoreModuleMapper.insert(scoreModule);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO deleteModule(Integer moduleId) {
        int res = scoreModuleMapper.deleteByPrimaryKey(moduleId);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO editModule(ModuleUpdateForm moduleUpdateForm) {
        ScoreModule scoreModule = new ScoreModule();
        BeanUtils.copyProperties(moduleUpdateForm,scoreModule);
        int res = scoreModuleMapper.updateByPrimaryKey(scoreModule);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO allModule(Integer planId) {
        List<ScoreModule> scoreModules = scoreModuleMapper.selectAll();
        if(scoreModules == null ){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success(scoreModules);
    }

    @Override
    public ResultVO updateModules(List<ModuleUpdateForm> moduleUpdateForms) {
        for(ModuleUpdateForm moduleUpdateForm:moduleUpdateForms){
            ScoreModule scoreModule = new ScoreModule();
            BeanUtils.copyProperties(moduleUpdateForm,scoreModule);
            scoreModuleMapper.updateByPrimaryKey(scoreModule);
        }
        return ResultVOUtil.success();
    }
}
