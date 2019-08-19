package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;

/**
 * @author wujinxing
 * date 2019 2019/8/19 19:50
 * description 高度最小的BST
 *
 * 题目描述
 * 对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。
 * 给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
 */
public class ch_4_3_Tree_buildMinimalBST {

    private static int buildMinimalBST(int[] vals) {
        if (vals==null||vals.length<=0){
            return 0;
        }

        return build(vals, 0, vals.length-1);
    }

    private static int build(int[] vals, int start, int end){
        if (end <= start) return 1; //递归终止条件

        int mid = (start + end) >> 1;
        int height1 = 1 + build(vals, start, mid-1);
        int height2 = 1 + build(vals, mid+1, end);
        return Math.max(height1, height2);
    }

}
