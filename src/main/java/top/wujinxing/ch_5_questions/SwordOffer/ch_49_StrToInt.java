package top.wujinxing.ch_5_questions.SwordOffer;


import org.junit.Test;

/**
 *  Str to Int
 */
public class ch_49_StrToInt {

    public int StrToInt(String str){
        if (str==null||str.trim().equals(" "))
            return 0;

        char[] chars = str.trim().toCharArray();
        int res = 0;
        for (int i=(chars[0]=='-'||chars[0]=='+')?1:0; i<str.length(); i++){
            if (chars[i]<'0'||chars[i]>'9')
                return 0;
            int num = chars[i] - '0';
            int sum = res*10+num;
            if ((sum-num)/10!=res)
                return 0;
            res = sum;
        }
        return chars[0] == '-' ? -res : res;
    }

    @Test
    public void test(){
        String s1 = "-283827382";
        String s2 = "22421";
        System.out.println(StrToInt(s1));
        System.out.println(StrToInt(s2));
    }

}
