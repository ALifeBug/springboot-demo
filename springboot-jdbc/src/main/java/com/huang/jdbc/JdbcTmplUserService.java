package com.huang.jdbc;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface JdbcTmplUserService {
    User getUser(Long id);

    List<Map<String,Object>> getMap(Long id);

    List<User> findUsers(String userName, String note);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);

    String getName(Long id);

    User getUser2(Long id);

    User getUser3(Long id);
}
