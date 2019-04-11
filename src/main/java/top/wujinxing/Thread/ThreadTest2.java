package top.wujinxing.Thread;

/**
 * @author: wujinxing
 * @date: 2019/2/18 22:06
 * @description: 使用扩展Thread的独立类
 */
public class ThreadTest2 {
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++){
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }
}

