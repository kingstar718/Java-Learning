package top.wujinxing.ch_5_questions.SwordOffer;

/**
 * @author wujinxing
 * date 2019 2019/9/4 15:36
 * description 矩形覆盖
 * <p>
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class ch_10_RectCover {

    /**
     * 覆盖`2 * n`(`2`代表行，`n`代表列)的时候，先看看假设前面已经覆盖`2 * (n-2)`之后，到`2 * n`之间还有多少种覆盖法：
     * <p>
     * 后面两个只有两种覆盖方法，一种是全部竖着放(实际上是从`2 * (n-1)`来的)，
     * 这里注意不要认为还有一种情况是放置两个竖的，实际上放好`n-1`的情况中已经包含了那种情况；
     * 另一种就是全部横着放，也就是`n-2`到`n`之间横着放两块 `1 * 2`的矩形，如图`(2)`；
     * 所以fn= fn-1 + fn-2 ，和跳台阶问题(第二题)完全一样。
     * <p>
     * f1 = 1
     * f2 = 2
     * f3 = 3
     * f4 = f3 + f2
     */

    //递归
    public int RectCover(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1 || n == 2) {
            return n;
        } else {
            int f1 = 1, f2 = 2, res = 0;
            for (int i = 3; i <= n; i++) {
                res = f1 + f2;
                f1 = f2;
                f2 = res;
            }
            return res;
        }
    }

}
