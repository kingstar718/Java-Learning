package top.wujinxing.sword_offer;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author wujinxing
 * date 2019 2019/9/10 22:55
 * description 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组`{1,2,3,2,2,2,5,4,2}`。
 * 由于数字`2`在数组中出现了`5`次，超过数组长度的一半，因此输出`2`。如果不存在则输出0。
 */
public class ch_28_MoreThanHalfNum_Solution {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0)
            return 0;
        if (array.length == 1)
            return array[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);//注意方法
            if (map.get(array[i]) > array.length / 2)
                return array[i];
        }
        return 0;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
}
