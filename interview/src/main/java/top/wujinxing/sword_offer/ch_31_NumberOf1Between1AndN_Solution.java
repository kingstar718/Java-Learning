package top.wujinxing.sword_offer;

/**
 * @author wujinxing
 * date 2019 2019/9/10 23:18
 * description 整数中1出现的次数（从1到n整数中1出现的次数）
 * <p>
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class ch_31_NumberOf1Between1AndN_Solution {

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        //实质上遍历了每一个数
        while (n > 0) {
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1')
                    count++;
            }
            n--;
        }
        return count;
    }
}
