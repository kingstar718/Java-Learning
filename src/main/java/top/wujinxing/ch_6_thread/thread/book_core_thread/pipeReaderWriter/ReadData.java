package top.wujinxing.ch_6_thread.thread.book_core_thread.pipeReaderWriter;

import java.io.IOException;
import java.io.PipedReader;

public class ReadData {
	public void readMethod(PipedReader input) {
		System.out.println("readMethod方法启动，开始读入数据。。。");
		try {
			System.out.println("read:");
			char[] byteArray = new char[20];
			int readLength = input.read(byteArray);
			while (readLength != -1) {
				String newData = new String(byteArray, 0, readLength);
				System.out.print(newData);
				readLength = input.read(byteArray);
			}
			System.out.println();
			System.out.println("数据读入完毕");
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
