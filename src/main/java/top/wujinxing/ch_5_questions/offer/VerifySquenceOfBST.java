package top.wujinxing.ch_5_questions.offer;

import org.junit.Test;

/**
 * @ author: wujinxing
 * @ date: 2019/4/18 11:59
 * @ description: 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    private boolean VerifySquenceOfBST_1(int [] sequence) {
        if (sequence == null || sequence.length == 0){
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }
    private boolean verify(int[] sequence, int first, int last){
        if ((last - first) <= 1){
            return true;
        }
        int rootVal = sequence[last];
        int cutIndex = first;
        while (cutIndex < last && sequence[cutIndex] <= rootVal){
            cutIndex++;
        }
        for (int i = cutIndex; i < last; i++){
            if (sequence[i] < rootVal){
                return false;
            }
        }
        return verify(sequence, first, cutIndex - 1)  && verify(sequence, cutIndex, last -1);
    }

    @Test
    public void Test(){
        int[] a = {1,3,2};
        System.out.println(VerifySquenceOfBST_1(a));
    }
}
