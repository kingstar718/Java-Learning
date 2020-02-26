package top.wujinxing.ch_5_questions.offer.Huawei;



import java.util.Scanner;

/**
 * @author wujinxing
 * date 2020 2020/2/26 19:37
 * description
 *
 * 输出新格式
 */
public class ch_20200226_2 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        String[] cnt = new String[100];
        String s = "a,,1,\"b,\"\"\"";
        System.out.println(s);
        int count = 0, flag = 0, len = s.length(), error = 0;

        for (int i=0; i<len; i++){
            if (s.charAt(i) == '"'){
                if (flag == 0){
                    if (cnt[count].length() > 0) error = 1;
                    else flag = 1;
                }
                else if (flag == 1){
                    if (i < len-1 && s.charAt(i+1) != ','){
                        if ((s.charAt(i+1) == '"')){
                            cnt[count] += '"';
                            i += 1;
                        }else {
                            error = 1;
                        }
                    }else {
                        flag = 0;
                        if (i != len - 1){
                            count++;
                            i++;
                        }
                    }
                }
            }else if (s.charAt(i) == ','){
                if (flag == 0) count++;
                else{
                    cnt[count] += s.charAt(i);
                }
            }else {
                cnt[count] += s.charAt(i);
            }
        }
        if (flag!=0 || error!=0){
            System.out.println("ERROR");
        }else {
            System.out.println(count + 1);
            for (int i=0; i<=count; i++){
                if (cnt[i] == "") System.out.println("--");
                else System.out.println(cnt[i]);
            }
        }
    }
}
