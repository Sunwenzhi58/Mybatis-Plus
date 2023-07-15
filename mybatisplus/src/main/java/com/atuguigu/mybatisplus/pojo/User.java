package com.atuguigu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

@Data
//设置实体类对应的表名
//@TableName("t_user")
public class User {

    //将属性所对应的字段指定为主键
//    @TableId(value = "uid",type = IdType.AUTO)//用户指定主键的字段,type属性用于主键生成策略
//    没有设置id值时 会使用雪花或者自增
    @TableId("uid")
    private Long id;
    //指定属性所对应的字段名
    @TableField("user_name")
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private Integer isDeleted;


}
