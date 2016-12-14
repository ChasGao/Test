package Equal;

public class Sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = new String("str");
        String str2 = new String("str");
        //==：全等
        System.out.println("==比较 ："+ (str1 == str2));
        System.out.println("equal比较："+ str1.equals(str2));
        String str3 = "str1";
        String str4 = "str1";
        System.out.println("==比较 ："+ (str3 == str4));
        System.out.println("equal比较："+ str3.equals(str4));
       
	}

}
