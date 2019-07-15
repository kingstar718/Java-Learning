package top.wujinxing.thread;

/**
 * @author wujinxing
 * date: 2019/2/23 21:34
 * description:    sleep
 * sleep(long millis)方法的作用是在指定的毫秒内让当前"正在执行的线程"休眠（暂停执行）。
 * 这个"正在执行的线程"是关键，指的是Thread.currentThread()返回的线程。
 * 根据JDK API的说法，"该线程不丢失任何监视器的所属权"，
 * 简单说就是sleep代码上下文如果被加锁了，锁依然在，但是CPU资源会让出给其他线程。
 */
public class ThreadTest13 extends Thread{

        @Override
        public void run() {
            try
            {
                System.out.println("run threadName = " +
                        this.getName() + " begin " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("run threadName = " +
                        this.getName() + " end " + System.currentTimeMillis());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }


    public static void main(String[] args){
        ThreadTest13 myThread = new ThreadTest13();
        System.out.println("begin = " + System.currentTimeMillis());
        myThread.start();
        System.out.println("end = " + System.currentTimeMillis());

        //begin = 1550929247947
        //end = 1550929247947
        //run threadName = thread-0 begin 1550929247948
        //run threadName = thread-0 end 1550929249949
        //第四句要等第三句2s之后才打印
    }
}
