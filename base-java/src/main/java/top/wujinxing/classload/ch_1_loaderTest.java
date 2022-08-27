package top.wujinxing.classload;

/**
 * @author wujinxing
 * date 2019 2019/11/21 16:03
 * description 类加载器
 */
public class ch_1_loaderTest {

    public static void main(String[] args) {
        try {
            System.out.println(ClassLoader.getSystemClassLoader());
            System.out.println(ClassLoader.getSystemClassLoader().getParent());
            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * output:
     * sun.misc.Launcher$AppClassLoader@18b4aac2
     * sun.misc.Launcher$ExtClassLoader@76ed5528
     * null
     * 启动类加载器无法被 Java 程序直接引用，因此 JVM 默认直接使用 null 代表启动类加载器
     */
}
