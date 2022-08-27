package top.wujinxing.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author wujinxing
 * date 2019 2019/5/16 17:33
 * description 查询一个main执行时的线程
 */
public class MultiThread {
    public static void main(String[] args) {
        //获取Java线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和 synchronizer 信息, 仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        //遍历线程信息, 仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo: threadInfos){
            System.out.println("[ " + threadInfo.getThreadId() + " ] " + threadInfo.getThreadName());
        }
        /*
        不是道为什么会显示 5 6  上面已经设置了不显示
        [ 6 ] Monitor Ctrl-Break
        [ 5 ] Attach Listener
        [ 4 ] Signal Dispatcher     //分发处理发送给JVM信号的线程
        [ 3 ] Finalizer     //调用对象finalize方法的线程
        [ 2 ] Reference Handler     //清除Reference的线程
        [ 1 ] main  //main线程, 用户程序入口
         */
    }
}
