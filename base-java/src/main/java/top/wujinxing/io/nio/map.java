package top.wujinxing.io.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wujinxing
 * date 2019 2019/7/11 10:24
 * description FileChannel.map使用
 * 程序访问这个内存区域时将直接操作这个文件数据，省去了数据从内核空间向用户空间复制的损耗。
 */
public class map {
    public static void main(String[] args) {
        int BUFFER_SIZE = 1024;
        String filename = "D:\\Git\\Java-Learning\\src\\main\\java\\top\\wujinxing\\io\\nio\\test.db";
        long fileLength = new File(filename).length();
        int buffCount = 1 + (int)(fileLength/BUFFER_SIZE);
        MappedByteBuffer[] buffers = new MappedByteBuffer[buffCount]; //缓冲区
        long remaining = fileLength;
        for (int i=0; i<buffCount; i++){
            RandomAccessFile file;
            try {
                file = new RandomAccessFile(filename, "r");
                buffers[i] = file.getChannel().map(FileChannel.MapMode.READ_ONLY,
                        i*BUFFER_SIZE, (int)Math.min(remaining,BUFFER_SIZE));
            }catch (Exception e){
                e.printStackTrace();
            }
            remaining -= BUFFER_SIZE;
        }
    }
}
