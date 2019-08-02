package top.wujinxing.ch_5_questions.LeetCode.BitOperation;

/**
 * @author wujinxing
 * date 2019/4/28 15:36
 * description 找出数组重缺失的那个数
 * 数组在0-n之间
 * Input: [3,0,1]
 * Output: 2
 */
public class MissingNumber268 {
    public static void main(String[] args) {
        int[] num = {3, 0, 1};
        int[] num2 = {1,2,3,5,0,6,7,8,9};
        System.out.println(missingNumber(num));
        System.out.println(missingNumber(num2));
    }
    private static int missingNumber(int[] num){
        int ret = 0;
        for (int i = 0; i < num.length; i++){
            ret = ret ^ i ^ num[i];
        }
        return ret ^ num.length;
    }
}
