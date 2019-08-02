package top.wujinxing.ch_2_basicjava.simplespring.aop;

/**
 * @author: wujinxing
 * @date: 2019/4/3 17:09
 * @description: 实现类包含了切面逻辑，如上面的 logMethodInvocation
 */
public interface MethodInvocation {
    void invoke();
}
