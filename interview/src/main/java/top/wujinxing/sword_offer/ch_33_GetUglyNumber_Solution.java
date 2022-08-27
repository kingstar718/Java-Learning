package top.wujinxing.sword_offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author wujinxing
 * date 2019 2019/9/10 23:33
 * description 丑数
 * <p>
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class ch_33_GetUglyNumber_Solution {

    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        int[] res = new int[index + 1];
        int count = 0, i2 = 0, i3 = 0, i5 = 0;
        res[0] = 1;
        while (count < index) {
            int temp = Math.min(res[i2] * 2, Math.min(res[i3] * 3, res[i5] * 5));
            if (temp == res[i2] * 2) i2++;
            if (temp == res[i3] * 3) i3++;
            if (temp == res[i5] * 5) i5++;
            res[++count] = temp;
        }
        return res[index - 1];
    }

    static ArrayList<Integer> nums;

    static {
        nums = new ArrayList<>();
        for (long a = 1; a <= Integer.MAX_VALUE; a *= 2) {
            for (long b = a; b <= Integer.MAX_VALUE; b *= 3) {
                for (long c = b; c < Integer.MAX_VALUE; c *= 5) {
                    nums.add((int) c);
                }
            }
        }
        Collections.sort(nums);
    }

    public int GetUglyNumber_Solution2(int index) {
        if (index == 0)
            return 0;
        return nums.get(index - 1);
    }

    @Test
    public void test() {
        System.out.println(GetUglyNumber_Solution(100));
        System.out.println(GetUglyNumber_Solution2(100));
    }
}
