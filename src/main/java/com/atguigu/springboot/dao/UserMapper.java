package com.atguigu.springboot.dao;

import com.atguigu.springboot.pojo.User;
import tk.mybatis.mapper.common.Mapper;


//通用mapper 简化maybtes
//@Repository
public interface UserMapper extends Mapper<User> {

}
