package com.mvc.service;

import com.mvc.entity.User;
import com.mvc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

	public User findUserByUsername(String username) {
		return userMapper.findByUsername(username);
	}
}
