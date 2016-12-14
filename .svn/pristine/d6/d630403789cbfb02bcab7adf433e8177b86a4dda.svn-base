package JAXB;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class TestBook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Book book=new Book();
		book.setName("book");
		book.setAuthor("scoot");book.setPrice(100);book.setPubData(new Date());
		String[] index={"第一章","第二章","第三章"};
		book.setIndexName(index);
		// convertToXml(book);
		//ConvertTool.bean2xml(book, "D:\\MyEclipseWorkspaces\\Test\\src") ;
		String xmlStr=ConvertTool.bean2xml(book);
		ConvertTool.xml2xmlFile(xmlStr, "D:\\MyEclipseWorkspaces\\Test\\src\\JAXB\\book.xml");
	}
	public static void convertToXml(Object obj){
		try {
			 JAXBContext context = JAXBContext.newInstance(obj.getClass());  
	         Marshaller marshaller = context.createMarshaller();  
	         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	         marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8"); 
	         FileWriter file=new FileWriter("D:\\MyEclipseWorkspaces\\Test\\src\\JAXB\\book.xml");
	         marshaller.marshal(obj, file); 
	         
	         marshaller.marshal(obj, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
