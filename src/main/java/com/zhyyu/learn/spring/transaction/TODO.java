package com.zhyyu.learn.spring.transaction;

/**
 * 待验证项目
 * <pre>
 *     1. targetObject 中调用 @Transactional 方法是否触发事务
 *     2. propagation require_new 外层/内层 事务回滚提交
 *     3. propagation nested 外层/内层 事务回滚提交
 *     4. @Transaction 仅标记在方法上/类上, 均标记, 区别
 *     5. @Transaction 标记在接口/类上, 是否生效, AOP 相关亦可测试   // CGLIB 生成代理对象增对类增强, 无法读取接口上注解信息
 * </pre>
 * @author juror
 * @datatime 2019/5/28 9:30
 */
public class TODO {
}
