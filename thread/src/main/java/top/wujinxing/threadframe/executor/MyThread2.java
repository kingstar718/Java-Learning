package top.wujinxing.threadframe.executor;

/**
 * @author: wujinxing
 * @date: 2019/3/27 10:27
 * @description:
 */
public class MyThread2 implements Runnable, Comparable<MyThread2> {
    protected String name;
    public MyThread2(String name){
        this.name = name;
    }

    @Override
    public int compareTo(MyThread2 o) {  //比较任务的优先级
        int me= Integer.parseInt(this.name.split("_")[1]); //线程名称中标注任务优先级
        int other = Integer.parseInt(o.name.split("_")[1]);
        if (me>other) return 1;
        else if (me<other) return -1;
        else return 0;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);  //模拟工作任务
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
