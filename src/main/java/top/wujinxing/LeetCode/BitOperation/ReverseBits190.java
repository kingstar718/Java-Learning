package top.wujinxing.LeetCode.BitOperation;

/**
 * @author wujinxing
 * date 2019/4/28 17:07
 * description 翻转一个数的比特位
 */
public class ReverseBits190 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(reverseBits(n));
    }
    private static int reverseBits(int n){
        int ret = 0;
        for (int i=0; i<32; i++){
            ret <<= 1;
            ret |= (n&1);
            n >>>= 1;
        }
        return ret;
    }
}
