package JAXB;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
	private String pattern = "yyyy-MM-dd HH:mm:ss";
	SimpleDateFormat fmt = new SimpleDateFormat(pattern);

	@Override
	public Date unmarshal(String v) throws Exception {
		return fmt.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return fmt.format(v);
	}

}
