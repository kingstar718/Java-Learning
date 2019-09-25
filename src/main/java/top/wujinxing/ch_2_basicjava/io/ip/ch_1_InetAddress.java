package top.wujinxing.ch_2_basicjava.io.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wujinxing
 * date 2019 2019/9/25 15:02
 * description 使用InetAddress类
 */
public class ch_1_InetAddress {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.weixueyuan.net");
            String hostName = address.getHostName();
            String IPName = address.getHostAddress();
            System.out.println("主机域名：" + hostName + "\nIP地址：" + IPName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
