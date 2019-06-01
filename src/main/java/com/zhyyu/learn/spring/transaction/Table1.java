package com.zhyyu.learn.spring.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Table1 {

    private Long id;
    private String col1;
    private String col2;

}
