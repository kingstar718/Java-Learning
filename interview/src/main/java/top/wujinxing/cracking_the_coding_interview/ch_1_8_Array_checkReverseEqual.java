package top.wujinxing.cracking_the_coding_interview;

/**
 * @author wujinxing
 * date 2019 2019/8/17 9:31
 * description 翻转子串
 *
 * 假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。
 * 请将这个算法编写成一个函数，给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。
 *
 * 给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
 *
 * 测试样例：
 * "Hello world","worldhello "
 * 返回：false
 * "waterbottle","erbottlewat"
 * 返回：true
 */
public class ch_1_8_Array_checkReverseEqual {

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(checkReverseEqual(s1, s2));
    }

    /**
     * 以s1=ABCD为例，我们先分析s1进行循环移位之后的结果：
     * ABCD->BCDA->CDAB->DABC->ABCD  .......
     * 假设我们把前面移走的数据进行保留：
     * ABCD->ABCDA->ABCDAB->ABCDABC->ABCDABCD.....
     * 因此看出，对s1做循环移位，所得字符串都将是字符串s1s1的子字符串。如果s2可以由s1循环移位得到，则一定可以在s1s1上。
     */
    private static boolean checkReverseEqual(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length()<=0) return false;

        String tem = s1 + s1;
        if (tem.contains(s2)) return true;
        return false;
    }



    //理解有误，不是这个意思
    private static boolean checkReverseEqual2(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length()<=0) return false;

        int[] array1 = new int[256];
        int[] array2 = new int[256];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (int i=0; i<s1.length(); i++){
            array1[c1[i]]++;
            array2[c2[i]]++;
        }
        for (int i=0; i<256; i++){
            if (array1[i]!=array2[i]){
                return false;
            }
        }
        return true;
    }
}
