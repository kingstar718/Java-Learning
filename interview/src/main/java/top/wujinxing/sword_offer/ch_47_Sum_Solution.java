package top.wujinxing.sword_offer;

import org.junit.Test;

/**
 * 求`1+2+3+...+n`，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class ch_47_Sum_Solution {

    //- 当`n == 0`时，`n > 0 && (res += Sum_Solution(n-1)) > 0`只执行前面的判断，为`false`，然后直接返回`0`；
    //- 当`n > 0`时，递归`res += Sum_Solution(n-1)`，实现递归计算；
    public int Sum_Solution(int n) {
        int res = n;
        boolean b = n > 0 && (res += Sum_Solution(n - 1)) > 0;
        return res;
    }

    @Test
    public void test() {
        System.out.println(Sum_Solution(5));
        System.out.println(Sum_Solution(10));
        System.out.println(Sum_Solution(20));
    }
}
