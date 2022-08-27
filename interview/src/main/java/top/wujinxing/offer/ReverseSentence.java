package top.wujinxing.offer;

/**
 * @author wujinxing
 * date 2019/4/29 09:54
 * description 翻转单词顺序
 *
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，+
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    public static void main(String[] args) {
        String str = "student. a am I";
        String result = reverseSentence(str);
        System.out.println(result);
    }

    private static String reverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i=0, j=0;
        while (j<=n){
            if (j==n||chars[j]==' '){
                reverse(chars, i, j-1);
                i = j+1;
            }
            j++;
        }
        reverse(chars, 0, n-1);
        return new String(chars);
    }

    private static void reverse(char[] c, int i, int j){
        //翻转字符数组
        while (i<j){
            swap(c, i++, j--);
        }
    }
    private static void swap(char[] c, int i, int j){
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}