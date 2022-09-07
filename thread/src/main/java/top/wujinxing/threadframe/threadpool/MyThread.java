package top.wujinxing.threadframe.threadpool;

/**
 * @author wujinxing
 * @date 2019/3/26 23:08
 */
public class MyThread implements Runnable {

    protected String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            //使用sleep方法代替一个具体功能的执行
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
