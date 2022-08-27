package top.wujinxing.recursive;

/**
 * @author wujinxing
 * date 2019 2019/8/18 10:33
 * description 阶乘
 */
public class ch_1_Factorial {

    /**
     * 阶乘递归实现
     * @param n 参数
     * @return long
     */
    public static long f(int n){
        if (n==1){     //递归终止条件
            return 1;   //简单情景
        }
        return n*f(n-1); //相同重复逻辑。缩小问题规模
    }

    /**
     * 阶乘的非递归实现
     * @param n 参数
     * @return long
     */
    public static long f_loop(int n){
        long result = n;
        while (n > 1){
            n--;
            result *= n;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(f(10));
        System.out.println(f_loop(10));
    }
}
