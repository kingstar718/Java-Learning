package top.wujinxing.thread;

/**
 * @author wujinxing
 * date 2019/2/18 22:06
 * description 使用扩展Thread的独立类
 */
public class ThreadTest2 {
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

/**
 * 创建一个独立的线程类
 */
class MyThread extends Thread{

    @Override
    public void run() {
        //迭代次数
        int iterationNum = 10;
        for (int i = 1; i <= iterationNum; i++){
            System.out.println(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

