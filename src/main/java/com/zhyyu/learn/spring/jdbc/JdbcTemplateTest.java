package com.zhyyu.learn.spring.jdbc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author juror
 * @datatime 2019/5/31 15:57
 */
@Component
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void queryAll() {
        List<User> userList = jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setUserName(rs.getString("userName"));
                user.setRoleId(rs.getInt("roleId"));
                user.setCreateDate(rs.getDate("create_date"));
                return user;
            }
        });

        System.out.println(userList);
    }

}
