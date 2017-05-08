package com.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.mapper.UserMapper;
import com.bean.User;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/7.
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserDao {

    private final UserMapper userMapper;

    public User insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
