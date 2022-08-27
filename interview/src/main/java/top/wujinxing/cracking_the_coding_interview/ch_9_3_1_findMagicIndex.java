package top.wujinxing.cracking_the_coding_interview;

/**
 * @author wujinxing
 * date 2019 2019/8/19 21:22
 * description 魔术索引1
 *
 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。
 * 给定一个升序数组，元素值各不相同，编写一个方法，判断在数组A中是否存在魔术索引。
 * 请思考一种复杂度优于o(n)的方法。
 *
 * 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
 *
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：false
 */
public class ch_9_3_1_findMagicIndex {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(findMagicIndex(a, 5));
        System.out.println(findMagicIndex2(a, 5));
    }

    //递归版本
    private static boolean findMagicIndex2(int[] A, int n) {
        if(n == 0) {
            return true;
        }else {
            return magic(A,0,n);
        }

    }
    private static  boolean magic(int[] A, int start, int end){
        if (start >= end) return false;
        int mid = (start + end) >> 1;
        if (mid == A[mid]) {
            return true;
        }else if (mid > A[mid]){
            return magic(A, mid+1, end);
        }else {
            return magic(A, start, mid);
        }
    }

    //考虑采用二分法单边，时间复杂度O(logn)。非递归
    private static boolean findMagicIndex(int[] A, int n) {
        if (A==null ||A.length<=0 || n<=0) return false;

        int mid=0, start=0, end=n;
        while (start < end){
            mid = (start+end)>>1;
            if (mid == A[mid]){
                return true;
            }else if (mid > A[mid]){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return false;
    }
}
