package top.wujinxing.io.Socket;

import java.io.*;
import java.net.Socket;

/**
 * @author wujinxing
 * @date 2019/4/25 11:33
 */
public class SocketThread extends Thread {

    private final Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 得到一个输入流，接收客户端传递的信息
            InputStream inputStream = socket.getInputStream();
            // 提高效率，将自己字节流转为字符流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //加入缓冲区
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String temp = null;
            String info = "";
            while ((temp = bufferedReader.readLine()) != null) {
                info += temp;
                System.out.println(Thread.currentThread().getName() + ":已接收到客户端连接");
                System.out.println(Thread.currentThread().getName() + ":服务端接收到客户端信息：" + info + ",当前客户端ip为："
                        + socket.getInetAddress().getHostAddress());
            }
            // 获取一个输出流，向服务端发送信息
            OutputStream outputStream = socket.getOutputStream();
            // 将输出流包装成打印流
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("你好，服务端已接收到您的信息");
            printWriter.flush();
            socket.shutdownOutput();

            //关闭资源
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
