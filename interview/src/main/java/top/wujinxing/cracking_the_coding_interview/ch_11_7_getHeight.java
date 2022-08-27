package top.wujinxing.cracking_the_coding_interview;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/8/23 15:19
 * description 叠罗汉I
 *
 * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。
 * 同时我们应该让下面的人比上面的人更高一点。已知参加游戏的每个人的身高，
 * 请编写代码计算通过选择参与游戏的人，我们最多能叠多少个人。
 * 注意这里的人都是先后到的，意味着参加游戏的人的先后顺序与原序列中的顺序应该一致。
 *
 * 给定一个int数组men，代表依次来的每个人的身高。同时给定总人数n，请返回最多能叠的人数。保证n小于等于500。
 *
 * 测试样例：
 * [1,6,2,5,3,4],6
 * 返回：4
 */
public class ch_11_7_getHeight {

    @Test
    public void test(){
        int[] arr = {1,6,2,5,3,4};
        System.out.println(getHeight(arr, 6));
    }

    // 最长递增子序列
    public int getHeight(int[] men, int n) {
        if (men == null || n <= 0)
            return 0;
        int[] dp = new int[n]; // 到 i位置时候的最长递增子序列的长度
        dp[0] = 1;
        int longest = 0;
        for (int i=1; i<n; i++){
            int sublongest = 0;
            int subindex = 0;
            // 找出 i 前面的 0-i-1个元素中 以 i个元素结束的递增子序列的最长的值
            while (subindex < i){
                if (men[subindex] < men[i])
                    sublongest = sublongest > dp[subindex] ? sublongest : dp[subindex];
                subindex++;
            }
            dp[i] = sublongest + 1;
            longest = longest > dp[i] ? longest : dp[i];
        }
        return longest;
    }
}
