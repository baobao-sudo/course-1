package com.course.dao;

import com.course.model.Matrix;
import java.util.List;

public interface MatrixMapper {
    int deleteByPrimaryKey(Integer matrixId);

    int insert(Matrix record);

    Matrix selectByPrimaryKey(Integer matrixId);

    List<Matrix> selectAll();

    int updateByPrimaryKey(Matrix record);
}