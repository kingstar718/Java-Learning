package top.wujinxing.ch_5_questions.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujinxing
 * date 2019 2019/7/2 10:10
 * description 将二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class _32_2_PrintTree {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
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

            if (list.size() != 0)
                ret.add(list);
        }
        return ret;
    }
}
