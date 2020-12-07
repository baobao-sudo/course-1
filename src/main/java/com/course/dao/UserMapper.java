package com.course.dao;

import com.course.model.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectUserByUsername(String cardId);

    /**
     * 通过工号获取老师姓名
     * @param cardId
     * @return
     */
    String selectUserName(String cardId);


    /**
     * 通过角色查询到普通教师
     * @param role
     * @return
     */
    List<User> selectByRole(Integer role);



}