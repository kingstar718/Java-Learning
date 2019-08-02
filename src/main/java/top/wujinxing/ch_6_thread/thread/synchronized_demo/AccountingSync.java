package top.wujinxing.ch_6_thread.thread.synchronized_demo;

/**
 * @author wujinxing
 * date 2019 2019/6/18 10:16
 * description
 */
class AccountingSync implements Runnable {

    static int i = 0;
    static int s = 0;
    static int m = 0;

    public synchronized void increase(){
        i++;
    }
    public void increase2(){
        s++;
    }
    public synchronized static void increase3(){
        m++;
    }

    @Override
    public void run() {
        for (int j=0; j<100000; j++){
            increase();
            increase2();
            increase3();
        }
    }

}
