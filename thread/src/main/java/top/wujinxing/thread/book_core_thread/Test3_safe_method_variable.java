package top.wujinxing.thread.book_core_thread;

/**
 * @author: wujinxing
 * @date: 2019/2/27 16:43
 * @description: 方法内的变量为线程安全
 */
public class Test3_safe_method_variable {
    public static void main(String[] args){
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA athread = new ThreadA(numRef);
        athread.start();
        ThreadB bthread = new ThreadB(numRef);
        bthread.start();
    }
    //方法中的变量不存在非线程安全问题，永远都是线程安全的
    //因为方法内部的变量是私有的的特性造成的

}

class HasSelfPrivateNum{
    public void addI(String username){
        try {
            int num = 0;
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

class ThreadA extends Thread{
    private HasSelfPrivateNum numRef;
    public ThreadA(HasSelfPrivateNum numRef){
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}

class ThreadB extends Thread{
    private HasSelfPrivateNum numRef;
    public ThreadB(HasSelfPrivateNum numRef){
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}