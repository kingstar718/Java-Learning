package top.wujinxing.sword_offer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/9/4 14:06
 * description 跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class ch_08_JumpFloor {

    /**
     * 斐波那契变形 区别 n=2时是2不是1
     * -因为2级台阶可以有两种跳法；
     * 如果台阶有N级，最后跳上第N级的情况，要么是从N-2级台阶直接跨2级台阶，
     * 要么是从N-1级台阶跨1级台阶，所以台阶有N级的方法数为跨到N-2级台阶的方法数加上跨到N-1级台阶的方法数；
     */

    //递归版本
    public int jumpFloor(int target){
        if (target < 1){
            return 0;
        }else if (target == 1 || target == 2){
            return target;
        }else {
            return jumpFloor(target - 1) + jumpFloor(target - 2);
        }
    }

    //dp 滚动优化
    public int jumpFloorDp(int target){
        if (target < 1){
            return 0;
        }else if (target == 1 || target == 2){
            return target;
        }else {
            int f1 = 1, f2 = 2, res = 0;
            for (int i=3; i<=target; i++){
                res = f1 + f2;
                f1 = f2;
                f2 = res;
            }
            return res;
        }
    }

    @Test
    public void test(){
        System.out.println(jumpFloor(10));
        System.out.println(jumpFloorDp(10));
    }
}
