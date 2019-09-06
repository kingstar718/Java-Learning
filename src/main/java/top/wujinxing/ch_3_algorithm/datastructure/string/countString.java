package top.wujinxing.ch_3_algorithm.datastructure.string;

/**
 * @author wujinxing
 * date 2019 2019/9/4 9:08
 * description 统计字符串
 * <p>
 * 输入
 * aaaabbbccssaa
 * a4b3c2s2a2
 */
public class countString {

    public static void main(String[] args) {
        String str = "aaaabbbccssaaapc";
        System.out.println(countStr(str));
    }

    /**
     * 1.字符串为空，即不存在
     * 2.不为空，新建字符串res表示统计的字符串，num代表当前字符的数量初始res只包含str的第0个字符，同时num=1
     * 3.从str[1]开始，从左到右遍历str，假设遍历到i位置，如果str[i]=str[i-1]表示未结束，num++
     *   若str[i]!=str[i-1] 前面连续已结束，另res = num+res+str[i]且另num=1
     *   继续遍历
     * 4.结束时考虑临界条件
     *
     * @param str 输入字符串
     * @return int
     */
    private static String countStr(String str) {
        if (str == null || str.length() <= 0)
            return null;

        String res = String.valueOf(str.charAt(0));
        int num = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                num++;
            } else {
                res = res + num + str.charAt(i);
                num = 1;
            }
            //结束时的临界要加上,最后一位与之前不连续时
            if (i == str.length() - 1) {
                res = res + num;
            }
        }
        return res;
    }
}
