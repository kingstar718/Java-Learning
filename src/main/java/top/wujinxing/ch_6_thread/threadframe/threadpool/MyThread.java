package top.wujinxing.ch_6_thread.threadframe.threadpool;

/**
 * @author: wujinxing
 * @date: 2019/3/26 23:08
 * @description:
 */
public class MyThread implements Runnable {

    protected String name;
    public MyThread(){}
    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100); //使用sleep方法代替一个具体功能的执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
