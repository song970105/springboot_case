package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.dao.UserMapper;
import com.atguigu.springboot.pojo.User;
import com.atguigu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.processing.FilerException;
import java.util.List;
@Service
@Transactional(readOnly = true)
public class UserServiceIImpl implements UserService {
//    @Autowired
    @Resource
    UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    //propagation 事务的传播行为7种
    //isolation 事务的隔离级别 4种
    // 1 未提交读 READ_UNCOMMITTED
    // 2  读以提交 READ_COMMITTED   oracle
    // 4  可重复读    REPEATABLE_READ   MySQL默认
    // 问题   数据丢失 脏读 不可重复读 幻读
    @Transactional(propagation = Propagation.REQUIRED,
                    isolation = Isolation.REPEATABLE_READ,
                    rollbackFor = Exception.class,  //所有异常的回滚
                    noRollbackFor = FilerException.class    //这类异常不回滚
    )
    @Override
    public List<User> findAll() {
        //int i =1/0; 运行时异常 spring aop 声明是事务 默认 对于运行时异常进行回滚
       //FilerException wwww = new FilerException("wwww");//编译时异常默认是不回滚
        List<User> users = (List<User>)redisTemplate.boundValueOps("userkey").get();
        if (users==null){//缓存没有
            users = userMapper.selectAll();
            System.out.println("从数据库中users = " + users);
            redisTemplate.boundValueOps("userkey").set(users);
        }else {
            System.out.println("从缓存中users = " + users);
        }
        return users;
    }
}
