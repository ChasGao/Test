package Dom4j.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomTest1
{
	public static void main(String[] args) throws Exception
	{
		// step 1: 获得dom解析器工厂（工作的作用是用于创建具体的解析器）
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		// step 2:获得具体的dom解析器
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		// step3: 解析一个xml文档，获得Document对象（根结点）
		Document document = db.parse(new File("src//Dom4j//xml//candidate.xml"));
		
		NodeList list = document.getElementsByTagName("PERSON");
		
		for(int i = 0; i < list.getLength(); i++)
		{
			Element element = (Element)list.item(i);
			
			String content = element.getElementsByTagName("NAME").item(0).getFirstChild().getNodeValue();
			
			System.out.println("name:" + content);
			
			content = element.getElementsByTagName("ADDRESS").item(0).getFirstChild().getNodeValue();
			
			System.out.println("address:" + content);
			
			content = element.getElementsByTagName("TEL").item(0).getFirstChild().getNodeValue();
			
			System.out.println("tel:" + content);
			
			content = element.getElementsByTagName("FAX").item(0).getFirstChild().getNodeValue();
			
			System.out.println("fax:" + content);
			
			content = element.getElementsByTagName("EMAIL").item(0).getFirstChild().getNodeValue();
			
			System.out.println("email:" + content);
			
			System.out.println("--------------------------------------");
		}
		NodeList namelist = document.getElementsByTagName("NAME");
		
		for (int i = 0; i < namelist.getLength(); i++) {
			//Node node = (Node)namelist.item(i);
			//String content=node.getTextContent();
			Element nameElement=(Element)namelist.item(i);
			String content=nameElement.getFirstChild().getNodeValue();
			System.out.println(content);
		}
	}
}
