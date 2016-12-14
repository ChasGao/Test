package SystemClass.I18N;

import java.text.MessageFormat;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.Date;

public class HelloArg
{
	public static void main(String[] args)
	{
        Locale currentLocale = null;
        if (args.length == 2)
        {
            currentLocale = new Locale(args[0] , args[1]);
        }
        else
        {
            currentLocale = Locale.getDefault();
        }
		ResourceBundle bundle = ResourceBundle.getBundle("SystemClass/I18N/MyResource" , currentLocale);
		String msg = bundle.getString("msg");	
		System.out.println(MessageFormat.format(msg , "yeeku" , new Date()));
	}	
}
