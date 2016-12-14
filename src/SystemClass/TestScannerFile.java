package SystemClass;

import java.util.*;
import java.io.*;

public class TestScannerFile {
	public static void main(String[] args) throws Exception {
		// 将一个File对象作为Scanner的构造器参数，则Scanner读取文件内容
		Scanner sc = new Scanner(new File("MyBooks.xml"));
		System.out.println("a.txt文件内容如下：");
		// 判断是否还有下一行
		while (sc.hasNextLine()) {
			// 输出文件中的一行
			System.out.println(sc.nextLine());
		}
	}
}
