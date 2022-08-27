package top.wujinxing.sword_offer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author wujinxing
 * date 2019 2019/9/12 14:31
 * description 和为S的两个数字
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class ch_42_FindNumbersWithSum {

    /**
     * 设两个指针`L、R`，分别是排序数组的开头和结尾；
     * 然后下面就是两个指针`L、R`向中间靠拢的过程。① 如果`arr[L] + arr[R] > sum`，说明右边那个`arr[R]`大了，需要向左移动，看能不能找到更小的`arr[R]`来和`arr[L]`一起组成`sum`。② 同理，如果`arr[L] + arr[R] < sum`，说明左边那个`arr[L]`小了，需要向右移动，看能不能找到更大的`arr[L]`来和`arr[R]`一起组成`sum`。③否则等于就返回即可；
     * 题目说要找到乘积最小的，可以发现，`L、R`隔的越远，`arr[L] * arr[R]`乘积越小，所以我们的做法没问题。
     * @param array 数组
     * @param sum 和
     * @return List
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int L = 0, R = array.length-1;
        while (L < R){
            if (array[L] + array[R] == sum){
                res.add(array[L]);
                res.add(array[R]);
                return res;
            }else if (array[L] + array[R] > sum) {
                R--;
            }else {
                L++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = {1,2,3,5,6,7,8,9,11};
        System.out.println(FindNumbersWithSum(arr, 11));
    }
}
