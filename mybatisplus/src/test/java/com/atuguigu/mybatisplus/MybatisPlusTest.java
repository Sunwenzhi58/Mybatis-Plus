package com.atuguigu.mybatisplus;

import com.atuguigu.mybatisplus.mapper.UserMapper;
import com.atuguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        //通过条件构造器查询一个list集合，若没有条件，则设置null为参数
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        //实现新增用户信息
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@atguigu.com");
        int result = userMapper.insert(user);
        System.out.println(result);
        System.out.println("id:"+user.getId());
    }
    @Test
    public void testDelete(){
        //通过id删除用户信息
//        int result = userMapper.deleteById(1678973578042957825L);
//        System.out.println(result);
        //根据map集合中设置的map条件删除
//        Map<String, Object> map = new HashMap<>();
//        map.put("name","张三");
//        map.put("age",23);
//        int result = userMapper.deleteByMap(map);
//        System.out.println(result);
        //通过多个id来批量删除
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println(result);
    }

    @Test
    public void testUpdate(){
        //修改用户信息
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@atguigu.com");
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    public void testSelect(){
        //通过id查询用户
//        User user = userMapper.selectById(1L);
//        System.out.println(user);
        //根据多个id查询用户
//        List<Long> list = Arrays.asList(1L, 2L, 3L);
//        List<User> users = userMapper.selectBatchIds(list);
//        users.forEach(System.out::println);
//        Map<String, Object> map = new HashMap<>();
//        //根据map集合中的条件查询用户信息
//        map.put("name","Jack");
//        map.put("age",20);
//        List<User> users = userMapper.selectByMap(map);
//        users.forEach(System.out::println);
        //查询所有数据
//        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);


        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);


    }
}
