package Dom4j.crud;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author GAO
 * 
 */
public class OperateDOM4J {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// create();
		// read();
		create3();
		// update();
		// delete();
		//readURL();
		//create();
	}

	/**
	 * 如何创建一个document 并保存xml文件
	 * 
	 * @throws Exception
	 */
	public static void create() throws Exception {
		// 创建一个document
		Document document = DocumentHelper.createDocument();
		Namespace test=new  Namespace("test", "http://schemas.ilog.com/JRules/1.1/Translation");
		Namespace test2=new  Namespace("test2", "http://schemas.ilog.com/JRules/1.2/Translation");
		// 创建根结点
		//标签前带前缀
		Element root = document.addElement(new QName("root", test));
		root.add(test); 
		root.add(test2);
		// 为根结点添加一个book节点
		Element book1 = root.addElement("book","http://schemas.ilog.com/Rules/7.0/DecisionTable");
		//book1.addAttribute("xmlns", "http://schemas.ilog.com/Rules/7.0/DecisionTable");
		
		// 为book1添加属性type
		book1.addAttribute("type", "science");
		// 为book1添加name子节点
		Element name1 = book1.addElement("name");
		// 并设置其name为"Java"
		//name1.setText("Java");
		name1.addCDATA("Java");
		// 为book1创建一个price节点,并设其价格为100
		book1.addElement("price").setText("100");

		// 为根结点添加第二个book节点
		Element book2 = root.addElement("book").addAttribute("type", "science");
		book2.addElement("name").addText("Oracle");
		book2.addElement("price").setText("200");

		// 输出xml
		//System.out.println(document.asXML());
		//XMLWriter writer = new XMLWriter(System.out, format);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		// 指定文件
		File f = new File(
				"D:/MyEclipse2015Workspaces/Test/src/Dom4j/crud/MyBooks.xml");
		if (!f.exists()) {
			f.createNewFile();
		}
		// 输出xml
		XMLWriter writerConsole = new XMLWriter(System.out, format);
		writerConsole.write(document);
		XMLWriter writer = new XMLWriter(new FileWriter(f), format);
		writer.write(document);
		writer.close();
		
	}

	/**
	 * 测试SAREADER的read（url）方法
	 */
	public static void create2() throws Exception {
				
		SAXReader reader = new SAXReader();
		URL url = new URL("http://flash.weather.com.cn/wmaps/xml/china.xml");
		Document document = reader.read(url);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		System.out.println(document.asXML());
		// 指定文件
		File f = new File(
				"D:/MyEclipse2015Workspaces/Test/src/Dom4j/crud/weather.xml");
		if (!f.exists()) {
			f.createNewFile();
		}
		XMLWriter writer = new XMLWriter(new FileWriter(f), format);
		writer.write(document);
		writer.close();
	}

	/**
	 * 指定节点下增加元素
	 * 
	 * @throws Exception
	 */
	public static void create3() throws Exception {
		// 创建一个document
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");
		 
		Element book1 = root.addElement("book");
		book1.addAttribute("type", "science");
		Element name1 = book1.addElement("name");
		name1.addCDATA("Java");
		book1.addElement("price").setText("100");

		// 为根结点添加第二个book节点
		Element book2 = root.addElement("book").addAttribute("type", "science");
		book2.addElement("name").addText("Oracle");
		book2.addElement("price").setText("200");

		Element book3 =DocumentHelper.createElement("book") ;
		book3.addElement("name").addText("Oracle3");
		book3.addElement("price").setText("20");
		book3= book1.createCopy();
		root.add(book3);		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		// 指定文件
		File f = new File(
				"D:/MyEclipse2015Workspaces/Test/src/Dom4j/crud/MyBooks3.xml");
		if (!f.exists()) {
			f.createNewFile();
		}
		// 输出xml
		XMLWriter writerConsole = new XMLWriter(System.out, format);
		writerConsole.write(document);
		XMLWriter writer = new XMLWriter(new FileWriter(f), format);
		writer.write(document);
		writer.close();
		
	}
	
	/**
	 * 取得xml节点属性的基本方法 reader的read方法,可以从InputStream, File, Url等多种不同的源来读取。
	 * 
	 * @throws Exception
	 */
	public static void read() throws Exception {
		SAXReader reader = new SAXReader();

		// 生成一个Document
		Document document = reader.read(new File(
				"D:/MyEclipseWorkspaces/Test/src/Dom4j/crud/MyBooks.xml"));
		// 取得根结点
		Element root = document.getRootElement();
		// 取得book节点
		Element book = root.element("book");
		// 取得book节点的type属性的值
		String type = book.attributeValue("type");
		// 取得Name节点
		Element name = book.element("name");
		// 取得书名
		String bookname = name.getText();
		// 取得书的价钱
		int price = Integer.parseInt(book.element("price").getText());

		// 输出书目信息
		System.out.println("书名：" + bookname);
		System.out.println("所属类别：" + type);
		System.out.println("价格：" + price);

	}

	/**
	 * reader的read方法,可以从InputStream, File, Url等多种不同的源来读取。
	 */
	public static void readURL() throws Exception {
		SAXReader reader = new SAXReader();
		URL url = new URL("http://flash.weather.com.cn/wmaps/xml/china.xml");
		Document document = reader.read(url);
		Element root = document.getRootElement();
		System.out.println(document.asXML());;
		Iterator<Element> cities = root.elementIterator("city");
		while (cities.hasNext()) {
			Element city = cities.next();
			System.out.println("省份："+ city.attributeValue("quName").trim()+ "\t"
					+ "城市:" + city.attributeValue("cityname").trim()+"\t"+"天气:"
					+ city.attributeValue("stateDetailed").trim()+"\t"+"风力:"
					+ city.attributeValue("windState").trim());
		}
		
		
	}

	/**
	 * 利用xpath,迭代取得节点及其属性值
	 * 
	 * @throws Exception
	 */
	public static void read2() throws Exception {
		SAXReader reader = new SAXReader();
		// 生成一个Document
		Document document = reader.read(new File(
				"D:/MyEclipse2015Workspaces/Test/src/Dom4j/crud/MyBooks.xml"));
		// 提取类型为"science"的书
		// 此处需要添加支持xpath的jar包
		Element science_book = (Element) document
				.selectSingleNode("/root/book[1][@type='science']");
		System.out.println(science_book.asXML());
		/*
		 * List<Element>
		 * science_book2=document.selectNodes("/root/book[@type='science']");
		 * for(Element i:science_book2){ System.out.println(i.asXML()); }
		 */

		// 提取价格节点的列表
		System.out.println("-----------价格列表-------------");
		List<Element> price = document.selectNodes("/root/book/price");
		for (int i = 0; i < price.size(); i++) {
			Element elem_price = price.get(i);
			System.out.println(elem_price.getText());
		}

		// 循环根结点下的所有节点，若当前节点为book，则输出这本书的详细信息
		System.out.println("-------------书目详情------------");
		System.out.println("书名\t\t类别\t\t价格");
		Element root = document.getRootElement();
		Iterator<Element> iterator = root.elementIterator();
		while (iterator.hasNext()) {
			Element element = iterator.next();
			if (element.getName().equals("book")) {
				System.out.println(element.element("name").getText() + "\t\t"
						+ element.attributeValue("type") + "\t\t"
						+ element.element("price").getText());
			}
		}
		// 属性迭代
		System.out.println("/n-------属性迭代--------");
		String str1 = "<book type='science' name='Java' price='100'/>";
		Document document1 = DocumentHelper.parseText(str1);
		// 开始迭代
		Iterator<Attribute> iterator_attribute = document1.getRootElement()
				.attributeIterator();
		while (iterator_attribute.hasNext()) {
			// 提取当前属性
			Attribute attribute = iterator_attribute.next();
			System.out
					.println(attribute.getName() + ":" + attribute.getValue());
		}
	}

	/**
	 * 修改节点以及属性
	 * 
	 * @throws Exception
	 */
	public static void update() throws Exception {
		SAXReader reader = new SAXReader();
		// 生成一个Document
		Document document = reader.read(new File(
				"D:/MyEclipseWorkspaces/Test/src/Dom4j/crud/MyBooks.xml"));
		// 获取根节点
		Element root = document.getRootElement();

		Element name = root.element("book").element("name");
		name.setText("javajava");// 更新标签值
		root.element("book").attribute("type").setValue("sciencescience"); // //更新属性值
		root.element("book").attribute("type").detach();

		XMLWriter writer = new XMLWriter(new FileWriter(new File(
				"D:/MyEclipseWorkspaces/Test/src/Dom4j/crud/MyBooks.xml")));
		writer.write(document);
		writer.close();
	}

	public static void delete() throws Exception {
		SAXReader reader = new SAXReader();
		// 生成一个Document
		Document document = reader.read(new File(
				"D:/MyEclipseWorkspaces/Test/src/Dom4j/crud/MyBooks.xml"));
		Element root = document.getRootElement();
		// remove只能用删除当前节点的子节点。
		root.element("book").remove(root.element("book").attribute("type"));// 删除属性
		root.element("book").remove(root.element("book").element("name"));// 删除节点
		XMLWriter writer = new XMLWriter(new FileWriter(new File(
				"D:/MyEclipseWorkspaces/Test/src/Dom4j/crud/MyBooks.xml")));
		writer.write(document);
		writer.close();
	}
}
