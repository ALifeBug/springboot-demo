package com.huang.mapper.test;

import com.huang.enums.UserSexEnum;
import com.huang.mapper.test1.User1Mapper;
import com.huang.mapper.test2.User2Mapper;
import com.huang.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class User2MapperTest {

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @Test
    public void save(){
        User user1 = new User();
        user1.setUserName("hqs");
        user1.setPassWord("123");
        user1.setUserSex(UserSexEnum.MAN);
        user1Mapper.insert(user1);

        User user2 = new User();
        user2.setUserName("sccy");
        user2.setPassWord("666");
        user2.setUserSex(UserSexEnum.WOMAN);
        user2Mapper.insert(user2);
    }
}