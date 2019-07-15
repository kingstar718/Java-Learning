package top.wujinxing.copy;

/**
 * @author wujinxing
 * date 2019 2019/7/3 11:01
 * description
 */
public class arrayTest {
    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] = 1;
        int[] b = a.clone();
        a[1] = 2;
        System.out.println(a.getClass());
        System.out.println(a.hashCode()+"  "+b.hashCode());
        System.out.println(b[1]);
    }
}
