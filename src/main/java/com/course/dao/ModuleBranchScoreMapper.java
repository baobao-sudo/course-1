package com.course.dao;

import com.course.model.ModuleBranchScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleBranchScoreMapper {
    int deleteByPrimaryKey(Integer moduleBranchScoreId);

    int insert(ModuleBranchScore record);

    ModuleBranchScore selectByPrimaryKey(Integer moduleBranchScoreId);

    List<ModuleBranchScore> selectAll();

    int updateByPrimaryKey(ModuleBranchScore record);

    /**
     * 获取模块下学生所有小题的成绩
     * @param moduleId
     * @param stuNo
     * @return
     */
    List<ModuleBranchScore> selectByModuleId(@Param("moduleId") Integer moduleId, @Param("stuNo") String stuNo);
}