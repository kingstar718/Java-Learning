package top.wujinxing.Thread.book_core_thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/2/28 11:02
 * @description: 多线程调用同一个方法是随机的
 *              当前线程的执行与退出时成对出现的
 *              但是线程A和B的执行却是异步的
 */
public class Test9_syn_Out_asyn {
    public static void main(String[] args){
        MyList9 myList = new MyList9();
        MyThread9A a = new MyThread9A(myList);
        a.setName("A");
        a.start();
        MyThread9B b = new MyThread9B(myList);
        b.setName("B");
        b.start();
    }
}

class MyList9{
    private List list = new ArrayList();
    synchronized public void add(String username){
        System.out.println("ThreadName=" + Thread.currentThread().getName() + " 执行了add方法");
        list.add(username);
        System.out.println("ThreadName=" + Thread.currentThread().getName() + " 退出了add方法");
    }
    synchronized public int geiSize(String username){
        System.out.println("ThreadName=" + Thread.currentThread().getName() + " 执行了geiSize方法");
        int sizeValue = list.size();
        System.out.println("ThreadName=" + Thread.currentThread().getName() + " 退出了geiSize方法");
        return sizeValue;
    }
}

class MyThread9A extends Thread{
    private MyList9 list;

    public MyThread9A(MyList9 list){
        super();
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            list.add("thread9A" + (i+1));
        }
    }
}

class MyThread9B extends Thread{
    private MyList9 list;

    public MyThread9B(MyList9 list){
        super();
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            list.add("thread9B" + (i+1));
        }
    }
}