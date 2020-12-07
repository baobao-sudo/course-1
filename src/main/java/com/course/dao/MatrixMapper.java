package com.course.dao;

import com.course.model.Matrix;
import java.util.List;

public interface MatrixMapper {
    int deleteByPrimaryKey(Integer matrixId);

    int insert(Matrix record);

    Matrix selectByPrimaryKey(Integer matrixId);

    List<Matrix> selectAll();

    int updateByPrimaryKey(Matrix record);

    /**
     * 查看这个专业课程下的所有二级指标点
     * @param majorCourseId
     * @return
     */
    List<Matrix> selectByMajorCourseId(Integer majorCourseId);
}