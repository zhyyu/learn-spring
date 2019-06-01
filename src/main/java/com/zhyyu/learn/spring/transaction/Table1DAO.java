package com.zhyyu.learn.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Component
public class Table1DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Table1 table1) {
        jdbcTemplate.update("insert into table1 (col1, col2) value (?, ?)", table1.getCol1(), table1.getCol2());
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from table1 where id = ?", id);
    }

    public void update(Table1 table1) {
        jdbcTemplate.update("update table1 set col1 = ?, col2 = ? where id = ?", table1.getCol1(), table1.getCol2(), table1.getId());
    }

    public Table1 get(Long id) {
        return jdbcTemplate.queryForObject("select * from table1 where id = ?", new RowMapper<Table1>() {
            @Override
            public Table1 mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Table1.builder().id(rs.getLong("id"))
                        .col1(rs.getString("col1"))
                        .col2(rs.getString("col2")).build();
            }
        }, id);
    }

    public List<Table1> listAll() {
        return jdbcTemplate.query("select * from table1", new RowMapper<Table1>() {

            @Override
            public Table1 mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Table1.builder().id(rs.getLong("id"))
                        .col1(rs.getString("col1"))
                        .col2(rs.getString("col2")).build();
            }
        });
    }

}
