package com.itzlk.mapper;

import com.itzlk.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    //注解的方式查询
//    @Select("select * from tb_user where username=#{username} and password=#{password}")
//    User select(@Param("username") String username,@Param("password") String password);

    //配置文件的方式查询
    User select(@Param("username") String username,@Param("password") String password);

    User selectByUsername(@Param("username") String username);

    void add(User user);
}
