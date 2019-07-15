package top.wujinxing.sort;

/**
 * @author: wujinxing
 * @date: 2019/1/9 16:55
 * @description:选择排序
 */
public class SelectionSortArray {
    /**
     * 从原始数组中寻找到最小的值，将该值与当前的i进行交换，
     * 即第一个最小值与索引为0的值进行交换，第二个最小值与索引值1的进行交换
     * @param a
     * @param n
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n){
        for (int index = 0; index < n - 1; index++){
            int indexOfNextSmallest = getIndexOfSmallest(a, index, n-1);
            swap(a, index,indexOfNextSmallest);
        }
    }

    /**
     * 寻找数组中最小的值
     * @param a
     * @param first
     * @param last
     * @param <T>
     * @return
     */
    private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last){
        T min = a[first];
        int indexOfMin = first;
        for (int index = first+1; index <=last; index++){
            if (a[index].compareTo(min) < 0){
                min = a[index];
                indexOfMin = index;
            }
        }
        return indexOfMin;
    }

    /**
     * 交换数组的值
     * @param a
     * @param i
     * @param j
     */
    private static void swap(Object[] a, int i,int j){
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
