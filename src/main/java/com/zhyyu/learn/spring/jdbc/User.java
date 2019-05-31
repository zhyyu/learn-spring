package com.zhyyu.learn.spring.jdbc;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id ;
    private Integer age ;
    //用户角色
    private Integer roleId ;
    private String name ;
    //用户名称
    private String userName ;
    private Date createDate ;

}