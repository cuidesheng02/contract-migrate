package com.springbootprj.contractMigrate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.springbootprj.contractMigrate.dao")
@SpringBootApplication
public class ContractMigrateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractMigrateApplication.class, args);
    }

}
