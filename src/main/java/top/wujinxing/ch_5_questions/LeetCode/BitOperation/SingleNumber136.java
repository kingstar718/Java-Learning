package top.wujinxing.ch_5_questions.LeetCode.BitOperation;

/**
 * @author wujinxing
 * date 2019/4/28 15:24
 * description 数组中唯一一个不重复的元素
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber136 {
    public static void main(String[] args) {
        int[] num = {4,1,2,1,2};
        System.out.println(singleNumber(num));
    }
    private static int singleNumber(int[] num){
        int ret = 0;
        for (int n: num){
            //两个相同的数异或的结果为 0，对所有数进行异或操作，最后的结果就是单独出现的那个数
            //和0进行异或, 所得仍是原来那个数
            ret = ret ^ n;
        }
        return ret;
    }
}
