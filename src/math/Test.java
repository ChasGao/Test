package math;

public class Test {
public static int  num =1200021;

public static String test(int num) {
	String numString=String.valueOf(num);
	char[] chars=numString.toCharArray();
	for (int i = 0; i < chars.length; i++) {
		char c = chars[i];
		System.out.println(c);
	}
	return "";
}

public static void main(String []args){
	test(num);
}
}
