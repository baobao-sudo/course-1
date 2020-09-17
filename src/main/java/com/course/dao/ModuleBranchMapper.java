package com.course.dao;

import com.course.model.ModuleBranch;
import java.util.List;

public interface ModuleBranchMapper {
    int deleteByPrimaryKey(Integer moduleBranchId);

    int insert(ModuleBranch record);

    ModuleBranch selectByPrimaryKey(Integer moduleBranchId);

    List<ModuleBranch> selectAll();

    int updateByPrimaryKey(ModuleBranch record);
}