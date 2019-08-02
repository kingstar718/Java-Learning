package top.wujinxing.ch_6_thread.thread.book_core_thread.wait_and_notify;

/**
 * @author wujinxing
 * date 2019 2019/5/8 9:50
 * description
 */
public class Test5_alternate_print {
    public static void main(String[] args) {
        AlternatePrint ap = new AlternatePrint();
        for (int i=0; i<20; i++){
            test5A t1 = new test5A(ap);
            test5B t2 = new test5B(ap);
            t1.start();
            t2.start();
        }
    }
}
class AlternatePrint{
    private boolean isTrue = true;
    public synchronized void printA(){
        try {
            while (!isTrue){
                this.wait();
            }
            System.out.println("★★★★★");
            isTrue = false;
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void printB(){
        try {
            while (isTrue){
                this.wait();
            }
            System.out.println("☆☆☆☆☆");
            isTrue = true;
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class test5A extends Thread{
    AlternatePrint ap = null;

    public test5A(AlternatePrint ap) {
        this.ap = ap;
    }

    @Override
    public void run() {
        ap.printA();
    }
}
class test5B extends Thread{
    AlternatePrint ap = null;

    public test5B(AlternatePrint ap) {
        this.ap = ap;
    }

    @Override
    public void run() {
        ap.printB();
    }
}