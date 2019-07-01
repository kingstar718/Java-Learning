package top.wujinxing.offer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/7/1 17:29
 * description 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class _66_multiply {

    @Test
    public void test(){
        int[] A = {1,2,3,4,5,6,7};
        int[] B = multiply(A);
        for (int num: B
             ) {
            System.out.print(num + " ");
        }
    }

    public int[] multiply(int[] A){
        int n = A.length;
        int[] B = new int[n];
        for (int i=0, product=1; i<n; product *= A[i], i++){
            B[i] = product;
        }
        for (int i=n-1, product=1; i>=0; product *= A[i], i--){
            B[i] *= product;
        }
        return B;
    }
}
