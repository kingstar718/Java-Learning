package top.wujinxing.leetcode.bit_operation;

/**
 * @author wujinxing
 * date 2019/4/28 17:20
 * description
 */
public class SomeJudge {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4)+" "+isPowerOfTwo2(4)+" "+isPowerOfTwo(5)+" "+isPowerOfTwo2(5));
        System.out.println(isPowerOfFour(4)+" "+isPowerOfFour(5)+" "+isPowerOfFour2(4)+" "+isPowerOfFour2(5));
        System.out.println(hasAlternatingBits(10)+" "+hasAlternatingBits(11));
        System.out.println(getSum(12, 13));
    }

    private static boolean isPowerOfTwo(int n){
        //判断一个数是不是2的n次方
        return n>0 && Integer.bitCount(n)==1;
    }
    private static boolean isPowerOfTwo2(int n){
        //利用 1000 & 0111 == 0 这种性质，得到以下解法
        return n>0 && (n&(n-1))==0;
    }

    private static boolean isPowerOfFour(int n){
        //这种数在二进制表示中有且只有一个奇数位为 1，例如 16（10000）。
        return n>0 && (n&(n-1))==0 && (n&0b01010101010101010101010101010101)!=0;
    }
    private static boolean isPowerOfFour2(int n){
        //使用正则表达式进行匹配。
        return Integer.toString(n, 4).matches("10*");
    }

    /**
     * num: 693
     * Input: 10
     * Output: True
     * Explanation:
     * The binary representation of 10 is: 1010.
     * Input: 11
     * Output: False
     * Explanation:
     * The binary representation of 11 is: 1011
     * @param n
     * @return true/false
     */
    private static boolean hasAlternatingBits(int n){
        //对于 1010 这种位级表示的数，把它向右移动1位得到101，这两个数每个位都不同，因此异或得到的结果为 1111。
        int a = (n^(n>>1));
        return (a&(a+1))==0;
    }

    private static int getSum(int a, int b){
        //实现整数的加法
        //a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
        //递归会终止的原因是 (a & b) << 1 最右边会多一个 0，
        //那么继续递归，进位最右边的 0 会慢慢增多，最后进位会变为0，递归终止。
        return b==0 ? a : getSum((a^b), (a&b)<<1);
    }
}
