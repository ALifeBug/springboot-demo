package com.huang.xml.model;

import com.huang.xml.enums.UserSexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by sccy on 2019/7/10/0010.
 */
@Data
@AllArgsConstructor
public class User implements Serializable{

    public static final long serialVersionUID = 1L;
    private Integer id;
    private String userName;
    private String passWord;
    private UserSexEnum userSex;
    private String nickName;

    public User(String userName, String passWord, UserSexEnum userSex) {
        this.userName = userName;
        this.passWord = passWord;
        this.userSex = userSex;
    }

    public User() {
        super();
    }

}
