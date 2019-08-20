package com.huang.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@Component
public class JdbcTmplUserServiceImpl implements JdbcTmplUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private RowMapper<User> getUserMapper(){
        RowMapper<User> userRowMapper = (ResultSet rs,int rownum)->{
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            int sexId = rs.getInt("sex");
            SexEnum sex = SexEnum.getEnumById(sexId);
            user.setSex(sex);
            user.setNote(rs.getString("note"));
            return user;
        };
        return userRowMapper;
    }

    @Override
    public User getUser(Long id) {
        String sql = "select id,user_name,sex,note from t_user where id = ?";
        Object[] params = new Object[]{id};
        User user = jdbcTemplate.queryForObject(sql,getUserMapper(),params);
        //User user = jdbcTemplate.queryForObject(sql,getUserMapper(),id);
        return user;
    }

    @Override
    public List<Map<String, Object>> getMap(Long id) {
        String sql = "select id,user_name,sex,note from t_user where id = ?";
        return jdbcTemplate.queryForList(sql,id);
    }

    @Override
    public String getName(Long id) {
        String sql = "select user_name from t_user where id = ?";
        Object[] params = new Object[]{id};
        //String name = jdbcTemplate.queryForObject(sql,String.class,id);
        String name = jdbcTemplate.queryForObject(sql,params,String.class);
        return name;
    }

    @Override
    public User getUser2(Long id) {
        User result = jdbcTemplate.execute((Statement stmt)->{
            String sql = "select count(*) total from t_user where id= "+id;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int total = rs.getInt("total");
                System.out.println(total);
            }

            String sql1 = "select id ,user_name,sex,note from t_user " +
                    "where id = "+id;
            ResultSet rs1 = stmt.executeQuery(sql1);
            User user = null;
            while(rs1.next()){
                int rowNum = rs1.getRow();
                user = getUserMapper().mapRow(rs1,rowNum);
            }
            return user;
        });
        return result;
    }

    @Override
    public User getUser3(Long id) {
        return jdbcTemplate.execute((Connection conn)->{
            String sql = "select count(1) as total from t_user " +
                    "where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("total"));
            }

            String sql1 = "select id,user_name,sex,note from t_user " +
                    "where id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setLong(1,id);
            ResultSet rs1 = ps1.executeQuery();
            User user = null;
            while(rs1.next()){
                int rowNum = rs1.getRow();
                user = getUserMapper().mapRow(rs1,rowNum);
            }
            return user;
        });
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        String sql = "select id,user_name,sex,note from t_user " +
                "where user_name like concat('%',?,'%') " +
                "and note like concat('%',?,'%')";
        Object[] params = new Object[]{userName,note};
        List<User> userList = jdbcTemplate.query(sql,params,getUserMapper());
        //List<User> userList = jdbcTemplate.query(sql,getUserMapper(),userName,note);
        return userList;
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into t_user (user_name,sex,note) values(?,?,?)";
        return jdbcTemplate.update(sql,user.getUserName(),user.getSex().getId(),user.getNote());
    }

    @Override
    public int updateUser(User user) {
        String sql = "update t_user set user_name = ?,sex=?,note=? " +
                "where id = ?";
        return jdbcTemplate.update(sql,user.getUserName(),user.getSex().getId(),user.getNote(),user.getId());
    }

    @Override
    public int deleteUser(Long id) {
        String sql = "delete from t_user where id = ?";
        return jdbcTemplate.update(sql,id);
    }

}
