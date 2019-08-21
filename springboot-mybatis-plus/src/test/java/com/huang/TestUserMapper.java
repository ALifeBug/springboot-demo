package com.huang;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huang.pojo.User;
import com.huang.mapper.UserMapper;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserMapper {

    @Autowired
    private UserMapper userMapper;

    /**
     * 插入
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("sccy");
        user.setAge(3);
        user.setEmail("12368176391@qq.com");
        userMapper.insert(user);
        System.out.println(user.getId());
    }

    /**
     * 单个查询
     */
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(3L);
        System.out.println(user);
    }

    /**
     * 集合查询
     */
    @Test
    public void testSelectList(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }


    /**
     * 条件查询
     */
    @Test
    public void testSelectCondition(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("max(id) as id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);

        wrapper = new QueryWrapper<>();
        wrapper.eq("age",21);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);

        wrapper = new QueryWrapper<>();
        wrapper.like("name","hqs").or().eq("id",1);
        users = userMapper.selectList(wrapper);
        System.out.println(users);

        wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("age");
        users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);

        wrapper = new QueryWrapper<>();
        wrapper.gt("age",10);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);

    }

    /**
     * 其他select
     */
    @Test
    public void testSelect(){
        List<Long> ids = Arrays.asList(1L,2L,3L);
        List<User> users = userMapper.selectBatchIds(ids);
        users.forEach(System.out::println);

        Map<String,Object> map = new HashMap<>();
        map.put("age",12);
        map.put("name","hqs");
        users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

    }

    /**
     * 分页查询
     */
    @Test
    public void testSelectPage(){
        System.out.println("----------BaseMapper自带分页---------");
        Page<User> page = new Page<>(1,2);
        IPage<User> userIPage = userMapper.selectPage(page,new QueryWrapper<User>().gt("id",0));
        System.out.println("总条数:"+userIPage.getTotal());
        System.out.println("当前页数:"+userIPage.getCurrent());
        System.out.println("当前每页显示数:"+userIPage.getSize());
        userIPage.getRecords().forEach(System.out::println);
    }

    /**
     * 更新
     */
    @Test
    public void testUpdateById(){
        User user = userMapper.selectById(1L);
        user.setName("update-test");
        userMapper.updateById(user);
        System.out.println(user);
    }

    /**
     * 更新
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setName("update");
        user.setAge(100);
        int update = userMapper.update(user,new UpdateWrapper<User>().eq("name","update-test"));
        System.out.println(update);

        userMapper.update(null, Wrappers.<User>lambdaUpdate().set(User::getEmail,"123@123.com").eq(User::getName,"update"));
    }

    /**
     * 删除
     */
    @Test
    public void testDelete(){
        System.out.println(userMapper.deleteById(5L));
        System.out.println(userMapper.delete(new QueryWrapper<User>().eq("name","ww")));
    }
}
