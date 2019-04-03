package top.wujinxing.Thread.book_core_thread.test_ThreadLocal;

/**
 * @author: wujinxing
 * @date: 2019/3/1 17:07
 * @description:
 */
public class test1_ThreadLocal {
    public static void main(String[] args) {
        try {
            ThreadA a = new ThreadA();
            ThreadB b = new ThreadB();
            a.start();
            b.start();

            for (int i = 0; i < 100; i++) {
                /*if (Tools.tl.get() == null) {
                    Tools.tl.set("Main" + (i + 1));
                } else {
                    System.out.println("Main get Value=" + Tools.tl.get());
                }*/
                Tools.tl.set("Main" + (i + 1));
                System.out.println("Main get Value=" + Tools.tl.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Tools{
    public static ThreadLocal tl = new ThreadLocal();
}

class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                /*if (Tools.tl.get() == null) {
                    Tools.tl.set("ThreadA" + (i + 1));
                } else {
                    System.out.println("ThreadA get Value=" + Tools.tl.get());
                }*/
                Tools.tl.set("ThreadA" + (i + 1));
                System.out.println("ThreadA get Value=" + Tools.tl.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                /*if (Tools.tl.get() == null) {
                    Tools.tl.set("ThreadB" + (i + 1));
                } else {
                    System.out.println("ThreadB get Value=" + Tools.tl.get());
                }*/
                Tools.tl.set("ThreadB" + (i + 1));
                System.out.println("ThreadB get Value=" + Tools.tl.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
