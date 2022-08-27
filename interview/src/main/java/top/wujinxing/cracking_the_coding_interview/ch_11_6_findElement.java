package top.wujinxing.cracking_the_coding_interview;

/**
 * @author wujinxing
 * date 2019 2019/8/23 12:09
 * description 矩阵元素查找
 *
 * 有一个NxM的整数矩阵，矩阵的行和列都是从小到大有序的。
 * 请设计一个高效的查找算法，查找矩阵中元素x的位置。
 *
 * 给定一个int有序矩阵mat，同时给定矩阵的大小n和m以及需要查找的元素x，
 * 请返回一个二元数组，代表该元素的行号和列号(均从零开始)。保证元素互异。
 *
 * 测试样例：
 * [[1,2,3],[4,5,6]],2,3,6
 * 返回：[1,2]
 */
public class ch_11_6_findElement {

    /**
     *从右上角开始，每次将搜索值与右上角的值比较，
     * 如果大于右上角的值，则直接去除1行，否则，则去掉1列。
     */

    public int[] findElement(int[][] mat, int n, int m, int x) {
        int[] result = new int[2];
        if (n==0 || m==0)
            return result;
        int i=0, j=m-1;

        while (i<n && j>=0){
            //大于目标。剔除这个数字所在的列
            if (mat[i][j] > x){
                --j;
            }else if (mat[i][j] < x){
                //小于目标，剔除这个数字所在的行
                ++i;
            }else {
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
        return result;
    }
}
