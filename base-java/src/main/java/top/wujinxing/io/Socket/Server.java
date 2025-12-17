package top.wujinxing.io.Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wujinxing
 * @date 2019/4/25 11:42
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println(Thread.currentThread().getName() + ":服务端已启动，等待客户端连接...");
            while (true) {
                // 侦听并接受到此套接字的连接,返回一个Socket对象
                Socket socket = serverSocket.accept();
                SocketThread socketThread = new SocketThread(socket);
                socketThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
