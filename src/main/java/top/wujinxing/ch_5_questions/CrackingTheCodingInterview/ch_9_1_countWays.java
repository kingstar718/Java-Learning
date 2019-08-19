package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;

/**
 * @author wujinxing
 * date 2019 2019/8/19 19:56
 * description 上楼梯
 *
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。
 * 请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
 *
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * 测试样例1：1 返回：1
 * 测试样例2：3  返回：4
 * 测试样例3：4  返回：7
 *
 * 1阶 - 1种
 * 2阶 - 2种
 * 3阶 - 4种
 * 4阶 - 7种
 * 5阶 - 13种
 *
 * 对于上k级台阶,当k>3时，由于每次可以上1,2,3级，则最后一次应该是上1,2,3中的一个
 * case1，最后一次上1级，也即前面上了k-1级，k-1级的可能情况为：A[k-1]次
 * 同理 case2,A[k-1], case3 A[k-3]
 * 从而有： A[k] = A[k-3] + A[k-2] + A[k-1]
 */
public class ch_9_1_countWays {

    public static void main(String[] args) {
        System.out.println(countWays(10));
        System.out.println(countWays2(10));
    }

    private static int countWays(int n) {
        long[] pre = {1,2,4};
        if (n<=0) {
            return 0;
        }else if (n<=3) {
            return (int) pre[n-1];
        }else {
            for (int i=4; i<=n; i++){
                long tmp = ((pre[0] + pre[1])%100000007 + pre[2])%1000000007;
                pre[0] = pre[1];
                pre[1] = pre[2];
                pre[2] = tmp;
            }
        }
        return (int) pre[2];
    }

    private static int countWays2(int n){
        long resMid;
        long[] frontWay = {1,2,4};
        if (n<3) return (int) frontWay[n-1];
        for (int i=3; i<n; i++){
            long tmp = frontWay[0] + frontWay[1] + frontWay[2];
            frontWay[0] = frontWay[1];
            frontWay[1] = frontWay[2];
            frontWay[2] = tmp;
            if (frontWay[2] > 100000007) frontWay[2] = frontWay[2]%1000000007;
        }
        int res = (int) (frontWay[2]%1000000007);
        return res;
    }
}
