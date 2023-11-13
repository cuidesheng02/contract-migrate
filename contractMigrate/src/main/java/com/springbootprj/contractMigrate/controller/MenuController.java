package com.springbootprj.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springbootprj.sportplay.bean.MainMenu;
import com.springbootprj.sportplay.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
public class MenuController {

    @Autowired
    MenuDao menuDao;

    @RequestMapping("/menus")
    public String getAllMenus(){
        HashMap<String, Object> data = new HashMap<>();
        int status = 404;
        List<MainMenu> menus = menuDao.getMenus();
        if(menus != null)
        {
            data.put("menus",menus);
            data.put("flag",200);
        }
        else{
            data.put("flag",404);
        }

        String s= JSONObject.toJSONString(data);
        return s;
    }
}
