package top.wujinxing.datastructure.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/9/5 14:28
 * description 两个数组求交集
 *  有序 可不用hash
 *  无序 需要哈希
 *
 */
public class arrayAll {

    public static void main(String[] args) {
        int[] a1 = {1,2,3,4,5,6};
        int[] a2 = {0,1,3,4,8,10};
        System.out.println(jiao(a1,a2));
    }

    private static ArrayList<Integer> jiao(int[] a1, int[] a2){
        int[] arr = new int[Math.max(a1[a1.length-1], a2[a2.length-1])+1];
        for (int i=0; i<a1.length; i++){
            Integer n = a1[i];
            arr[n.hashCode()]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<a2.length; i++){
            Integer n = a2[i];
            if (arr[n.hashCode()] != 0){
                list.add(n);
            }
        }
        return list;
    }
}
