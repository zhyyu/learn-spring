package com.zhyyu.learn.spring.transaction;

/**
 * 待验证项目
 * <pre>
 *     1. targetObject 中调用 @Transactional 方法是否触发事务  // 不触发事务, targetObject 调用自身发放无proxy 包裹
 *     2. propagation require_new 外层/内层 事务回滚提交
 *          // 内层提交, 外层不可见
 *          // 注意, require_new 一定不能是target 对象中方法, 否则和调用方法一样事务传播了(见1)
 *          // 外层/内层 事务回滚提交均不相互影响
 *     3. propagation nested 外层/内层 事务回滚提交
 *          // 内层提交, 外层可见
 *          // 内层回滚不影响外层
 *          // 外层回滚影响所有(将rollback 内层提交
 *          // 何时使用 require_new vs nested, 内层事务成功失败不影响外层事务, 但外层事务失败, require_new 不影响内层, nested 会回滚内层
 *              . 故如日志这样内层方法, 使用require_new 较合适, 外层失败不回滚日志; 如复杂业务逻辑, 如 a-b(失败) 则 a-c, a 失败, 回滚a & c, 需要nested
 *     4. PROPAGATION_MANDATORY 隔离级别能否单独使用 see AbstractPlatformTransactionManager line 357  // 必须已有事务
 *     5. @Transaction 仅标记在方法上/类上, 均标记, 区别          // 标记在方法上有作用, 标记在类上有作用, 两者都标记已方法上为准
 *     6. @Transaction 标记在接口/类上, 是否生效, AOP 相关亦可测试   // CGLIB 生成代理对象增对类增强, 无法读取接口上注解信息
 * </pre>
 * @author juror
 * @datatime 2019/5/28 9:30
 */
public class TODO {
}
