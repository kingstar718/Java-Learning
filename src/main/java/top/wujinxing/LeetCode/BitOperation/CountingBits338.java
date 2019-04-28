package top.wujinxing.LeetCode.BitOperation;

/**
 * @author wujinxing
 * date 2019/4/28 17:51
 * description 统计从 0 ~ n 每个数的二进制表示中 1 的个数
 */
public class CountingBits338 {
    public static void main(String[] args) {
        int[] a = countBits(6);
        for (int i: a){
            System.out.print(" "+ i +" ");
        }
    }
    private static int[] countBits(int num){
        int[] ret = new int[num+1];
        for (int i =1; i< num; i++){
            ret[i] =ret[i&(i-1)]+1;
        }
        return ret;
    }
}
