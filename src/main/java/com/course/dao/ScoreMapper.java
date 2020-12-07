package com.course.dao;

import com.course.model.Score;
import java.util.List;

public interface ScoreMapper {
    int deleteByPrimaryKey(String stuNo);

    int insert(Score record);

    Score selectByPrimaryKey(String stuNo);

    List<Score> selectAll();

    int updateByPrimaryKey(Score record);
}