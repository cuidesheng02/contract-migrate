package com.springbootprj.sportplay.dao;

import com.springbootprj.sportplay.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
     public List<MainMenu> getMenus();
}
