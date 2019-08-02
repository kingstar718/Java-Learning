package top.wujinxing.ch_2_basicjava.io.Socket;

import java.io.*;
import java.net.Socket;

/**
 * @author wujinxing
 * @date 2019/4/25 11:33
 * @description
 */
public class SocketThread extends Thread {
    private Socket socket;
    public SocketThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();// 得到一个输入流，接收客户端传递的信息
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);// 提高效率，将自己字节流转为字符流
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//加入缓冲区
            String temp = null;
            String info = "";
            while ((temp=bufferedReader.readLine())!=null){
                info += temp;
                System.out.println("已接收到客户端连接");
                System.out.println("服务端接收到客户端信息：" + info + ",当前客户端ip为："
                        + socket.getInetAddress().getHostAddress());
            }
            OutputStream outputStream = socket.getOutputStream();// 获取一个输出流，向服务端发送信息
            PrintWriter printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
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
