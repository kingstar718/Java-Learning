package top.wujinxing.ch_5_questions.offer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author: wujinxing
 * @date: 2019/3/11 09:51
 * @description:
 *
 * 顺时针外圈到内圈打印数组
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * 1   2  3  4
 * 5   6  7  8
 * 9  10 11 12
 * 13 14 15 16
 */
public class printMatrix {
    public ArrayList<Integer> printMatrix(int[][] array){
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length == 0) return result;
        int n = array.length, m = array[0].length; //n--列数  m--行数
        if (m == 0) return result;
        int layers = (Math.min(n, m)-1)/2+1;//层数
        for (int i = 0; i < layers; i++){
            for (int k = i; k < m-i; k++) result.add(array[i][k]);  //左至右
            for (int j = i+1; j < n-i; j++) result.add(array[j][m-i-1]);    //右上至右下
            for (int k = m-i-2; (k>=i)&&(n-i-1!=i); k--) result.add(array[n-i-1][k]);//右至左
            for (int j = n-i-2; (j>i)&&(m-i-1!=i); j--) result.add(array[j][i]);//左下至左上
        }
        return result;
    }

    @Test
    public void test(){
        int[][] a= {{1,2,3},{4,5,6},{7,8,9},{2,3,4}};
        int[][] b = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(printMatrix(a));
        System.out.println(printMatrix(b));
    }
}
