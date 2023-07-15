package com.atuguigu.mybatisplus;

import com.atuguigu.mybatisplus.mapper.UserMapper;
import com.atuguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("user_name","a")
                        .between("age",20,30)
                                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //查询用户信息，按照年龄的降序排序，若年龄相同则按照id
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                        .orderByAsc("uid");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03(){
        //删除邮箱地址
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println(result);

    }

    @Test
    public void test04(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20).like("user_name","a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("小明");
        user.setEmail("test@atguigu.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println(result);

    }

    @Test
    public void test08(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("user_name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        updateWrapper.set("user_name","小黑").set("email","abc@atguigu.com");
        userMapper.update(null,updateWrapper);
    }
}
