package lang;

public class StringTest {

	public static void main(String[] args) {
		//stringIndexTest();
		System.out.println(strReverse("a2bcd1"));
	}

	public static void stringIndexTest(){
		String str="IndexTest";
		System.out.println(str.indexOf("I"));
		System.out.println(str.indexOf("t"));
		System.out.println(str.length());
		
	}
	
	public static String strReverse(String string){
		StringBuffer stringBuffer=new StringBuffer(string);
		return stringBuffer.reverse().toString();
		
	}
	
}
