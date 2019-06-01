package com.zhyyu.learn.spring.transaction;

import com.zhyyu.learn.spring.jdbc.JdbcTemplateTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

//        testDAO(applicationContext);
        Table1TxService table1TxService = (Table1TxService) applicationContext.getBean("table1TxService");
        System.out.println(table1TxService.getClass());

        table1TxService.batchInsert();
//        table1TxService.batchInsertWithoutTx();
    }

    private static void testDAO(ApplicationContext applicationContext) {
        Table1DAO table1DAO = (Table1DAO) applicationContext.getBean("table1DAO");
        table1DAO.insert(Table1.builder().col1("row21").col2("row22").build());

        System.out.println(table1DAO.listAll());

        table1DAO.delete(6L);
        System.out.println(table1DAO.listAll());

        table1DAO.update(Table1.builder().id(1L).col1("col1111111").build());
        System.out.println((table1DAO.listAll()));

        System.out.println(table1DAO.get(1L));
    }

}

