package top.wujinxing.designpatterns.Builder;

/**
 * @author: wujinxing
 * @date: 2019/4/9 20:30
 * @description: 生成器
 */
public class Client {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        final int count = 26;
        for (int i = 0; i < count; i++){
            sb.append((char)('a'+i));
        }
        System.out.println(sb.toString());
    }
}
