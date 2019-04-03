package top.wujinxing.Thread.book_core_thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/2/28 11:19
 * @description:
 */
public class Test10_dirtyRead2 {
    public static void main(String[] args) throws InterruptedException {
        MyOneList10 list = new MyOneList10();
        MyThread10A thread1 = new MyThread10A(list);
        thread1.setName("A");
        thread1.start();
        MyThread10B thread2 = new MyThread10B(list);
        thread2.setName("B");
        thread2.start();
        Thread.sleep(6000);
        System.out.println("listSize=" + list.getSize());
    }
}

class MyOneList10{
    private List list = new ArrayList();
    synchronized public void add(String data){
        list.add(data);
    }
    synchronized public int getSize(){
        return list.size();
    }
}

class MyService10{
    public MyOneList10 addServiceMethod(MyOneList10 list, String data){
        try{
            //原版未加synchronized 造成脏读
            /**if (list.getSize() < 1){
             Thread.sleep(2000);//模拟从远程花费2秒取回数据
             list.add(data);
             }*/
            synchronized (list){
                if (list.getSize() < 1){
                    Thread.sleep(2000);//模拟从远程花费2秒取回数据
                    list.add(data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}

class MyThread10A extends Thread{
    private MyOneList10 list;
    public MyThread10A(MyOneList10 list){
        super();
        this.list = list;
    }

    @Override
    public void run() {
        MyService10 msRef = new MyService10();
        msRef.addServiceMethod(list, "A");
    }
}

class MyThread10B extends Thread{
    private MyOneList10 list;
    public MyThread10B(MyOneList10 list){
        super();
        this.list = list;
    }

    @Override
    public void run() {
        MyService10 msRef = new MyService10();
        msRef.addServiceMethod(list, "B");
    }
}