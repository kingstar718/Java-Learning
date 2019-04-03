package top.wujinxing.Thread.book_core_thread.singleton;

import java.io.*;

/**
 * @author: wujinxing
 * @date: 2019/3/6 16:15
 * @description:    序列化与反序列化的单例模式实现：在反序列化中使用readResolve()；
 */
public class Test3_Serialization_Singleton {
    public static void main(String[] args){
        try {
            MyObject3 myObject3 = MyObject3.getInstance();
            FileOutputStream fosRef = new FileOutputStream(new File("myObjectFile.text"));
            ObjectOutputStream oosRef = new ObjectOutputStream(fosRef);
            oosRef.writeObject(myObject3);
            oosRef.close();
            fosRef.close();
            System.out.println(myObject3.hashCode());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            FileInputStream fisRef = new FileInputStream(new File("myObjectFile.text"));
            ObjectInputStream iosRef = new ObjectInputStream(fisRef);
            MyObject3 myObject3 = (MyObject3) iosRef.readObject();

            iosRef.close();
            fisRef.close();
            System.out.println(myObject3.hashCode());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

class MyObject3 implements Serializable {
    private static final long serialVersionUID = 888L;
    // 内部类方式
    private static class MyObjectHandler {
        private static final MyObject3 myObject = new MyObject3();
    }
    private MyObject3() {
    }
    public static MyObject3 getInstance() {
        return MyObjectHandler.myObject;
    }
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法！");
        return MyObjectHandler.myObject;
    }

}