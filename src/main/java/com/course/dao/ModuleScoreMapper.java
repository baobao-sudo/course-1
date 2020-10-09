package com.course.dao;

import com.course.model.ModuleScore;
import java.util.List;

public interface ModuleScoreMapper {
    int deleteByPrimaryKey(Integer moduleScoreId);

    int insert(ModuleScore record);

    ModuleScore selectByPrimaryKey(Integer moduleScoreId);

    List<ModuleScore> selectAll();

    int updateByPrimaryKey(ModuleScore record);
}