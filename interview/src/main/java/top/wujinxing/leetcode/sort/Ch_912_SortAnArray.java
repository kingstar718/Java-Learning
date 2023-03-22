package top.wujinxing.leetcode.sort;

/**
 * @author wujinxing
 * @date 2023/3/22
 */
public class Ch_912_SortAnArray {

    public static int[] sortArray(int[] numbs) {
        quickSort(numbs, 0, numbs.length - 1);
        return numbs;
    }

    private static void quickSort(int[] numbs, int left, int right) {
        // 结束条件
        if (left >= right) {
            return;
        }
        // 分区
        int partitionIndex = partition(numbs, left, right);
        // 递归左分区
        quickSort(numbs, left, partitionIndex - 1);
        // 递归右分区
        quickSort(numbs, partitionIndex + 1, right);
    }

    private static int partition(int[] numbs, int left, int right) {
        // 基准值
        int pivot = numbs[left];
        // 标记下标
        int mark = left;
        for (int i = left + 1; i <= right; i++) {
            if (numbs[i] < pivot) {
                // 小于基准值，则mark后移，并交换位置
                mark++;
                int temp = numbs[mark];
                numbs[mark] = numbs[i];
                numbs[i] = temp;
            }
        }
        // 将基准值放到mark的位置
        numbs[left] = numbs[mark];
        numbs[mark] = pivot;
        return mark;
    }
}
