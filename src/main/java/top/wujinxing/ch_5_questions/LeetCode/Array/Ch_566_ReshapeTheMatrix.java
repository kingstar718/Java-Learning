package top.wujinxing.ch_5_questions.LeetCode.Array;

import com.alibaba.fastjson.JSON;


/**
 * @author wujinxing
 * @date 2022-03-26
 * @link
 */
public class Ch_566_ReshapeTheMatrix {

    private static int[][] reshapeTheMatrix(int[][] mat, int r, int c) {
        int oR = mat.length;
        int oC = mat[0].length;
        int len = oR * oC;
        if (len != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        int[] temp = new int[oR * oC];
        int idx = 0;
        for (int[] ma : mat) {
            for (int m : ma) {
                temp[idx++] = m;
            }
        }
        // 我实际想要的是 0123 4567 891011
        for (int i = 0; i < r; i++) {
            int m = i * c;
            for (int j = 0; j < c; j++) {
                result[i][j] = temp[m + j];
            }
        }
        return result;
    }

    private static int[][] reshapeMatrix(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        int idx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 这里很巧妙
                result[i][j] = mat[idx / n][idx % n];
                idx++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
        System.out.println(JSON.toJSON(a));
        int[][] ints1 = reshapeTheMatrix(a, r, c);
        int[][] ints2 = reshapeTheMatrix(a, 2, c);
        int[][] ints3 = reshapeMatrix(a, r, c);
        int[][] ints4 = reshapeMatrix(a, 2, c);
        System.out.println(JSON.toJSON(ints1));
        System.out.println(JSON.toJSON(ints2));
        System.out.println(JSON.toJSON(ints3));
        System.out.println(JSON.toJSON(ints4));
    }
}
