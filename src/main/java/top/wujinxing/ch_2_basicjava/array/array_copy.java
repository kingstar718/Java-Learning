package top.wujinxing.ch_2_basicjava.array;

import java.util.Arrays;

/**
 * @author wujinxing
 * date 2019/9/24 20:52
 * description 数组的四种复制方式
 */
public class array_copy {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] newArr =  Arrays.copyOf(arr, 4);
        System.out.println(Arrays.toString(newArr)); //[1, 2, 3, 4]

        int[] newArr2 = Arrays.copyOfRange(arr, 1, 4);
        System.out.println(Arrays.toString(newArr2));//[2, 3, 4] 不包含终止索引

        int[] newArr3 = new  int[10];
        //源数组，复制起始位置，目标数组，目标数组起始位置，复制长度
        System.arraycopy(arr,1, newArr3,1, 5);
        System.out.println(Arrays.toString(newArr3));

        int[] newArr4 = arr.clone();
        System.out.println(Arrays.toString(newArr4));
    }
}
