package top.wujinxing.IO.Socket;

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
            Socket socket = new Socket("localhost",8888);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);//将输出流包装成打印流

            printWriter.print("服务端你好, 我是客户端1");
            printWriter.flush();
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String info = "";
            String temp = null;
            while ((temp=bufferedReader.readLine())!=null){
                info += temp;
                System.out.println("客户端姐夫服务端发送消息: " + info);
            }

            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
