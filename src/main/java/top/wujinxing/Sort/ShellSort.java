package top.wujinxing.Sort;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/1/9 20:58
 * @description: 希尔排序 平均情况O(n1.5) 最好O(n) 最坏O(n2 or n1.5)
 */
public class ShellSort {
    /**
     * Sorts equally spaced entries of an array into ascending order;
     * @param a an array of Comparable objects
     * @param first the Integer index of the first array entry to consider; first >= 0 and < a.length 首元素的索引
     * @param last  the Integer index of the last array entry to consider; last >= first and < a.length 末尾元素的索引
     * @param space the difference between the indices of the entries to sort
     * @param <T>
     */
    private static <T extends Comparable<? super T>> void incrementalInsertionSort(T[] a, int first, int last, int space){
        int unsorted, index;
        //space一般为数组的一半，首个for循环是从first-firstspace-》末尾 两个相隔space距离为一组数比较
        for(unsorted = first+space; unsorted <= last; unsorted = unsorted+space){
            //对应的值
            T nextToInsert = a[unsorted];
            for(index = unsorted-space; (index >= first)&&(nextToInsert.compareTo(a[index])< 0); index = index-space){
                a[index+space] = a[index];
            }
            a[index+space] = nextToInsert;
        }
    }

    public static <T extends Comparable<? super T>> void shellSort(T[] a, int first, int last){
        int n = last - first + 1;
        for (int space = n/2; space > 0; space = space/2){
            for (int begin = first;begin < first+space; begin++){
                incrementalInsertionSort(a,begin, last,space);
            }
        }
    }


    @Test
    public void test(){
        Integer[] a = {1,3,4,5,2,33,12,56};
        shellSort(a,0,7);
        for (int a1: a
             ) {
            System.out.println(a1);
        }
    }
}
