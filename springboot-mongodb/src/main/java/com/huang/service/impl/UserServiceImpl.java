package com.huang.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huang.pojo.User;
import com.huang.service.UserService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(User user) {
        //若主键已存在，则更新
        mongoTemplate.save(user);
    }

    @Override
    public DeleteResult deleteUser(Long id) {
        Query query = Query.query(Criteria.where("id").is(id));
        return mongoTemplate.remove(query,User.class);//字段，属性都可以
        //mongoTemplate.remove(query,"user"); //必须是文档字段
    }

    @Override
    public List<User> findUser(String userName, int skip, int limit) {
        //将用户名称和备注设置为模糊查询准则
        Criteria criteria = Criteria.where("user_name").regex(userName);//查询条件是类属性或文档字段都可以
        //构建查询条件，并设置分页跳过前skip个，至多返回limit个
        Query query = Query.query(criteria).limit(limit).skip(skip);
        //执行
        List<User> users = mongoTemplate.find(query,User.class);
        return users;
    }

    @Override
    public UpdateResult upsertUser(Long id, String userName, String note) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update().set("user_name",userName).set("note",note);
        //return mongoTemplate.upsert(query,update,"user");//参数为集合名，必须使用集合的字段
        return mongoTemplate.upsert(query,update,User.class);//如果使用类名，则都可以
    }

    @Override
    public UpdateResult updateUser(Long id, String userName, String note) {
        Query query = Query.query(Criteria.where("id").is(id));
        Update update = Update.update("userName",userName).set("note",note);
        //更新第一个文档
        UpdateResult updateResult = mongoTemplate.updateFirst(query,update,User.class);
        //更新多个对象
        //UpdateResult updateResult = mongoTemplate.updateMulti(query,update,User.class);
        return updateResult;
    }

    @Override
    public User getUser(Long id) {
        return mongoTemplate.findById(id,User.class);
        //如果只需要获取第一个，可以采取如下查询方法
        //Criteria criteria = Criteria.where("id").is(id);
        //Query query = Query.query(criteria);
        //return mongoTemplate.findOne(query,User.class);
    }

    @Override
    public void insertUser(User user) {
        //一次性插入一整个列表，而不用进行遍历操作，效率相对较高
        //若新增数据的主键已经存在，则会抛 org.springframework.dao.DuplicateKeyException 异常提示主键重复，不保存当前数据
        mongoTemplate.insert(user);
    }

    @Override
    public void insertAll(List<User> users) {
        mongoTemplate.insertAll(users);
    }

    @Override
    public void insertNest(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        mongoTemplate.insert(jsonObject,"jsoninsert");
    }
}
