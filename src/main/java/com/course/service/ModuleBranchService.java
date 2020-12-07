package com.course.service;

import com.course.form.ModuleBranchForm;
import com.course.form.ModuleBranchUpdateForm;
import com.course.vo.ResultVO;

/**
 * @Description 模块分支配分
 * @ClassName ModuleBranchService
 * @Author: baobao
 * @Date: Created in 19:15 2020/10/24
 */
public interface ModuleBranchService {

    /**
     *增加模块分支
     * @param moduleBranchForm
     * @return
     */
    ResultVO addModuleBranch(ModuleBranchForm moduleBranchForm);

    /**
     * 删除模块
     * @param moduleBranchId
     * @return
     */
    ResultVO deleteModuleBranch(Integer moduleBranchId);

    /**
     * 更新模块
     * @param moduleBranchUpdateForm
     * @return
     */
    ResultVO editModuleBranch(ModuleBranchUpdateForm moduleBranchUpdateForm);

    /**
     * 获取所有的模块分支
     * @param moduleId
     * @return
     */
    ResultVO allModuleBranch(Integer moduleId);


}
