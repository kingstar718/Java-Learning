package top.wujinxing.Thread.book_core_thread;

/**
 * @author: wujinxing
 * @date: 2019/2/27 17:45
 * @description:
 */
public class Test5_two_lock_object {
    public static void main(String[] args){
        HasSelfPrivateNum2 numRef1 = new HasSelfPrivateNum2();
        HasSelfPrivateNum2 numRef2 = new HasSelfPrivateNum2();
        ThreadA2 athread = new ThreadA2(numRef1);
        athread.start();
        ThreadB2 bthread = new ThreadB2(numRef2);
        bthread.start();
        //两个线程分别访问同一个类的两个不同实例的相同名称的同步方法
        //效果却是以异步的方式运行的
        //关键字synchronized取得的锁都是对象锁，
    }
}

class HasSelfPrivateNum2{
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

class ThreadA2 extends Thread{
    private HasSelfPrivateNum2 numRef;
    public ThreadA2(HasSelfPrivateNum2 numRef){
        super();
        this.numRef = numRef;
    }
    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}

class ThreadB2 extends Thread{
    private HasSelfPrivateNum2 numRef;
    public ThreadB2(HasSelfPrivateNum2 numRef){
        super();
        this.numRef = numRef;
    }
    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
