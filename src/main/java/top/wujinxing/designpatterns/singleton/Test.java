package top.wujinxing.designpatterns.singleton;

import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: wujinxing
 * @date: 2019/3/23 22:22
 * @description:
 */
public class Test {
    public static void main(String[] args){
        Singleton.createString();
        //Singleton is create
        //createString in Singleton
        //此时没有使用单例类,但还是被创建出来,需要引入延迟加载机制
    }
    @org.junit.Test
    //SerSingleton测试
    public void test() throws Exception {
        SerSingleton s1 = null;
        SerSingleton s = SerSingleton.getInstance();
        //先将实例串行化到文件
        FileOutputStream fos = new FileOutputStream("SerSingleton.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();
        //从文件读出原有的单例类
        FileInputStream fis = new FileInputStream("SerSingleton.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (SerSingleton) ois.readObject();
        Assert.assertEquals(s, s1);

        //java.lang.AssertionError:
        //Expected :top.wujinxing.designpatterns.singleton.SerSingleton@2b05039f
        //Actual   :top.wujinxing.designpatterns.singleton.SerSingleton@21588809
        /**
         * 在去掉SerSingleton的readReslove函数时,抛出如上异常
         * 说明s和s1指向了不同的实例,反序列化后,生成多个对象实例.而加上readReslove()函数的
         * 程序正常退出.说明,即是经过反序列化,任然保持了单例的特征.
         * 事实上,在实现了私有的readReslove()方法后,readObject()已经形同虚设,他直接使用
         * readReslove替换了原本的返回值,从而在形式上构造了单例.
         */
    }
}
