package top.wujinxing.thread.book_core_thread;

/**
 * @author: wujinxing
 * @date: 2019/2/27 17:30
 * @description:    实例变量非线程安全
 */
public class Test4_notsafe_Instance_variable {
    public static void main(String[] args){
        HasSelfPrivateNum1 numRef = new HasSelfPrivateNum1();
        ThreadA1 athread = new ThreadA1(numRef);
        athread.start();
        ThreadB1 bthread = new ThreadB1(numRef);
        bthread.start();
    }
}

class HasSelfPrivateNum1{
    //num为实例变量 非方法内变量，所以线程不安全
    private int num = 0;
    synchronized public void addI(String username){ //没有synchronized关键字，num就线程不安全
        try {
            if(username.equals("a")){
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }else {
                num = 200;
                System.out.println("b set over");
            }
            System.out.println(username + " num=" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA1 extends Thread{
    private HasSelfPrivateNum1 numRef;
    public ThreadA1(HasSelfPrivateNum1 numRef){
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}

class ThreadB1 extends Thread{
    private HasSelfPrivateNum1 numRef;
    public ThreadB1(HasSelfPrivateNum1 numRef){
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
