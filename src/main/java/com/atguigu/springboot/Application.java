package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//设置扫描dao层的包 否则 无法创建到的对象 一定要导入tk.mybatis通用mapper组件包
@MapperScan("com.atguigu.springboot.dao")
@EnableTransactionManagement  //开启声明式事务
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
