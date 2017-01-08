package lang;

import java.util.HashMap;
import java.util.Map;

/**
 * 常见的字符串处理
 * 
 * @author 30868
 *
 */
public class StringUtil {
	public static void main(String[] args) {
		System.out.println(strReverse1("a2bcd1"));
		System.out.println(charCount("a2bcd1",'0'));
	}
/**
 * 字符串反转
 * @param string
 * @return 字符反转后的字符串
 */
	public static String strReverse1(String string) {
		
		return new StringBuffer(string).reverse().toString();

	}
	/**
	 * 其他方法
	 * @param string
	 * @return 字符反转后的字符串
	 */
	public static String strReverse2(String string) {
		int length=string.length();
		//声明一个相同容量的StringBuffer
		StringBuffer stringBuffer=new StringBuffer(length);
		for(int i=0;i<length;i++){
			System.out.println(length-1-i);
			stringBuffer.append(string.charAt(length-1-i));
		}
		return stringBuffer.toString();
	}
	
	/**
	 * 某个字符出现的次数
	 * @param string
	 * @param c
	 * @return
	 */
	public static int charCount(String string,char c){
		int count=0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i)==c) {
				count++;
			}
		}
		return count;
	}
	/**
	 * 字符串中出现最多的字符
	 * @param string
	 * @return
	 */
	public static char maxFrenquency(String string){
		//string空值检查
		Map<Character, Integer> charMap=new HashMap<Character, Integer>();
		
		
		return ' ';
	}
}
