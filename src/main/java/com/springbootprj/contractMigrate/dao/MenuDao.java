package com.springbootprj.contractMigrate.dao;

import com.springbootprj.contractMigrate.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
     public List<MainMenu> getMenus();
}
