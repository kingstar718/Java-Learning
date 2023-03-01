package top.wujinxing.leetcode.array;

/**
 * @author wujinxing
 */
public class Ch59SpiralMatrix2 {

    /**
     * 给定一个正整数n，声称一个包含1到n^2的所有元素，且按顺时针螺旋排序的nxn正方形矩阵
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int x = 1;
        while (x <= n * n) {
            // 上
            for (int i = left; i <= right; i++) {
                res[top][i] = x;
                x++;
            }
            top++;
            if (top > bottom) {
                break;
            }
            // 右
            for (int i = top; i<= bottom; i++) {
                res[i][right] = x;
                x++;
            }
            right--;
            if (left > right) {
                break;
            }
            // 下
            for (int i = right; i >= left; i--) {
                res[bottom][i] = x;
                x++;
            }
            bottom--;
            // 这里好像不太对
//            if (left > right) {
//                break;
//            }
            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res[i][left] = x;
                x++;
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return res;
    }
}
