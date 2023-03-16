package top.wujinxing.leetcode.tree;

import java.util.*;

/**
 * @author wujinxing
 * @date 2023/3/15
 */
public class TreeUtils {

    private TreeUtils() {
    }

    public static TreeNode generate(int[] array) {
        Integer[] res = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
        }
        return generate(res);
    }

    public static TreeNode generate(Integer[] array) {
        return generate(array, 0);
    }

    public static TreeNode generate(Integer[] array, Integer start) {
        if (array.length == 0 || array[start] == null) {
            return null;
        }
        TreeNode root = new TreeNode(array[start]);
        int leftNode = 2 * start + 1;
        int rightNode = 2 * start + 2;
        if (leftNode > array.length - 1) {
            root.left = null;
        } else {
            root.left = generate(array, leftNode);
        }
        if (rightNode > array.length - 1) {
            root.right = null;
        } else {
            root.right = generate(array, rightNode);
        }
        return root;
    }


//    public static String print(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null){
//            return res.toString();
//        }
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode curr = queue.poll();
//            res.add(curr.val);
//            if (curr.left != null && curr.right != null) {
//                queue.offer(curr.left);
//                queue.offer(curr.right);
//            } else if (curr.left != null) {
//
//            }
//            if (curr.left != null) {
//                queue.offer(curr.left);
//            }
//            if (curr.right != null) {
//                queue.offer(curr.left);
//            }
//        }
//        return res.toString();
//    }

}
