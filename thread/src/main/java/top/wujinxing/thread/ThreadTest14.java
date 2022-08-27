package top.wujinxing.thread;

/**
 * @author wujinxing
 * date: 2019/2/23 21:46
 * description: yield()
 * 暂停当前执行的线程对象，并执行其他线程。
 * 这个暂停是会放弃CPU资源的，并且放弃CPU的时间不确定，有可能刚放弃，
 * 就获得CPU资源了，也有可能放弃好一会儿，才会被CPU执行。
 */
public class ThreadTest14 extends Thread{
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 500000; i++)
        {
            Thread.yield();
            count = count + i + 1;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - beginTime) + "毫秒！");
    }

    public static void main(String[] args){
        ThreadTest14 threadTest14 = new ThreadTest14();
        threadTest14.start();
        //每次执行的用时都不一样，证明了yield()方法放弃CPU的时间并不确定。

        Thread.currentThread().interrupt();
        System.out.println("是否停止1？" + Thread.interrupted());
        System.out.println("是否停止2？" + Thread.interrupted());
        System.out.println("end!");
        //测试当前线程是否已经中断，执行后具有将状态标识清除为false的功能。换句话说，如果连续两次调用该方法，那么返回的必定是false：
    }
}
