package com.itzlk.service;

import com.itzlk.mapper.UserMapper;
import com.itzlk.pojo.User;
import org.apache.ibatis.session.SqlSession;

public interface UserService {


    public User select(String username, String password);

    public User selectByUsername(String username);


    public void add(User user);
}
