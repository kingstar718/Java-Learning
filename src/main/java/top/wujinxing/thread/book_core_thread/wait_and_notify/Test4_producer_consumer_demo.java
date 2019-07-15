package top.wujinxing.thread.book_core_thread.wait_and_notify;

/**
 * @author wujinxing
 * date 2019 2019/5/8 9:25
 * description
 */
public class Test4_producer_consumer_demo {
    public static void main(String[] args) {
        Person p = new Person();
        Thread pro = new Thread(new Producer(p));
        pro.start();
        Thread con = new Thread(new Consumer(p));
        con.start();
    }
}
class Person{
    private String name;
    private int age;
    //表示共享资源对象是否为空，如果为 true，表示需要生产，如果为 false，则有数据了，不要生产
    private boolean isEmpty = true;

    public synchronized void push(String name, int age){
        try {
            //不能用 if，因为可能有多个线程
            while (!isEmpty){  //进入到while语句内，说明 isEmpty==false，那么表示有数据了，不能生产，必须要等待消费者消费
                this.wait(); //导致当前线程等待，进入等待池中，只能被其他线程唤醒
            }
            this.name = name;
            Thread.sleep(10);
            this.age = age;
            isEmpty = false;   //设置 isEmpty 为 false,表示已经有数据了
            this.notifyAll();   //生产完毕，唤醒所有消费者
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void pop(){
        try {
            while (isEmpty){  //进入 while 代码块，表示 isEmpty==true,表示为空，等待生产者生产数据，消费者要进入等待池中
                this.wait();   //消费者线程等待
            }
            Thread.sleep(10);
            System.out.println(this.name + " " + this.age);
            isEmpty = true;
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{

    Person p = null;

    public Consumer(Person p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i=0; i<50; i++){
            //消费对象
            p.pop();
        }
    }
}
class Producer implements Runnable{

    Person p = null;

    public Producer(Person p) {
        this.p = p;
    }

    @Override
    public void run() {
        //生产对象
        for (int i=0; i<50; i++){
            if (i%2==0){
                p.push("Tom", 11);
            }else {
                p.push("Marry", 12);
            }
        }
    }
}