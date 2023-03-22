package top.wujinxing.leetcode.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujinxing
 * @date 2019/4/11 09:16
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private static final String EMPTY = "[]";
    private static final String NULL = "null";

    public static TreeNode deserialize(String data) {
        if (EMPTY.equals(data)) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < vals.length && !vals[i].equals(NULL)) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (i < vals.length && !vals[i].equals(NULL)) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static TreeNode deserialize(Integer[] array) {
        return deserialize(JSON.toJSONString(array));
    }


    public static TreeNode deserialize(int[] array) {
        Integer[] arrays = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            arrays[i] = array[i];
        }
        return deserialize(arrays);
    }


    public static String serialize(TreeNode root) {
        if (root == null) {
            return EMPTY;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add(NULL);
            }
        }
        int endIndex = result.size() - 1;
        for (int i = result.size() - 1; i >= 0; i--) {
            if (!NULL.equals(result.get(i))) {
                endIndex = i + 1;
                break;
            }
        }
        result = result.subList(0, endIndex);
        return result.toString().replace(" ", "");
    }

}
