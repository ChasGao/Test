package IO;

import java.io.*;

public class KeyinTest {

	// 从键盘输入显示到控制台
	public static void keyin(String[] args) {
		BufferedReader br = null;
		try {
			// 将Sytem.in对象转换成Reader对象
			InputStreamReader reader = new InputStreamReader(System.in);
			// 将普通Reader包装成BufferedReader
			br = new BufferedReader(reader);
			String buffer = null;
			// 采用循环方式来一行一行的读取
			while ((buffer = br.readLine()) != null) {
				// 如果读取的字符串为"exit"，程序退出
				if (buffer.equals("exit")) {
					System.exit(1);
				}
				// 打印读取的内容
				System.out.println("输入内容为:" + buffer);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		// 关闭输入流
		finally {
			try {
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	// 将内容追加到文件尾部
	public static void appendtoFile(String fileName, String content) {
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer = new FileWriter(fileName, true) {
			};
			writer.write(content);
			writer.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		appendtoFile("D:\\MyEclipseWorkspaces\\Test\\src\\IO\\newFile.txt",
				"adafdfasd");
	}
}
