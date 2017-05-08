package com.example;

import com.bean.User;
import com.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/4/23.
 */

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootApplication
public class Test {

    private UserDao userDao;

    @Value("${movie.value:http://cp01-taotianyi.epc.baidu.com:8259/api/v1/softid/154/data}")
    private String name;

    @RequestMapping("/Register/{id}")
    @ResponseBody
    public String Home(@RequestBody User data){
        userDao.insertUser(data);
        return "register success";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String Login(@RequestParam(value = "name") String name,
                        @RequestParam(value = "psd") String psd) {
        System.out.println(name + " " + psd);
        User user = userDao.getPsdByName(name);
        if (user != null && user.getPsd().equals(psd)) {
            return "login success";
        }
        return "login failed";
    }

    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }
}
