package com.huang.service;

import com.huang.pojo.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import java.util.List;

public interface UserService {
    /**
     * 保存User
     * @param user
     */
    void saveUser(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    DeleteResult deleteUser(Long id);

    /**
     * 条件查询
     * @param userName
     * @param note
     * @param skip
     * @param limit
     * @return
     */
    List<User> findUser(String userName, int skip, int limit);

    /**
     * 更新
     * @param id
     * @param userName
     * @param note
     * @return
     */
    UpdateResult upsertUser(Long id, String userName, String note);

    /**
     *
     * @param id
     * @param userName
     * @param note
     * @return
     */
    UpdateResult updateUser(Long id, String userName, String note);

    /**
     * id查询
     * @param id
     * @return
     */
    User getUser(Long id);

    /**
     * 插入User
     * @param user
     */
    void insertUser(User user);

    /**
     * 批量插入
     * @param users
     */
    void insertAll(List<User> users);

    /**
     * 插入嵌套文档
     * 这种复杂的数据结构如果直接使用javabean是比较麻烦的，这种比较复杂的数据结构，
     * 只需要拿到json字符串，并将其转换成json对象，即可直接插入到mongodb
     * @param json
     */
    void insertNest(String json);


}
