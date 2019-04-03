package top.wujinxing.LeetCode.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/2/23 22:15
 * @description: 帕斯卡三角形
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 */
public class Pascal_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        if(numRows == 0){
            return triangle;
        }

        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);

        for(int rowNum = 1; rowNum < numRows; rowNum++){
            //当前数组
            List<Integer> row = new ArrayList<>();
            //上一个数组
            List<Integer> prevRow = triangle.get(rowNum - 1);

            //当前数组第一个是1
            row.add(1);

            //当前数组中间元素的计算：当前数组的第j个，是上一个数组第j-1个和第j个之和
            for(int j = 1; j < rowNum; j++){
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            //数组末为1
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    @Test
    public void test(){
        System.out.println(generate(6));
    }
}
