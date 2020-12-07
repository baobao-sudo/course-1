package com.course.service.impl;

import com.course.dao.ModuleBranchMapper;
import com.course.dao.ScoreModuleMapper;
import com.course.enums.ResultEnum;
import com.course.form.ModuleBranchForm;
import com.course.form.ModuleBranchUpdateForm;
import com.course.model.ModuleBranch;
import com.course.model.ScoreModule;
import com.course.service.ModuleBranchService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ModuleBranchVO;
import com.course.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 模块下分支以及配分
 * @ClassName ModuleBranchServiceImpl
 * @Author: baobao
 * @Date: Created in 21:50 2020/10/27
 */
@Service
public class ModuleBranchServiceImpl implements ModuleBranchService {

    @Autowired
    private ModuleBranchMapper moduleBranchMapper;

    @Autowired
    private ScoreModuleMapper scoreModuleMapper;

    @Override
    public ResultVO addModuleBranch(ModuleBranchForm moduleBranchForm) {
        ModuleBranch moduleBranch = new ModuleBranch();
        BeanUtils.copyProperties(moduleBranchForm,moduleBranch);
        int res = moduleBranchMapper.insert(moduleBranch);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO deleteModuleBranch(Integer moduleBranchId) {
        int res = moduleBranchMapper.deleteByPrimaryKey(moduleBranchId);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO editModuleBranch(ModuleBranchUpdateForm moduleBranchUpdateForm) {
        ModuleBranch moduleBranch = moduleBranchMapper.selectByPrimaryKey(moduleBranchUpdateForm.getModuleBranchId());
        BeanUtils.copyProperties(moduleBranchUpdateForm,moduleBranch);
        int res = moduleBranchMapper.updateByPrimaryKey(moduleBranch);
        if(res == -1){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO allModuleBranch(Integer moduleId) {
        ModuleBranchVO moduleBranchVO = new ModuleBranchVO();
        ScoreModule scoreModule = scoreModuleMapper.selectByPrimaryKey(moduleId);
        BeanUtils.copyProperties(scoreModule,moduleBranchVO);
        List<ModuleBranch> moduleBranches = moduleBranchMapper.selectByModuleId(moduleId);
        moduleBranchVO.setModuleBranches(moduleBranches);
        return ResultVOUtil.success(moduleBranchVO);
    }
}
