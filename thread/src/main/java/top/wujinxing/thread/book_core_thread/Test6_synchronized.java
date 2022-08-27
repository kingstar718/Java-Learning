package top.wujinxing.thread.book_core_thread;

/**
 * @author: wujinxing
 * @date: 2019/2/27 19:53
 * @description:
 */
public class Test6_synchronized {
    public static void main(String[] args){
        MyObject object = new MyObject();
        Thread6A a = new Thread6A(object);
        a.setName("A");
        Thread6B b = new Thread6B(object);
        b.setName("B");
        a.start();
        b.start();
    }

}

class MyObject{
    synchronized public void methodA(){
        try {
            System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void methodB(){
        try {
            System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread6A extends Thread{
    private MyObject object;
    public Thread6A(MyObject object){
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}

class Thread6B extends Thread{
    private MyObject object;
    public Thread6B(MyObject object){
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}