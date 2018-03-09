package webservice;

import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.experimental.theories.Theories;

public class WebServiceIClient {

	public  String call(String str){
		String result = "";
        try {  
            String endpoint = "http://localhost:8080/WS_Server/Webservice?wsdl";  
            //直接引用远程的wsdl文件  
           //以下都是套路   
            Service service = new Service();  
            Call call = (Call) service.createCall();  
            call.setTargetEndpointAddress(endpoint);  
            call.setOperationName(new QName("http://webservice/", "sayHello"));////你需要远程调用的方法
            //方法参数，如果没有参数请无视
            call.addParameter( "arg0", org.apache.axis.encoding.XMLType.XSD_STRING,  
                          javax.xml.rpc.ParameterMode.IN);//接口的参数  
            call.setEncodingStyle("UTF-8");
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型    
            String temp = "测试人员";  
          //方法参数，如果没有参数请无视
             result = (String)call.invoke(new Object[]{str});  
            //给方法传递参数，并且调用方法  
//            System.out.println("result is "+result);  
     }  
     catch (Exception e) {  
            System.err.println(e.toString());  
     } 
		
		return result;
	}

	public  String callSave(String name, String pwd){
		String result = "";
        try {  
            String endpoint = "http://localhost:8080/WS_Server/Webservice?wsdl";  
            //直接引用远程的wsdl文件  
           //以下都是套路   
            Service service = new Service();  
            Call call = (Call) service.createCall();  
            call.setTargetEndpointAddress(endpoint);  
            call.setOperationName(new QName("http://webservice/", "save"));////你需要远程调用的方法
            //方法参数，如果没有参数请无视
            call.addParameter( "arg0", org.apache.axis.encoding.XMLType.XSD_STRING,  
                          javax.xml.rpc.ParameterMode.IN);//接口的参数  
            call.addParameter( "arg1", org.apache.axis.encoding.XMLType.XSD_STRING,  
                    javax.xml.rpc.ParameterMode.IN);//接口的参数  
            call.setEncodingStyle("UTF-8");
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型    
            String temp = "测试人员";  
          //方法参数，如果没有参数请无视
             result = (String)call.invoke(new Object[]{name, pwd});  
            //给方法传递参数，并且调用方法  
//            System.out.println("result is "+result);  
     }  
     catch (Exception e) {  
            System.err.println(e.toString());  
     } 
		
		return result;
	}
	
	static  volatile int j=0;
	static WebServiceIClient t = new WebServiceIClient();
	public static void main(String[] args) {
		for( int i=10 ;i<20; i++){
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					++j;
					System.out.println(t.callSave("name"+j, "pwd"+j));
					}
			});
			thread.start();
		}
		
	}

}
