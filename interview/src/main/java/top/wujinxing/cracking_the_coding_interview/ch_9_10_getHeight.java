package top.wujinxing.cracking_the_coding_interview;


/**
 * 有一堆箱子，每个箱子宽为wi，长为di，高为hi，现在需要将箱子都堆起来，而且为了使堆起来的箱子不倒，
 * 上面的箱子的宽度和长度必须小于下面的箱子。请实现一个方法，求出能堆出的最高的高度，这里的高度即堆起来的所有箱子的高度之和。
 *
 * 给定三个int数组w,l,h，分别表示每个箱子宽、长和高，同时给定箱子的数目n。请返回能堆成的最高的高度。保证n小于等于500。
 *
 * 测试样例：
 * [1,1,1],[1,1,1],[1,1,1]
 * 返回：1
 */
public class ch_9_10_getHeight {

    /**
     * 经典的有向无环图模型的DP问题
     * 选择某个起点使之有向无环图的最大路径长度
     */
    public int getHeight(int[] w, int[] l, int[] h, int n) {
        boolean[][] graph = new boolean[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                //使底部的箱子长宽大于上面的，若有箱子长宽小，则有到其的有向边
                if (w[i]>w[j] && l[i]>l[j])
                    graph[i][j] = true;
            }
        }

        int[] dp = new int[n];
        int ans = 0;
        for (int i=0; i<n; i++){
            int tmp = dfs(i, graph, h, dp);
            ans = Math.max(ans, tmp);
        }
        return ans;
    }

    private int dfs(int bottom, boolean[][] graph, int[] h, int[] dp){
        if (dp[bottom]>0) return dp[bottom];

        int n = graph.length;
        int top = 0;
        for (int i=0; i<n; i++){
            if (graph[bottom][i])
                top = Math.max(top, dfs(i, graph, h, dp));
        }
        return dp[bottom] = top + h[bottom];//缓存当前结点的最大路径长度
    }
}
