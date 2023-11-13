package com.springbootprj.contractMigrate.controller;

import com.alibaba.fastjson.JSONObject;
import com.springbootprj.contractMigrate.bean.User;
import com.springbootprj.contractMigrate.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public String login(@RequestBody User user) {
        String flag = "error";

        User us =userDao.getUserByMessage(user.getUsername(),user.getPassword());
        System.out.println("user:"+us);
        HashMap<Object, Object> res = new HashMap<>();
        if(us != null)
            flag = "ok";
        res.put("flag",flag);
        res.put("user",us);

        String res_json= JSONObject.toJSONString(res);
        return res_json;
    }
}
