package com.course.dao;

import com.course.model.ModuleBranch;

import java.math.BigDecimal;
import java.util.List;

public interface ModuleBranchMapper {
    int deleteByPrimaryKey(Integer moduleBranchId);

    int insert(ModuleBranch record);

    ModuleBranch selectByPrimaryKey(Integer moduleBranchId);

    List<ModuleBranch> selectAll();

    int updateByPrimaryKey(ModuleBranch record);

    /**
     * 根绝模块号查找所有的
     * @param moduleId
     * @return
     */
    List<ModuleBranch> selectByModuleId(Integer moduleId);

    /**
     * 获取模块的总分
     * @param moduleId
     * @return
     */
    BigDecimal getModuleBranchSum(Integer moduleId);
}