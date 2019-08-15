package top.wujinxing.ch_6_thread.review;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/8/15 14:00
 * description Thread线程的使用
 */
public class ThreadDemo {

    public static void main(String[] args) {
        ThreadFor1 for1 = new ThreadFor1();
        for1.setName("线程1");
        ThreadFor2 for2 = new ThreadFor2();
        for2.setName("线程2");
        for1.start();
        for2.start();
    }

    static class ThreadFor1 extends Thread{
        @Override
        public void run() {
            for (int i=0; i<50; i++){
                System.out.println(this.getName()+":"+i);
            }
        }
    }

    static class ThreadFor2 extends Thread{
        @Override
        public void run() {
            for (int i=51; i<100; i++){
                System.out.println(this.getName()+":"+i);
            }
        }
    }
}
