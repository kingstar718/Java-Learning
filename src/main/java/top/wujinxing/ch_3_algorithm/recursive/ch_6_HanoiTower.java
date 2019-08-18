package top.wujinxing.ch_3_algorithm.recursive;

/**
 * @author wujinxing
 * date 2019 2019/8/18 11:29
 * description 汉诺塔问题
 *
 * 古代有一个梵塔，塔内有三个座A、B、C，A座上有64个盘子，盘子大小不等，大的在下，小的在上。
 * 有一个和尚想把这64个盘子从A座移到C座，但每次只能允许移动一个盘子，并且在移动过程中，3个座上的盘子始终保持大盘在下，
 * 小盘在上。在移动过程中可以利用B座。要求输入层数，运算后输出每步是如何移动的。
 */
public class ch_6_HanoiTower {

    public static void moveDish(int level, char from, char inter, char to){
        if (level == 1){
            System.out.println("从" + from + " 移动盘子" + level + " 号到" + to);
        }else {
            // 递归调用：将level-1个盘子从from移到inter(不是一次性移动，每次只能移动一个盘子,其中to用于周转)
            moveDish(level - 1, from, to, inter);
            // 将第level个盘子从A座移到C座
            System.out.println("从" + from + " 移动盘子" + level + " 号到" + to);
            // 递归调用：将level-1个盘子从inter移到to,from 用于周转
            moveDish(level - 1, inter, from, to);  // 递归调用，缩小问题的规模
        }
    }

    public static void main(String[] args) {
        int nDisks = 30;
        moveDish(nDisks, 'A', 'B', 'C');
    }
}
