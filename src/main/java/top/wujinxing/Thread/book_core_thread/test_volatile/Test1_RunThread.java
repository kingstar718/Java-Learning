package top.wujinxing.Thread.book_core_thread.test_volatile;

/**
 * @author: wujinxing
 * @date: 2019/2/28 15:58
 * @description:
 */
public class Test1_RunThread {
    public static void main(String[] args){
        try {
            RunThread1 thread = new RunThread1();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("已经赋值为false");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //在启动RunThread线程时，变量private boolean isRunning = true；存在于公共堆栈及线程的私有堆栈中。
        //在JVM被设置为-sesrver模式的hi，为了线程的运行效率，线程一直在私有堆栈中取得isRunning的值是true；
        //而代码thread.setRunning（false）；虽然被执行，更新的却是公共堆栈中的isRunning变量值false，所以一直是死循环的状态。
        //即私有堆栈中的值和公共堆栈中的值不同步造成的，需要使用volatile关键字
    }
}

class RunThread1 extends Thread{
    //private boolean isRunning = true;
    //使用volatile，强制从公共内存中读取变量的值
    volatile private boolean isRunning = true;
    public boolean isRunning(){
        return isRunning;
    }
    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning == true){

        }
        System.out.println("线程被停止了！");
    }
}