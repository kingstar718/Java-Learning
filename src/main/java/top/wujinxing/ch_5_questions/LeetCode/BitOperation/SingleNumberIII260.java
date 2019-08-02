package top.wujinxing.ch_5_questions.LeetCode.BitOperation;

/**
 * @author wujinxing
 * date 2019/4/28 16:54
 * description 数组中不重复的2个数
 *
 * 两个不相等的元素在位级表示上必定会有一位存在不同。
 * 将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
 * diw &= -diw 得到出 diw 最右侧不为 0 的位，
 * 也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这
 * 一位就可以将两个元素区分开来。
 */
public class SingleNumberIII260 {
    public static void main(String[] args) {
        int[] num = {1,2,1,2,1,2,4,1,2,5,1,1};
        int[] n1 = singleNumber(num);
        System.out.println(n1[0]+ " " +n1[1]);

    }
    private static int[] singleNumber(int[] num){
        int diff = 0;
        for (int n: num){
            diff ^= n;
        }
        diff &= -diff; // 得到最右一位
        int[] ret = new int[12];
        for (int n: num){
            if ((n&diff)==0){
                ret[0] ^= n;
            }
            else {
                ret[1] ^= n;
            }
        }
        return ret;
    }
}
