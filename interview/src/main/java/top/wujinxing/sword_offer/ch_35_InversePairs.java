package top.wujinxing.sword_offer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/9/11 0:16
 * description 数组中的逆序对
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * <p>
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * <p>
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 */
public class ch_35_InversePairs {
    //利用归并排序的每次`merge()`过程
    //因为`merge()`过程，处理的两个范围都是有序的，即`[L, mid]`有序， `[mid+1, R]`有序；
    //我们可以在这里做手脚，当两部分出现`arr[p1] > arr[p2]`的时候，结果直接可以累加`mid - p1 + 1`个，这样就可以利用归并来降低复杂度；

    private static final int mod = 1000000007;


    //不正确
    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1)
            return 0;
        return mergeRec(array, 0, array.length - 1);
    }

    private static int mergeRec(int[] arr, int L, int R) {
        if (L == R)
            return 0;
        int mid = (L + R) / 2;
        return (mergeRec(arr, L, mid) + mergeRec(arr, mid + 1, R)) % mod
                + merge(arr, L, mid, R) % mod;
    }

    private static int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int k = 0, sum = 0;
        int p1 = L, p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            if (arr[p1] <= arr[p2]) {
                help[k++] = arr[p2++];
            } else {  //arr[p1] > arr[p2], 此时p2~R都小于arr[p1, mid]之间的元素，从这里求得逆序数
                sum += (mid - p1 + 1);
                sum %= mid;
                help[k++] = arr[p2++];
            }
        }
        while (p1 <= mid)
            help[k++] = arr[p1++];
        while (p2 <= R)
            help[k++] = arr[p2++];
        for (int i = 0; i < k; i++) {
            arr[L + i] = help[i];
        }
        return sum;
    }

    //超时
    public int InversePairs2(int[] array) {
        if (array == null || array.length <= 1)
            return 0;
        int count = 0;
        for (int i=0; i<array.length; i++){
            for (int j=i+1; j<array.length; j++){
                if (array[i] > array[j])
                    count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(arr));
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs2(arr2));
    }
}
