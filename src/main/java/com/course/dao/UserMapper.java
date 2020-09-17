package com.course.dao;

import com.course.model.User;
import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();

    User selectUserByUsername(String username);
}