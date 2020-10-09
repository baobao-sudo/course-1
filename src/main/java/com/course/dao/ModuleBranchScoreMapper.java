package com.course.dao;

import com.course.model.ModuleBranchScore;
import java.util.List;

public interface ModuleBranchScoreMapper {
    int deleteByPrimaryKey(Integer moduleBranchScoreId);

    int insert(ModuleBranchScore record);

    ModuleBranchScore selectByPrimaryKey(Integer moduleBranchScoreId);

    List<ModuleBranchScore> selectAll();

    int updateByPrimaryKey(ModuleBranchScore record);
}