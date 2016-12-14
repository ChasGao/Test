package JAXB;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD) 
@XmlRootElement
public class Book {
	@XmlElement
	private String name;
	@XmlElement
	private String author;
	@XmlElement
	private double price;
	
	@XmlElement(name = "indexname")
	@XmlElementWrapper(name = "allindexname")
	private String[] indexName;
	@XmlElement
	@XmlJavaTypeAdapter(value = DateAdapter.class)
	private Date pubData;

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		return str.append("name:" + this.getName())
				.append("author:" + this.getAuthor())
				.append("pubdate:" + this.getPubData())
				.append("price:" + this.getPrice())
				.append("indexname:" + this.getIndexName()).toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Date getPubData() {
		return pubData;
	}

	public void setPubData(Date pubData) {
		this.pubData = pubData;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String[] getIndexName() {
		return indexName;
	}

	public void setIndexName(String[] indexName) {
		this.indexName = indexName;
	}

}
