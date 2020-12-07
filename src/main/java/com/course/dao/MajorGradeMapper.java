package com.course.dao;

import com.course.model.MajorGrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MajorGradeMapper {
    int deleteByPrimaryKey(Integer majorGradeId);

    int insert(MajorGrade record);

    MajorGrade selectByPrimaryKey(Integer majorGradeId);

    List<MajorGrade> selectAll();

    int updateByPrimaryKey(MajorGrade record);

    /**
     * 查找改专业最新年级
     * @param majorId
     * @return
     */
    int findMinGrade(Integer majorId);

    /**
     * 删除年级
     * @param grade
     * @param majorId
     * @return
     */
    int deleteGrade(@Param("grade") Integer grade, @Param("majorId") Integer majorId);


}