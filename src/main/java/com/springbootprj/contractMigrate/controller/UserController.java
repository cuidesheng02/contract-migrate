package com.springbootprj.contractMigrate.controller;

import com.alibaba.fastjson.JSONObject;
import com.springbootprj.contractMigrate.bean.QueryInfo;
import com.springbootprj.contractMigrate.bean.User;
import com.springbootprj.contractMigrate.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserDao udao;


    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo){
        //获取最大列表数和当前编号
        int numbers = udao.getUserCounts("%"+queryInfo.getQuery()+"%");
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();

        List<User> users = udao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        return JSONObject.toJSONString(res);
    }

    @RequestMapping("/userstate")
    public String updateUserState(@RequestParam("id")Integer id,@RequestParam("state")Boolean state)
    {
        int i = udao.updateState(id,state);
        return i > 0 ?"success":"error";
    }

    @RequestMapping("/addUser")
     public String addUser(@RequestBody User user)
     {
         user.setRole("普通用户");
         user.setState(false);
         int i = udao.addUser(user);
         return i > 0?"success":"error";
     }

    @DeleteMapping ( "/deleteUser")
     public String deleteUser(@RequestParam Integer id){
        int i = udao.deleteUser(id);
        return i > 0 ?"success" : "error";
     }

     @RequestMapping("/getupdate")
     public String getUpdateUser(int id)
     {
         User user =udao.getUpdateUser(id);
         String res=JSONObject.toJSONString(user);
         return res;
     }

     @RequestMapping("/edituser")
     public String editUser(@RequestBody User user)
     {
         int i = udao.editUser(user);
         return i > 0 ? "success":"error";
     }
}
