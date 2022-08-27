package top.wujinxing.cracking_the_coding_interview;


import org.junit.Test;

import java.util.LinkedList;

/**
 *
 * 约瑟夫环问题1
 *
 * 题目描述
 * 约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。
 * 然后由第一个人开始报数，数到m的人出局。现在需要求的是最后一个出局的人的编号。
 *
 * 给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000。
 *
 * 测试样例：
 * 5 3
 * 返回：4
 * 1 2 3 4 5
 */
public class ch_10_1_Link_getResult {

    public int getResult(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=1; i<=n; i++){
            list.add(i);
        }

        int bt = 0;
        while (list.size()>1){
            int delPos = (bt + m - 1) % list.size();
            list.remove(delPos);
            bt = delPos % list.size();
        }

        return list.get(0);
    }

    @Test
    public void test(){
        System.out.println(getResult(5, 3));
    }
}
