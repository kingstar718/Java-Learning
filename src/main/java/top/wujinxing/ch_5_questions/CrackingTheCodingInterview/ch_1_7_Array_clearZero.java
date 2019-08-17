package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;

import java.util.Arrays;

/**
 * @author wujinxing
 * date 2019 2019/8/17 8:54
 * description 清除行列
 *
 * 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
 *
 * 给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat和矩阵的阶数n，
 * 请返回完成操作后的int[][]方阵(C++中为vector<vector><int>>)，保证n小于等于300，
 * 矩阵中的元素为int范围内。</int></vector></int></vector>
 *
 * 测试样例：
 * [[1,2,3],[0,1,2],[0,0,1]]
 * 返回：[[0,0,3],[0,0,0],[0,0,0]]
 *
 * （1）题目陷阱： *
 * 一看到这个题目可能会想到遍历整个矩阵，只要发现值为0，就将其所在行和与列全部清零。
 * 这个是个错误的思想，当清零的时候，0元素覆盖了还没有遍历到的元素，所以只有数组有一个零，最后就导致整个数组全为0。
 *
 * （2）思路一：
 * 可以新建有一个同样大小矩阵标记零元素出现的位置，然后在第二次遍历矩阵时将0元素所在行与列清零，这样做的空间复杂度为0(MN)。
 *
 * （3）思路二：
 * 其实如果一行或者一列中不管是有一个零元素还是多个，这行都是要被删除的，所以我们定义两个数组分别表示行、列是否有零元素，
 * 在第一次遍历的时候，确定这两个数组，第二次遍历的时候，根据这两个数组的内容，将对应位置元素清零。所以这样所需要的存储空间是O(M+N)。
 */
public class ch_1_7_Array_clearZero {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {0,1,2}, {0,0,1}};
        System.out.println(Arrays.deepToString(clearZero(mat, 3)));
    }

    private static int[][] clearZero(int[][] mat, int n) {
        if (mat.length<=0 || n<=0) return mat;

        boolean[] rowArray = new boolean[n];
        boolean[] columnArray = new boolean[n];

        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (mat[i][j]==0){
                    rowArray[i] = true;
                    columnArray[j] = true;
                }
            }
        }
        //遍历找到之前记录的位置，把相应行列赋值为0
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (rowArray[i] || columnArray[j])
                    mat[i][j] = 0;
            }
        }
        return mat;
    }
}
