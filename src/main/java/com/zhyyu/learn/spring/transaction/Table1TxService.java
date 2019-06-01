package com.zhyyu.learn.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Table1TxService {

    @Autowired
    private Table1DAO table1DAO;

    @Autowired
    private Table1TxService2 table1TxService2;

    public void batchInsertWithoutTx() {
        this.batchInsert();
    }

    @Transactional
    public void batchInsert() {
        System.out.println(table1DAO.listAll());
//        [Table1(id=1, col1=col1111111, col2=null)]

        table1DAO.insert(Table1.builder().col1("111111").col2("111111").build());
        table1DAO.insert(Table1.builder().col1("22222").col2("22222").build());

        try {
            table1TxService2.batchInsert2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Table1> table1s = table1DAO.listAll();
        System.out.println(table1s);
//        [Table1(id=1, col1=col1111111, col2=null), Table1(id=35, col1=111111, col2=111111), Table1(id=36, col1=22222, col2=22222)]
        // TODO: juror 2019/6/1 mysql rr 隔离级别, 可重复读, 且避免了幻读???

        int i = 1/ 0;
    }


}
