package top.wujinxing.ch_5_questions.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujinxing
 * date 2019 2019/7/2 9:48
 * description 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class _32_3_PrintTree {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0){
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);  //queue 、list都是从左往右存
            }
            if (reverse)    //控制是否翻转list
                Collections.reverse(list);
            reverse = !reverse;
            if (list.size() != 0)
                ret.add(list);
        }
        return ret;
    }
}
