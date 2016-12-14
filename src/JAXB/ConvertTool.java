package JAXB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/*
 * JavaBean和Xml互相转换工具
 * @Date 2015-5-20 11:08:48
 */
public class ConvertTool {
	/*
	 * javabean转化为xml格式的字符串
	 */
	public static String bean2xml(Object obj) {
		StringWriter writer = new StringWriter();
		try {
			JAXBContext jaxbcontext = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = jaxbcontext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// 当jvm的运行环境编码格式是GBK时设置编码格式GBK,其他情况使用UTF-8
			if ("GBK".equalsIgnoreCase(System.getProperty("file.encoding"))) {
				marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
			} else {
				marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			}
			marshaller.marshal(obj, System.out);
			marshaller.marshal(obj, writer);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

	/*
	 * xml格式的字符串生成文件
	 * 
	 * @para xmlStr
	 * 
	 * @para path 如D:\\MyEclipseWorkspaces\\Test\\src\\JAXB\\book.xml
	 */
	public static boolean xml2xmlFile(String xmlStr, String path) {
		boolean flag = false;
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
				FileWriter writer = new FileWriter(file);
				writer.write(xmlStr);
				writer.close();
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * xml文件转化javabean
	 * 
	 * @para xmlStr 从xml文件读出的字符串
	 * 
	 * @return javaBean
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xml2object(Class<T> clazz, String path) {
		T t=null;
		try {
			File file=new File(path);
			JAXBContext jaxbcontext = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller=	jaxbcontext.createUnmarshaller();
			t=(T)unmarshaller.unmarshal(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}


	public static void main(String[] args) {
		//Book book=xmlStr2object(Book.class, xml);
		Book book= xml2object(Book.class, "D:\\MyEclipseWorkspaces\\Test\\src\\JAXB\\book.xml");
		System.out.println(book.getAuthor());
	}
}
