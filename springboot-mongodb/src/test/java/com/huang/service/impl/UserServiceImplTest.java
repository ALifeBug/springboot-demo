package com.huang.service.impl;

import com.huang.pojo.Role;
import com.huang.pojo.User;
import com.huang.service.UserService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void saveUser() {
        Role studentRole = new Role(1L,"student","java");
        Role employeeRole = new Role(2L,"employee","dangdang");
        List<Role> roles = new ArrayList<>();
        roles.add(studentRole);
        roles.add(employeeRole);
        User user = new User(1L,"hqs","superman",roles);
        userService.saveUser(user);
    }

    @Test
    public void deleteUser() {
        DeleteResult deleteResult = userService.deleteUser(1L);
        System.out.println(deleteResult.getDeletedCount());
    }

    @Test
    public void findUser() {
        User user = userService.findUser("hqs",0,1).get(0);
        System.out.println(user);
    }

    @Test
    public void upsertUser() {
        UpdateResult updateResult = userService.upsertUser(2L,"hqs-2","this is a superman");
        System.out.println(updateResult.getMatchedCount());
        System.out.println(updateResult.getUpsertedId());
    }

    @Test
    public void updateUser() {
        UpdateResult updateResult = userService.updateUser(2L,"hqs-No.2","man");
        System.out.println(updateResult.getMatchedCount());
        System.out.println(updateResult.getModifiedCount());
    }

    @Test
    public void getUser() {
        User user = userService.getUser(1L);
        System.out.println(user);
    }

    @Test
    public void insertUser() {
        Role studentRole = new Role(1L,"student","java");
        Role employeeRole = new Role(2L,"employee","dangdang");
        List<Role> roles = new ArrayList<>();
        roles.add(studentRole);
        roles.add(employeeRole);
        User user = new User(1L,"hqs","man",roles);
        userService.insertUser(user);
    }

    @Test
    public void insertAll() {
        Role studentRole = new Role(1L,"student","java");
        Role employeeRole = new Role(2L,"employee","dangdang");
        List<Role> roles = new ArrayList<>();
        roles.add(studentRole);
        roles.add(employeeRole);
        List<User> users = new ArrayList<>();
        users.add(new User(2L,"hqs-2","man",roles));
        users.add(new User(3L,"hqs-3","man",roles));
        users.add(new User(4L,"hqs-4","man",roles));
        users.add(new User(5L,"hqs-5","man",roles));
        users.add(new User(6L,"hqs-6","man",roles));
        userService.insertAll(users);
    }

    @Test
    public void insertNest() {
        String json = "{\"test\":\"jsonobject\"}";
        userService.insertNest(json);
    }


}