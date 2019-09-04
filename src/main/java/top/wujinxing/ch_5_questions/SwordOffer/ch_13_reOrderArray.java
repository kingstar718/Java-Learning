package top.wujinxing.ch_5_questions.SwordOffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wujinxing
 * date 2019 2019/9/4 16:57
 * description 调增数组顺序使奇数位于偶数前面
 *  * 不使用额外空间实现。
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ch_13_reOrderArray {

    //类似冒泡排序
    //交换前面是偶数而后面是奇数的情况。
    public void reOrderArray(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                //将偶数往后冒
                if ((array[i] % 2 == 0) && (array[i + 1] % 2 != 0)) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
