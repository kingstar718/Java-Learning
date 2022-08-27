package top.wujinxing.review;

/**
 * @author wujinxing
 * date 2019 2019/8/15 16:07
 * description ThreadLocal
 */
public class ThreadLocalDemo {

    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    static void printData(String str){
        System.out.println(str + ": " + localVariable.get());
    }

    public static void main(String[] args) {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("one");
                printData("one");
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("two");
                printData("two");
            }
        });

        threadOne.start();
        threadTwo.start();
        //one: one
        //two: two
        //当线程threadOne调用localVariable时，会在线程内复制一个副本，所以无论怎么运行，one一直对应的都是one。
    }
}
