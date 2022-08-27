package top.wujinxing.classload;

/**
 * @author wujinxing
 * date 2019 2019/11/21 16:09
 * description
 */
public class ch_2_classLoaderTest {

    public static void main(String[] args) {
        try {
            // 查看当前系统类路径中包含的路径条目
            System.out.println(System.getProperty("java.class.path"));

            System.out.println("================================================");

            //调用加载当前类的类加载器（这里即为系统类加载器）加载TestBean
            Class typeLoaded = Class.forName("top.wujinxing.classload.TestBean");

            //查看被加载的TestBean类型是被那个类加载器加载的
            System.out.println(typeLoaded.getClassLoader());
            //sun.misc.Launcher$AppClassLoader@18b4aac2

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
