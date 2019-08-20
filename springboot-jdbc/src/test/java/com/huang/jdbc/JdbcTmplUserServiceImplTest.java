package com.huang.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTmplUserServiceImplTest {

    @Autowired
    JdbcTmplUserService jdbcTmplUserService;

    @Test
    public void getUser() {
        User user = jdbcTmplUserService.getUser(1L);
        System.out.println(user);
    }

    @Test
    public void findUsers() {
        List<User> userList = jdbcTmplUserService.findUsers("hqs","me");
        System.out.println(userList);
    }

    @Test
    public void insertUser() {
        User user = new User(2L,"sccy",SexEnum.getEnumById(2),"ojbk");
        jdbcTmplUserService.insertUser(user);
    }

    @Test
    public void updateUser() {
        User user = new User(1L,"hhh",SexEnum.getEnumById(1),"new user");
        jdbcTmplUserService.updateUser(user);
    }

    @Test
    public void deleteUser() {
        jdbcTmplUserService.deleteUser(2L);
    }

    @Test
    public void getName() {
        String name = jdbcTmplUserService.getName(1L);
        System.out.println(name);
    }

    @Test
    public void getMap(){
        List<Map<String,Object>> list = jdbcTmplUserService.getMap(1L);
        System.out.println(list);
    }

    @Test
    public void getUser2() {
        User user = jdbcTmplUserService.getUser2(1L);
        System.out.println(user);
    }

    @Test
    public void getUser3() {
        User user = jdbcTmplUserService.getUser3(1L);
        System.out.println(user);
    }
}