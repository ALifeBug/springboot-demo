package com.huang.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document//标识为MongoDB的文档
public class User implements Serializable {
    private static final long serialVersionUID = -7895435231819517614L;

    //MongoDB文档编号，主键
    @Id
    private Long id;

    //MongoDB中使用user_name保存属性
    @Field("user_name")
    private String userName;

    private String note;

    //角色列表，如果只想保存引用，可以使用@DBRef标注，则只会保存引用信息，而不是具体的角色信息
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User(Long id, String userName, String note, List<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.note = note;
        this.roles = roles;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", note='" + note + '\'' +
                ", roles=" + roles +
                '}';
    }
}
