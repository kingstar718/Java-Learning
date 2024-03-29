package top.wujinxing.leetcode.tree;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/12/2 20:10
 * description 不同的二叉搜索树
 * <p>
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 */
public class ch_96_UniqueBinarySearchTrees {

    /**
     * 卡塔兰数
     * C0 = 1; C(n+1) = {(2(2n+1))/(n+2)}*Cn
     */
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    /**
     * 动态规划
     */
    public int numTrees2(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    @Test
    public void test() {
        System.out.println(numTrees(3));
        System.out.println(numTrees(10));
        System.out.println(numTrees2(3));
        System.out.println(numTrees2(10));
    }
}
