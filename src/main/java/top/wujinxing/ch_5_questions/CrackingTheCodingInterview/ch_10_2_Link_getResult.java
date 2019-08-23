package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;


import org.junit.Test;

import java.util.LinkedList;

/**
 *
 * 约瑟夫环问题1
 *
 *约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。有n个人站成一列。
 * 并从头到尾给他们编号，第一个人编号为1。然后从头开始报数，
 * 第一轮依次报1，2，1，2...然后报到2的人出局。
 * 接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。
 * 以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。
 * 给定一个int n，代表游戏的人数。请返回最后一个人的编号
 * 测试样例：
 * 5
 * 返回：5
 */
public class ch_10_2_Link_getResult {

    public int getResult(int n) {
        if (n < 1)
            return -1;

        LinkedList<Integer> idList = new LinkedList<>();
        for (int i=1; i<=n; i+=2){  //第一轮偶数全部出局
            idList.add(i);
        }

        int j=3;//第二轮开始就是报三个数了
        while (j<=n){
            idList.addFirst(idList.removeLast());//尾部数值移动到头部

            int len = idList.size();
            int k = 1;
            for (int i=1; i<=len; i++){
                if (i%j != 1) { //只保留了1,2,3...j中的第一个1
                    idList.remove(i-k);
                    k++;
                }
            }
            if (idList.size() <= j){
                return idList.getLast();
            }
            j++;
        }
        return 1;
    }

    @Test
    public void test(){
        System.out.println(getResult(5));
    }
}
