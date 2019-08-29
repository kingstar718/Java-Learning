package top.wujinxing.ch_5_questions.SwordOffer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/8/29 13:05
 * description 二维数组中的查找
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class ch_01_FindInArray {

    private boolean find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; //从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) { //比右上角的大，说明不在矩阵左边，在当前列的下边
                r++;
            } else { //说明比在该数的左边
                c--;
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        System.out.println(find(17, matrix));
        System.out.println(find(22, matrix));
    }
}
