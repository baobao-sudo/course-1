package com.course.dao;

import com.course.model.Score;
import java.util.List;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer stuNo);

    int insert(Score record);

    Score selectByPrimaryKey(Integer stuNo);

    List<Score> selectAll();

    int updateByPrimaryKey(Score record);
}