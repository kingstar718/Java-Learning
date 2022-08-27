package top.wujinxing.leetcode.string;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/9/26 15:32
 * description 二进制求和
 * <p>
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 */
public class ch_67_AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            // 获取字符串a对应的某一位的值 当i<0是 sum+=0（向前补0） 否则取原值 ‘1’的char类型和‘0’的char类型刚好相差为1
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            // 获取字符串a对应的某一位的值 当i<0是 sum+=0（向前补0） 否则取原值 ‘1’的char类型和‘0’的char类型刚好相差为1
            sum += (j >= 0 ? a.charAt(j) - '0' : 0);
            ans.append(sum % 2); //如果二者都为1  那么sum%2应该刚好为0 否则为1
            ca = sum / 2; //如果二者都为1  那么ca 应该刚好为1 否则为0
        }
        ans.append(ca == 1 ? ca : "");// 判断最后一次计算是否有进位  有则在最前面加上1 否则原样输出
        return ans.reverse().toString();
    }

    @Test
    public void test() {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
}
