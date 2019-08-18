package top.wujinxing.ch_3_algorithm.recursive;

/**
 * @author wujinxing
 * date 2019 2019/8/18 10:58
 * description 递归获取杨辉三角指定行、列(从0开始)的值  注意：与是否创建杨辉三角无关
 *
 * Title: 杨辉三角形又称Pascal三角形，它的第i+1行是(a+b)i的展开式的系数。
 *
 * 它的一个重要性质是：三角形中的每个数字等于它两肩上的数字相加。
 *
 * 例如，下面给出了杨辉三角形的前4行：
 *     *    1
 *     *   1 1
 *     *  1 2 1
 *     * 1 3 3 1
 */
public class ch_3_yanghui {

    /**
     * 递归获取杨辉三角指定行、列(从0开始)的值
     * 注意：与是否创建杨辉三角无关
     * @param x 指定行
     * @param y 指定列
     * @return int
     */
    public static int getValue(int x, int y){
        if (y <= x && y >= 0){
            if (y == 0 || x == y){ // 递归终止条件
                return 1;
            }else {
                return getValue(x-1, y-1) + getValue(x-1, y); // 递归调用，缩小问题的规模
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getValue(3,1));
    }

}
