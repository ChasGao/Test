package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HelloLog4j {
	private static Logger logger=Logger.getLogger(HelloLog4j.class);
	
	public static void main(String[] args ){
		//到制定路径读取配置文件
		PropertyConfigurator.configure("src/log4j/log4j.properties");
		
		logger.info("info级别的日志信息。。。");
	}
	
	
}
