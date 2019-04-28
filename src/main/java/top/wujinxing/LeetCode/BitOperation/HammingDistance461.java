package top.wujinxing.LeetCode.BitOperation;

/**
 * @author wujinxing
 * date 2019/4/28 15:10
 * description 统计两个数的二进制表示有多少位不同
 *
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1 (0 0 0 1)
 * 4 (0 1 0 0)
 *      ↑   ↑
 */
public class HammingDistance461 {
    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(hammingDistance(x, y));
        System.out.println(hammingDistance2(x, y));
        System.out.println(hammingDistance3(x, y));
    }
    private static int hammingDistance(int x, int y){
        //对两个数进行异或操作，位级表示不同的那一位为 1，统计有多少个 1 即可
        int z = x ^ y;
        int cnt = 0;
        while (z != 0){
            if ((z & 1) == 1){
                cnt++;
            }
            z = z >> 1;
        }
        return cnt;
    }

    private static int hammingDistance2(int x, int y){
        return Integer.bitCount(x ^ y);
    }

    private static int hammingDistance3(int x, int y){
        int z = x ^ y;
        int cnt = 0;
        while (z != 0){
            z &= (z - 1);
            cnt++;
        }
        return cnt;
    }
}
