package top.wujinxing.offer;

/**
 * @author wujinxing
 * date 2019 2019/7/2 15:48
 * description 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如
 * a b c e
 * s f c s
 * a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */
public class _12_hasPath {
    private final static int[][] next = {{0,-1},{0,1},{-1,0},{1,0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str){
        if (rows==0 || cols==0) return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++)
                if (backtracking(matrix, str, marked, 0, i, j))
                    return true;
        }
        return false;
    }
    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c){
        if (pathLen==str.length) return true;
        if (r<0 || r>=rows || c<0 || c>=cols || matrix[r][c] != str[pathLen] || marked[r][c]) return false;
        marked[r][c] = true;
        for (int[] n: next)
            if (backtracking(matrix, str, marked, pathLen+1, r+n[0], c+n[1]))
                return true;
        marked[r][c] = false;
        return false;
    }
    //将矩阵变成2维的
    private char[][] buildMatrix(char[] array){
        char[][] matrix = new char[rows][cols];
        for (int i=0,idx=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                matrix[i][j] = array[idx++];
            }
        }
        return matrix;
    }
}
