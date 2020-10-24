package com.atguigu.springboot;

import com.atguigu.springboot.dao.UserMapper;
import com.atguigu.springboot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)//以spring方式启动
@SpringBootTest
public class UserMapperTest {
//    @Autowired
    @Resource
    UserMapper userMapper;

    @Test//注意导包 导入 org junit.test(junit4版本)
    public void testSelectAll(){
        try {
            List<User> users = userMapper.selectAll();
            System.out.println("users = " + users);
        } catch (Exception e) {
            e.printStackTrace();
            //将来可以抛自定义异常
        }
    }
}
