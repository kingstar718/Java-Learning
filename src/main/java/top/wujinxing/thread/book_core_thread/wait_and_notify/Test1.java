package top.wujinxing.thread.book_core_thread.wait_and_notify;

/**
 * @author: wujinxing
 * @date: 2019/3/1 10:52
 * @description:
 */
public class Test1 {
    //没有“对象监视器”，也就是没有同步加锁
    //抛出IllegalMonitorStateException异常
    /*public static void main(String[] args){
        try {
            String newString = new String(" ");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
    public static void main(String[] args){
        try {
            String lock = new String();
            System.out.println("syn上面");
            synchronized (lock){
                System.out.println("syn第一行");
                lock.wait();
                System.out.println("wait下的代码");
            }
            System.out.println("wait下的代码");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
