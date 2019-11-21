package top.wujinxing.ch_2_basicjava.classload;


import java.io.InputStream;

/**
 * @author wujinxing
 * date 2019 2019/11/21 16:25
 * description
 */
public class ch_3_loadTest {

    public static void main(String[] args) throws Exception {
        // 一个简单的类加载器，逆向双亲委派机制
        // 可以加载与自己在同一路径下的Class文件
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null){
                        return super.loadClass(name);  // 递归调用父类加载器
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                    //is.close(); //我添加的
                } catch (Exception e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myClassLoader.loadClass("top.wujinxing.ch_2_basicjava.classload.TestBean").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(obj instanceof top.wujinxing.ch_2_basicjava.classload.TestBean);
        /**
         * class top.wujinxing.ch_2_basicjava.classload.TestBean
         * top.wujinxing.ch_2_basicjava.classload.ch_3_loadTest$1@3fee733d
         * false
         * 虚拟机中存在了两个 TestBean 类，一个是由系统类加载器加载的，另一个则是由我们自定义的类加载器加载的，
         * 虽然它们来自同一个 Class 文件，但依然是两个独立的类，因此做所属类型检查时返回 false。
         */

    }
}
