package top.wujinxing.ch_2_basicjava.io;

import java.io.*;

/**
 * @author wujinxing
 * @date 2019/4/25 09:06
 * @description
 */
public class FileDemo3 {
    public static void main(String[] args) throws IOException {
        File dir = new File("F:\\AWorkSpace\\data\\DataCsDegree3\\");
        //所有文件
        //listAllFiles(dir);

        //复制文件
        String src = "F:\\AWorkSpace\\data\\test.txt";
        String dist = "F:\\AWorkSpace\\data\\testcopy.txt";
        copyFile(src, dist);

    }
    //递归的列出一个目录下的所有文件
    public static void listAllFiles(File dir){
        if (dir==null || !dir.exists()){
            return;
        }
        if (dir.isFile()){
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()){
            listAllFiles(file);
        }
    }


    public static void copyFile(String src, String dist) throws IOException{
        FileInputStream in = new FileInputStream(src); //文件写入流
        BufferedInputStream bfin = new BufferedInputStream(in);
        FileOutputStream out = new FileOutputStream(dist); //文件写出流
        BufferedOutputStream bfout = new BufferedOutputStream(out);
        byte[] buffer = new byte[20*1024];
        int cnt;

        // read() 最多读取 buffer.length 个字节
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读到 eof，即文件尾
        /*while ((cnt=in.read(buffer, 0, buffer.length))!=-1){
            out.write(buffer, 0, cnt);
        }*/
        while ((cnt=bfin.read(buffer, 0, buffer.length))!=-1){
            bfout.write(buffer, 0, cnt);
        }
        //in.close();
        //out.close();
        bfin.close();
        bfout.close();
    }

}
