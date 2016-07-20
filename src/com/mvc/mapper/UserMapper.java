package com.mvc.mapper;

import com.mvc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Results({
            @Result(property = "id", column = "s_id"),
            @Result(property = "username", column = "s_username"),
            @Result(property = "password", column = "s_password")
    })
    @Select("SELECT s_id, s_username, s_password from s_user")
    List<User> findAll();

    //    "insert into city(name,state,country) values(#{name},#{state},#{country})"
    @Results({
            @Result(property = "id", column = "s_id"),
            @Result(property = "username", column = "s_username"),
            @Result(property = "password", column = "s_password")
    })
    @Insert("insert into s_user(s_username,s_password) values(#{username},#{password})")
    int addUser(User user);

    @Results({
        @Result(property = "id", column = "s_id"),
        @Result(property = "username", column = "s_username"),
        @Result(property = "password", column = "s_password")
    })
    @Select("SELECT s_id, s_username, s_password from s_user where s_username=#{username}")
    User findByUsername(String username);

}
