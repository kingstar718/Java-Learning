package top.wujinxing.ch_5_questions.offer.Aqiyi;


import java.util.HashSet;
import java.util.Scanner;

/**
 * @ author: wujinxing
 * @ date: 2019/4/23 15:31
 * @ description: DNA序列
 *
 * 题目描述
 * 牛牛又从生物科研工作者那里获得一个任务,
 * 这次牛牛需要帮助科研工作者从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度。
 *
 * 例如:s = AGGTCTA
 * 序列中包含了所有长度为1的('A','C','G','T')片段,但是长度为2的没有全部包含,
 * 例如序列中不包含"AA",所以输出2。
 *
 * 输入描述:
 * 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 2000),其中只包含'A','C','G','T'这四种字符。
 * 输出描述:
 * 输出一个正整数,即最短没有出现在DNA序列s中的DNA片段的长度。
 *
 * 示例1
 * 输入
 * AGGTCTA
 * 输出
 * 2
 */
public class DNA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int i,j,n = s.length();
        for (i=1; i <= n; i++){
            HashSet<String> set = new HashSet<>();
            for (j=0; j <= n-i; j++){
                set.add(s.substring(j,j+i));
            }
            if (set.size()<Math.pow(4,i)){
                System.out.println(i);
                break;
            }
        }


        /*//System.out.println(s);
        int aNum = 0;
        int cNum = 0;
        int gNum = 0;
        int tNum = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='A'){
                aNum++;
            }else if(s.charAt(i)=='C'){
                cNum++;
            }else if (s.charAt(i)=='G'){
                gNum++;
            }else {
                tNum++;
            }
        }
        boolean Abool = true;
        boolean Cbool = true;
        boolean temp = true;
        if (aNum <gNum){
            Abool = true;
        }else {
            Abool = false;
        }
        if (cNum<tNum){
            Cbool = true;
        }else {
            Cbool = false;
        }
        char minchar;
        if (Abool==true && Cbool==true){
            if (aNum<cNum){
                minchar = 'A';
            }else {
                minchar = 'C';
            }
        }else if (Abool==true && Cbool==false){
            if (aNum<tNum){
                minchar = 'A';
            }else {
                minchar = 'T';
            }
        }else if (Abool==false && Cbool==true){
            if (gNum<cNum){
                minchar = 'G';
            }else {
                minchar = 'C';
            }
        }else {
            if (gNum<tNum){
                minchar = 'G';
            }else {
                minchar = 'T';
            }
        }
        int count = 0;
        for(int i=0; i<s.length()-1;i++){
            if (s.charAt(i)==minchar){
                if (s.charAt(i)==s.charAt(i+1)){
                    
                }
            }
        }*/
    }
}
