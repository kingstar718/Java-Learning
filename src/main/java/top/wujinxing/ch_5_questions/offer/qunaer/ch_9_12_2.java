package top.wujinxing.ch_5_questions.offer.qunaer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/12 15:27
 * description 二叉树遍历
 * 给出一个二叉树的中序遍历和后序遍历结果，求前序遍历结果输出
 * 输入
 * 第一行：中序遍历结果
 * 第二行：后续遍历结果
 * <p>
 * 输出
 * 前序遍历结果
 * <p>
 * 样例输入
 * dgbaechf
 * gbdehfca
 * 样例输出
 * adbgcefh
 */
public class ch_9_12_2 {

    //83%AC
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();*/
        String s1 = "dgbaechf";
        String s2 = "gbdehfca";
        TreeNode root = fun(s1,s2);
        System.out.println(first(root));

    }
    private static ArrayList<Character> list = new ArrayList<>();
    private static String first(TreeNode root){
        list.add(root.val);
        if (root.left != null){
            first(root.left);
        }
        if (root.right !=null){
            first(root.right);
        }
        StringBuilder sb = new StringBuilder();
        for (char c:list)
            sb.append(c);
        return sb.toString();

    }


    private static TreeNode fun(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return null;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), i);
        }
        return buildTree(s1,0, s1.length()-1, s2, 0, s2.length()-1, map);
    }

    public static TreeNode buildTree(String s1, int begin1, int end1,
                                     String s2, int begin2, int end2,
                                     HashMap map) {
        if (begin2 > end2)
            return null;
        if (begin1 == end1) {
            return new TreeNode(s1.charAt(begin1));
        }
        TreeNode root = new TreeNode(s2.charAt(end2));
        int index = (int) map.get(s2.charAt(end2));
        root.left = buildTree(s1, begin1, index - 1, s2, begin2, begin2 + index - begin1 - 1, map);
        root.right = buildTree(s1, index + 1, end1, s2, begin2 + index - begin1, end2 - 1, map);
        return root;
    }

    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
}
