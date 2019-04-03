package top.wujinxing.ThreadFrame.threadpool;

/**
 * @author: wujinxing
 * @date: 2019/3/26 23:10
 * @description:
 */
public class mianTest {
    public static void main(String[] args){
        long begin = System.currentTimeMillis();
        for (int i=0; i<10000; i++){
            new Thread(new MyThread("testNoThreadPool" + Integer.toString(i))).start();
        }
        System.out.println(System.currentTimeMillis()-begin);

        begin = System.currentTimeMillis();
        for (int i=0; i<10000; i++){
            ThreadPool.getInstance().start(new MyThread("testThreadPool" + Integer.toString(i)));
        }
        System.out.println(System.currentTimeMillis()-begin);

    }
}
