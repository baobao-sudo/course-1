package com.course.service;

import com.course.form.ModuleForm;
import com.course.form.ModuleUpdateForm;
import com.course.vo.ResultVO;

import java.util.List;


/**
 * @Description 用于分数模块
 * @ClassName ModuleService
 * @Author: baobao
 * @Date: Created in 21:23 2020/10/23
 */
public interface ModuleService {

    /**
     * 增加分数模块
     * @param moduleForm
     * @return
     */
    ResultVO addModule(ModuleForm moduleForm);

    /**
     * 编辑模块
     * @param moduleId
     * @return
     */
    ResultVO deleteModule(Integer moduleId);

    /**
     * 编辑模块
     * @param moduleUpdateForm
     * @return
     */
    ResultVO editModule(ModuleUpdateForm moduleUpdateForm);

    /**
     * 查找全部的模块
     * @param planId 教学计划
     * @return
     */
    ResultVO allModule(Integer planId);

    /**
     * 批量更新
     * @param moduleUpdateForms
     * @return
     */
    ResultVO updateModules(List<ModuleUpdateForm> moduleUpdateForms);


}
