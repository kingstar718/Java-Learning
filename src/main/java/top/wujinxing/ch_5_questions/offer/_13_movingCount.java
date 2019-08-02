package top.wujinxing.ch_5_questions.offer;

/**
 * @author wujinxing
 * date 2019 2019/7/2 17:11
 * description 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class _13_movingCount {

    private static final int[][] next = {{0,-1},{0,1},{-1,0},{1,0}};
    private int cnt = 0;
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digitSum;

    public int movingCount(int threshold, int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return cnt;
    }
    private void dfs(boolean[][] marked, int r, int c){
        if (r<0||r>=rows||c<0||c>=cols||marked[r][c]) return;
        marked[r][c] = true;
        if (this.digitSum[r][c]>this.threshold) return;
        cnt++;
        for (int[] n: next){
            dfs(marked, r+n[0], c+n[1]);
        }
    }
    private void initDigitSum(){
        int[] digitSum = new int[Math.max(rows, cols)];
        for (int i=0; i<digitSum.length; i++){
            int n=i;
            while (n>0){
                digitSum[i] += n%10;
                n /= 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for (int i=0; i<this.rows; i++){
            for (int j=0; j<this.cols; j++){
                this.digitSum[i][j] = digitSum[i]+digitSum[j];
            }
        }
    }
}
