package top.wujinxing.sync;

public class ch_2_1_SyncExample {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        doSomethingA();
        doSomethingB();
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void doSomethingA() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- doSomethingA ---");
    }

    private static void doSomethingB() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- doSomethingA ---");
    }

}
