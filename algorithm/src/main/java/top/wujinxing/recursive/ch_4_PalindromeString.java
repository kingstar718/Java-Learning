package top.wujinxing.recursive;

/**
 * @author wujinxing
 * date 2019 2019/8/18 11:03
 * description 回文字符串的判断
 *
 * 文字符串就是正读倒读都一样的字符串。如"98789", "abccba"都是回文字符串
 */
public class ch_4_PalindromeString {

    /**
     * 递归判断回文字符串
     * @param s
     * @return
     */
    public static boolean isPalindromeString_recursive(String s){
        int start = 0;
        int end = s.length()-1;
        if (end > start){   // 递归终止条件:两个指针相向移动，当start超过end时，完成判断
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }else {
                return isPalindromeString_recursive(s.substring(start+1).substring(0,end-1));
            }
        }
        return true;
    }

    public static boolean isPalindromeString_loop(String s){
        char[] str = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while (end > start){
            if (str[end] != str[start]){   // 循环终止条件:两个指针相向移动，当start超过end时，完成判断
                return false;
            }else {
                end--;
                start++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeString_recursive("ababbaba"));
        System.out.println(isPalindromeString_loop("ababbaba"));
    }
}
