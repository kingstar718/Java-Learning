package top.wujinxing.Thread;

/**
 * @author: wujinxing
 * @date: 2019/2/18 22:10
 * @description: 多线程创建方式之一————实现runnable接口
 */
public class RunnableTest1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000); //继承Thread是直接使用sleep
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        Runnable test = new RunnableTest1();
        Thread thread = new Thread(test);
        thread.start();
    }
}
