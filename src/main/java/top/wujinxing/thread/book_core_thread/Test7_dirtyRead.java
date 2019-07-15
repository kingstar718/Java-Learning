package top.wujinxing.thread.book_core_thread;

/**
 * @author: wujinxing
 * @date: 2019/2/27 20:19
 * @description:    脏读
 */
public class Test7_dirtyRead {
    public static void main(String[] args){
        try {
            PublicVar publicVarRef = new PublicVar();
            Thread7A thread7A = new Thread7A(publicVarRef);
            thread7A.start();
            Thread.sleep(200);
            publicVarRef.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //getValue method thread name=main username=B password=AA
        //setValue method thread name=thread-0 username=B password=BB
        //出现脏读是因为getValue（）方法不同步，所以可以在任意时刻调用
        //解决——加入synchronized关键字
    }
}

class PublicVar{
    private String username = "A";
    private String password = "AA";
    synchronized public void setValue(String username, String password){
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method thread name="
                 + Thread.currentThread().getName() + " username="
                + username + " password=" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //之前未加synchronized关键字
    synchronized public void getValue(){
        System.out.println("getValue method thread name="
                + Thread.currentThread().getName() + " username="
                + username + " password=" + password);
    }
}

class Thread7A extends Thread{
    private PublicVar publicVar;
    public Thread7A(PublicVar publicVar){
        super();
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B","BB");
    }
}