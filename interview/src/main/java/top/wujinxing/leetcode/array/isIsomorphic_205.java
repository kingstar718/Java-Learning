package top.wujinxing.leetcode.array;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/4/9 09:45
 * @description:
 */
public class isIsomorphic_205 {
    public boolean isIsomorphic(String s, String t){
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }

    @Test
    public void test(){
        String s1 = "egg", t1 = "add";
        String s2 = "foo", t2 = "bar";
        String s3 = "paper", t3 = "title";
        System.out.println(isIsomorphic(s1,t1));
        System.out.println(isIsomorphic(s2,t2));
        System.out.println(isIsomorphic(s3,t3));
    }
}
