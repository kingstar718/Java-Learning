package top.wujinxing.io.Socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author wujinxing
 * @date 2019/4/25 11:44
 * @description
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);

            OutputStream outputStream = socket.getOutputStream();
            //将输出流包装成打印流
            PrintWriter printWriter = new PrintWriter(outputStream);

            printWriter.print("服务端你好, 我是客户端1");
            printWriter.flush();
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder info = new StringBuilder();
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                info.append(temp);
                System.out.println("客户端接收服务端发送消息: " + info);
            }

            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
