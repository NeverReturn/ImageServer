package com.test.mapper

import com.bean.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

public interface UserMapper {
    @Insert('''
       INSERT USER(name,password) VALUES(@{name},@{password})     
    ''')
    int insertUser(User user)

    @Select('''
       SELECT * FROM user WHERE name = @{name}     
    ''')
    User getUserByName(@Param("name") String name)
}