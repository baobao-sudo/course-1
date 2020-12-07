package com.course.dao;

import com.course.model.ModuleScore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface ModuleScoreMapper {
    int deleteByPrimaryKey(Integer moduleScoreId);

    int insert(ModuleScore record);

    ModuleScore selectByPrimaryKey(Integer moduleScoreId);

    List<ModuleScore> selectAll();

    int updateByPrimaryKey(ModuleScore record);

    /**
     * 获取学生这个模块的成绩
     * @param stuNo
     * @param moduleId
     * @return
     */
    ModuleScore selectByStudentAndModuleId(String stuNo,Integer moduleId);


}