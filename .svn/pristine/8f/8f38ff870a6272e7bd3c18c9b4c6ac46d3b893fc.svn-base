package Dom4j;

import java.io.File;
import java.io.FileWriter;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/**
 * @author GAO
 * @目的 Dom4j常用操作
 */
public class HelloDom4j {

	// 从文件读取XML，输入文件名，返回XML文档
	public static Document read(String fileName) throws MalformedURLException,
			DocumentException {
		SAXReader reader = new SAXReader();
		// Document document = reader.read(new File( fileName); 便于节省后面方法中的行数
		Document document = reader.read(new File(
				"D:/MyEclipseWorkspaces/Test/src/Dom4j/Test.xml"));
		return document;
	}

	// 从文件读取Test.xml，返回XML文档
	public static Document read2() throws MalformedURLException,
			DocumentException {
		SAXReader reader = new SAXReader();
		// 便于节省后面方法中的行数
		Document document = reader.read(new File(
				"D:/MyEclipseWorkspaces/Test/src/Dom4j/Test.xml"));
		return document;
	}

	// 取得Root节点
	public static Element getRootElement(Document doc) {
		return doc.getRootElement();
	}

	// 获取Root节点下一个子节点的值
	public static String getElementValue(String name) throws Exception {
		Document doc = read2();
		String value = getRootElement(doc).element(name).getText();

		return value;
	}

	// 遍历Root节点下一级的所有节点
	public static void geAlltElementValue() throws Exception {
		Document doc = read2();
		Iterator i = getRootElement(doc).elementIterator();
		while (i.hasNext()) {
			Element e = (Element) i.next();
			List es = (List) e.elements();
			if (es.size() == 0) {
				System.out.println(e.getName() + ":" + e.getText());
			} else {
				for (Iterator it = es.iterator(); it.hasNext();) {
					Element e2 = (Element) it.next();
					List e2s = (List) e2.elements();
					if (e2s.size() == 0) {
						System.out.println(e2.getName() + ":" + e2.getText());
					} else {
						for (Iterator it2 = e2s.iterator(); it.hasNext();) {
							Element e3 = (Element) it.next();
							System.out.println(e3.getName() + ":"
									+ e3.getText());
						}

					}

				}
			}

		}

	}	

	@Test
	public void test2() throws Exception {

		System.out
				.println(read("D:/MyEclipseWorkspaces/Test/src/Dom4j/Test.xml"));
		System.out.println(getElementValue("proposalNo"));
		geAlltElementValue();
	}
	//把xml格式的字符串保存到xml文件
	@Test
	public void test3() throws Exception{
		String str="<root><book type='science'><Name>Java</Name><price>100</price></book><book type='science'><Name>Oracle</Name><price>200</price></book></root>";
		Document doc=DocumentHelper.parseText(str);
		XMLWriter writer=new XMLWriter(new FileWriter("D:/MyEclipseWorkspaces/Test/src/Dom4j/Test2.xml"));
		writer.write(doc);
		writer.close();
	}

	public static void mian(String[] args) throws Exception {

	}

}
