package com.course.dao;

import com.course.model.PointScore;
import java.util.List;

public interface PointScoreMapper {
    int deleteByPrimaryKey(Integer pointScoreId);

    int insert(PointScore record);

    PointScore selectByPrimaryKey(Integer pointScoreId);

    List<PointScore> selectAll();

    int updateByPrimaryKey(PointScore record);
}