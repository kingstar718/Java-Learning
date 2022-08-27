package top.wujinxing.thread.book_art_thread;

/**
 * @author wujinxing
 * date 2019 2019/5/22 17:14
 * description
 */
public class myWaitNotify {
    static boolean flag = true;
    static printObject p = new printObject();
    public static void main(String[] args) {
        Thread wait = new Thread(new Wait(), "printA");
        wait.start();
        Thread notify = new Thread(new Notify(), "printB");
        notify.start();
    }

    static class Wait implements Runnable{

        @Override
        public void run() {
            synchronized (p){
                while (flag){
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                p.pringA();
                p.notifyAll();
                flag = true;
            }
        }
    }static class Notify implements Runnable{

        @Override
        public void run() {
            synchronized (p){
                while (!flag){
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                p.pringA();
                p.notifyAll();
                flag = false;

            }
        }
    }
    static class printObject{

        public void pringA(){
            System.out.println("AA");
        }
        public void printB(){
            System.out.println("BB");
        }
    }
}
