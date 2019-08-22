package top.wujinxing.ch_5_questions.offer.meituan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/22 16:06
 * description
 */
public class huoxingwen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        System.out.println(func(strings));

    }

    private static String func(String[] words){
        HashMap<Character, HashSet<Character>> g = new HashMap<>();
        HashMap<Character, Integer> v = new HashMap<>();
        buildG(g, v, words);
        StringBuffer sb = new StringBuffer();
        
        for (char c: v.keySet()){
            if (v.get(c)==0 && !DFS(g, v, sb, c)) return "";
        }

        return sb.reverse().toString();
    }

    private static boolean DFS(HashMap<Character, HashSet<Character>> g,
                       HashMap<Character, Integer> v, 
                       StringBuffer sb,
                       char c){
        if (v.get(c)!=0){
            return v.get(c)==2;
        }else {
            v.put(c,1);
            HashSet<Character> next = g.get(c);
            if (next!=null){
                for (char nx: next
                     ) {
                    if (!DFS(g, v, sb, nx)) return false;
                }
            }
            v.put(c,2);
            sb.append(c);
            return true;
        }
    }

    private static void buildG(HashMap<Character, HashSet<Character>> g, HashMap<Character, Integer> v, String[] words){
        for (int i=0; i<words.length; i++){
            char[] chars = words[i].toCharArray();
            for (char c: chars
                 ) {
                v.putIfAbsent(c, 0);
            }
            
            if (i>0){
                char[] pre = words[i-1].toCharArray();
                int l = Math.min(pre.length, chars.length);
                
                for (int j=0; j<l; j++){
                    if (pre[j] != chars[j]){
                        if (!g.containsKey(pre[j]))
                            g.put(pre[j], new HashSet<>());
                        g.get(pre[j]).add(chars[j]);
                        break;
                    }
                }
            }
        }
    }
}
