package top.wujinxing.thread;

/**
 * @author wujinxing
 * date 2019/2/20 16:12
 * description  //CPU执行哪个线程的代码具有不确定性
 */
public class ThreadTest5 {
    public static void main(String[] args) {
        MyThreadTest5 myThreadTest5 = new MyThreadTest5();
        myThreadTest5.start();
        try {
            for (int i=0; i< 3; i++){
                Thread.sleep(1000);
                System.out.println("run = " +Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
class MyThreadTest5 extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++){
                Thread.sleep((int) (Math.random()*1000));
                System.out.println("run = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}