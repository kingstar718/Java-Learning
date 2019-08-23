package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.*;

/**
 * @author wujinxing
 * date 2019 2019/8/23 10:34
 * description 变位词排序
 *
 * 请编写一个方法，对一个字符串数组进行排序，将所有变位词合并，保留其字典序最小的一个串。
 * 这里的变位词指变换其字母顺序所构成的新的词或短语。例如"triangle"和"integral"就是变位词。
 *
 * 给定一个string的数组str和数组大小int n，请返回排序合并后的数组。
 * 保证字符串串长小于等于20，数组大小小于等于300。
 *
 * 测试样例：
 * ["ab","ba","abc","cba"]
 * 返回：["ab","abc"]
 */
public class ch_11_2_Sort_sortStrings {

    public ArrayList<String> sortStrings(String[] str, int n) {
        ArrayList<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (int i=0; i<n; i++){//找出所有变位词
            char[] chars = str[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            String value = map.get(key);
            if (value==null || value.compareTo(str[i])>0){
                map.put(key, str[i]);  //字典排序选变位词
            }
        }
        list.addAll(map.values());
        Collections.sort(list);//所有变位词排序
        return list;
    }

    //代码有问题  保留其字典序最小的一个串
    public ArrayList<String> sortStrings2(String[] str, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            list.add(i);
        }
        System.out.println(list);
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                if (comp(str[i], str[j])){
                    Object o = j;
                    list.remove(o);
                    System.out.println(j);
                }
            }
        }
        ArrayList<String> newList = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            newList.add(str[list.get(i)]);
        }
        return newList;
    }

    private boolean comp(String a, String b){
        int[] a1 = new int[256];
        char[] ac = a.toCharArray();
        for (int i=0; i<a.length(); i++){
            a1[ac[i]]++;
        }
        int[] b1 = new int[256];
        char[] bc = b.toCharArray();
        for (int i=0; i<b.length(); i++){
            b1[bc[i]]++;
        }
        for (int i=0; i<a1.length; i++){
            if (a1[i] != b1[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        List<String> list= new ArrayList<>();
        list.add("ab");
        list.add("ba");
        list.add("abc");
        list.add("cba");
        String[] str = {"ab","ba","abc","cba"};
        System.out.println(sortStrings(str, 4));
    }
}
