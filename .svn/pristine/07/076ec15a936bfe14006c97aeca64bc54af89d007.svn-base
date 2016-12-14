package CountStr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author GAO
 * 
 */
public class CountStr {
	/*
	 * 统计英文、数字、空格数量
	 */
	@Test
	public void countSum2() {

		String str = " 盐城京都汽车销售服务有限公司";// 要统计的内容

		int abccount = 0;
		int numcount = 0;
		int spacecount = 0;
		int othercount = 0;
		int hzCount = 0;
		int hzCount2 = 0;
		String Reg = "^[\u4e00-\u9fa5]{1}$";
		Pattern patterm = Pattern.compile(Reg);
		Matcher matc = patterm.matcher(str);

		char[] b = str.toCharArray();
		for (int i = 0; i < b.length; i++) {
			if (b[i] >= 'a' && b[i] <= 'z' || b[i] >= 'A' && b[i] <= 'Z') {
				abccount++;
			} else if (b[i] >= '0' && b[i] <= '9') {
				numcount++;
			} else if (b[i] == ' ') {
				spacecount++;
			} else if (b[i] >= 19968 && b[i] <= 64041) {
				hzCount++;
			} else if (matc.find()) {
				hzCount2++;
			} else {
				othercount++;
			}
		}
		int sum = abccount + numcount + spacecount + othercount + hzCount;
		System.out.println("字符串中总数量为：" + sum);
		System.out.println("字符串中含有的英文字母数为：" + abccount);
		System.out.println("字符串中含有的数字数为：" + numcount);
		System.out.println("字符串中含有的空格数为：" + spacecount);
		System.out.println("字符串中含有的汉字数为：" + hzCount);
		System.out.println("字符串中含有的汉字数2为：" + hzCount2);

		System.out.println("字符串中含有的其他字符为：" + othercount);

	}
}
