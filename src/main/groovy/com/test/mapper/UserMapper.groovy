package com.test.mapper

import com.bean.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

public interface UserMapper {
    @Insert('''
       INSERT USER(name,psd) VALUES(@{name},@{psd})     
    ''')
    User insertUser(User user)

    @Select('''
       SELECT * FROM USER WHERE name=@{name}     
    ''')
    User getUserByName(@Param("name") String name)
}