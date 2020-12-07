package com.course.dao;

import com.course.model.Major;
import java.util.List;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer majorId);

    int insert(Major record);

    Major selectByPrimaryKey(Integer majorId);

    List<Major> selectAll();

    int updateByPrimaryKey(Major record);

    /**
     * 通过专业返回专业名字
     * @param majorName
     * @return
     */
    int selectMajorId(String majorName);
}