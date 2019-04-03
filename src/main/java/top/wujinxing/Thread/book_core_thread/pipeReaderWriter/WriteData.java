package top.wujinxing.Thread.book_core_thread.pipeReaderWriter;

import java.io.IOException;
import java.io.PipedWriter;

public class WriteData {

	public void writeMethod(PipedWriter out) {
		System.out.println("writeMethod方法启动。。。");
		try {
			System.out.print("写入数据write:");
			for (int i = 0; i < 300; i++) {
				String outData = "" + (i + 1);
				out.write(outData);
				System.out.print(outData);
			}
			System.out.println();
			System.out.println("数据写入结束");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
