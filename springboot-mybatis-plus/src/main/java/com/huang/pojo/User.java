package com.huang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)//数据库自增，否则mybatis-plus会自动生成一个很大的数作为主键
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
