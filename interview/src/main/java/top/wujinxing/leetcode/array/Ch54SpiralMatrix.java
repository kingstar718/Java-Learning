package top.wujinxing.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujinxing
 */
public class Ch54SpiralMatrix {

    /**
     * 从左到右遍历上侧元素，依次为 ( top , left ) (top,left) 到 ( top , right ) (top,right)。
     * 从上到下遍历右侧元素，依次为 ( top + 1 , right ) (top+1,right) 到 ( bottom , right ) (bottom,right)。
     * 如果 left < right left<right 且 top < bottom top<bottom，则从右到左遍历下侧元素，依次为 ( bottom , right − 1 ) (bottom,right−1) 到 ( bottom , left + 1 ) (bottom,left+1)，以及从下到上遍历左侧元素，依次为 ( bottom , left ) (bottom,left) 到 ( top + 1 , left ) (top+1,left)。
     * 作者：LeetCode-Solution 链接：<a href="https://leetcode.cn/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode-solution/">...</a>
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

}
