package top.wujinxing.ch_6_thread.thread.book_core_thread;

/**
 * @author: wujinxing
 * @date: 2019/2/28 14:06
 * @description:    使用同步块来解决死锁的问题
 */
public class Test11_string_syn {
    public static void main(String[] args){
        Service11 service = new Service11();
        Thread11A athread = new Thread11A(service);
        athread.start();
        Thread11B bthread = new Thread11B(service);
        bthread.start();
    }
}

class Service11{
    Object object1 = new Object();
    public void methodA(){
        synchronized (object1){
            System.out.println("methodA begin");
            boolean isContinueRun = true;
            while (isContinueRun){
            }
            System.out.println("methodA end");
        }
    }
    Object object2 = new Object();
    public void methodB(){
        synchronized (object2){
            System.out.println("methodB begin");
            System.out.println("methodB end");
        }
    }
}

//原来的Service，线程B会一直等待A，A一直不结束，B就一直在等待
/*class Service11{
    synchronized_demo public void methodA(){
        System.out.println("methodA begin");
        boolean isContinueRun = true;
        while (isContinueRun){
        }
        System.out.println("methodA end");

    }
    public void methodB(){
        System.out.println("methodB begin");
        System.out.println("methodB end");
    }
}*/
//自定义线程类
class Thread11A extends Thread{
    private Service11 service11;
    public Thread11A(Service11 service){
        super();
        this.service11 = service;
    }
    @Override
    public void run() {
        service11.methodA();
    }
}

class Thread11B extends Thread{
    private Service11 service11;
    public Thread11B(Service11 service){
        super();
        this.service11 = service;
    }
    @Override
    public void run() {
        service11.methodB();
    }
}