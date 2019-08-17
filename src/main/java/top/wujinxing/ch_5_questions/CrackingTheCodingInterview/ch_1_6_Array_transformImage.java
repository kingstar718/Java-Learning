package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;

import java.util.Arrays;

/**
 * @author wujinxing
 * date 2019 2019/8/16 21:48
 * description 像素翻转
 *
 * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，
 * 在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
 *
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，
 * 图像元素小于等于256。
 *
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9]],3
 * 返回：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * 思路：1 2 3     7 8 9    7 4 1
 *      4 5 6 ->  4 5 6 -> 8 5 2  沿左上至右下对角线交换
 *      7 8 9     1 2 3    9 6 3
 */
public class ch_1_6_Array_transformImage {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(transformImage(mat, 3)));
    }

    private static int[][] transformImage(int[][] mat, int n) {
        for(int i=0; i<n/2; i++){
            for (int j=0; j<n; j++){
                //上下交换
                int temp = mat[i][j];
                mat[i][j] = mat[n-1-i][j];
                mat[n-1-i][j] = temp;
            }
        }
        for(int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                ///主对角线交换
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        return mat;
    }
}
