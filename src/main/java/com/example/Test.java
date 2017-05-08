package com.example;

import com.bean.User;
import com.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/4/23.
 */

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootApplication
public class Test {

    private final UserDao userDao;

    @RequestMapping("/Register/{id}")
    public String Register(@RequestBody User data){
        userDao.insertUser(data);
        return "register success";
    }

    @RequestMapping("/login")
    public String Login(@RequestParam(value = "name") String name,
                        @RequestParam(value = "password") String password) {
        if (userDao == null) {
            return "userDao is null";
        }
        System.out.println(name + " " + password);
        User user = userDao.getUserByName(name);
        if (user != null && user.getPassword().equals(password)) {
            return "login success";
        }
        return "login failed";
    }

    @RequestMapping("/")
    public String Home() {
        return "This is Home";
    }

    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }
}
