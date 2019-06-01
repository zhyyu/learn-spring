package com.zhyyu.learn.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Table1TxService2 {

    @Autowired
    private Table1DAO table1DAO;

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Transactional(propagation = Propagation.NESTED)
    public void batchInsert2() {
        List<Table1> table1s = table1DAO.listAll();
        System.out.println(table1s);

        // update id = 1, 验证可重复读, 幻读不可避免, com.zhyyu.learn.spring.transaction.Table1TxService.batchInsert
        table1DAO.update(Table1.builder().id(1L).col1("1uuuuuuu").col2("2uuuuuuuuuu").build());

        table1DAO.insert(Table1.builder().col1("33333").col2("3333").build());
        table1DAO.insert(Table1.builder().col1("4444").col2("4444").build());

//        int i = 1 / 0;
    }

}
