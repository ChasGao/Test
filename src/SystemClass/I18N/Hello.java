package SystemClass.I18N;

import java.util.ResourceBundle;
import java.util.Locale;

public class Hello {
	public static void main(String[] args) {
		// 取得系统默认的国家/语言环境
		Locale myLocale = Locale.getDefault();
		//Locale myLocale=new Locale("en", "US");在美国Locale
		// 根据指定国家/语言环境加载资源文件
		System.out.println(myLocale.getDisplayCountry()+myLocale.getDisplayLanguage());
		ResourceBundle bundle = ResourceBundle.getBundle(
				"SystemClass/I18N/mess", myLocale);
		// 打印从资源文件中取得的消息
		System.out.println(bundle.getString("hello"));
	}
	
}
