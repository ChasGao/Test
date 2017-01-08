package math;

/**
 * RMB数字转换成在发票中的写法。
 * 实现 0 到 9999 9999 9999.994 以内的人民币大写转换，精确到分
 */
import java.util.Scanner;

public class RenMinBi {
	public static boolean zero;
	public static String[] strHan = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒",
			"捌", "玖" };
	public static String[] moneyCount = { "", "拾", "佰", "仟" };

	RenMinBi() {
		zero = false;
	}

	private static String[] divide(double digitalRmbValue) {
		// 处理整数
		long intPart = (long) (digitalRmbValue);
		// 处理小数，把小数转换成整数形式处理，并进行四舍五入，此时小数四舍五入之后为100的应该另外加一层处理
		long decimalPart = Math.round((double) Math
				.round((digitalRmbValue - intPart) * 10000) / 100);
		// System.out.println("整数部分为：" + intPart + "小数部分为：" + (digitalRmbValue -
		// intPart));
		if (decimalPart == 100) {
			intPart += 1;
		}
		// System.out.println("四舍五入之后整数部分为：" + intPart + "小数部分为：" +
		// decimalPart);

		String strIntPart = "";
		if (intPart == 0)
			strIntPart = "0";
		else {
			strIntPart = "" + intPart;
		}

		String strDecimalPart = "";
		if (decimalPart < 10 && decimalPart >= 0)
			strDecimalPart = "0" + decimalPart;
		else {
			strDecimalPart = "" + decimalPart;
		}
		// 处理输入为0的时候
		if (intPart == 0 && decimalPart == 0) {
			zero = true;
		}
		// System.out.println("准换为String后，整数部分为：" + strIntPart + "小数部分为：" +
		// strDecimalPart);
		return new String[] { strIntPart, strDecimalPart };
	}

	// 用来转换小数部分
	public static String transDecimal(String str) {
		if (str.equals("100") || str.equals("00")) {
			return "零角零分";
		} else {
			String strResult;
			char[] strRmb = new char[20];
			strRmb = str.toCharArray();
			if (strRmb[0] == '0' && strRmb[1] == '0') {
				strResult = "";
			} else {
				int dm = strRmb[0] - '0';
				int dn = strRmb[1] - '0';
				strResult = strHan[dm] + "角" + strHan[dn] + "分";
			}
			return strResult;
		}
	}

	// 用来转换整数部分
	public static String transInt(String str) {
		char[] firstFourBitRmb = new char[20];
		firstFourBitRmb = str.toCharArray();
		int len = firstFourBitRmb.length;
		String strResult = "";
		for (int i = 0; i < len; i++) {
			/**
			 * 这里开启之后会显示成通俗易懂的格式，例如1001，会转化为：壹仟零壹元，而不是：壹仟零佰零拾壹元，
			 * 但我希望得到的是后面这种，因为发票所需显示的就是后面这种
			 **/

			// if (firstFourBitRmb[i] == '0' && i < len) {
			// boolean zeroFlag = false;
			// while (i < len && firstFourBitRmb[i] == '0') {
			// zeroFlag = true;
			// i++;
			// }
			// if (i != len && zeroFlag == true)
			// strResult += "零";
			// i--;
			// } else {
			// int m = firstFourBitRmb[i] - '0';
			// strResult += strHan[m] + moneyCount[len - i - 1];
			// }
			int m = firstFourBitRmb[i] - '0';
			strResult += strHan[m] + moneyCount[len - i - 1];
		}
		return strResult;
	}

	public static String transCom(double digitalRMB) {
		StringBuffer resultString = new StringBuffer();
		String[] strTempRMB = divide(digitalRMB);
		// 小数部分结果
		String resultDecimal = transDecimal(strTempRMB[1]);
		// 整数部分结果
		StringBuffer resultInt = new StringBuffer();
		int len = strTempRMB[0].length();
		if (len > 12)
			return "数据过大，无法进行转换，请重新输入！";
		else {
			if (len >= 9) {
				String strBit1 = strTempRMB[0].substring(0, len - 8);
				String strBit2 = strTempRMB[0].substring(len - 8, len - 4);
				String strBit3 = strTempRMB[0].substring(len - 4, len);
				String strResult1 = transInt(strBit1) + "亿";
				String strResult2 = transInt(strBit2) + "万";
				String strResult3 = transInt(strBit3) + "元";
				resultInt.append(strResult1).append(strResult2)
						.append(strResult3);
			} else if (len >= 5) {
				String strBit1 = strTempRMB[0].substring(0, len - 4);
				String strBit2 = strTempRMB[0].substring(len - 4, len);
				String strResult1 = transInt(strBit1) + "万";
				String strResult2 = transInt(strBit2) + "元";
				resultInt.append(strResult1).append(strResult2);
			} else if (len >= 1) {
				if (zero == true) {
					resultInt.append("零元");
				} else
					resultInt.append(transInt(strTempRMB[0])).append("元");
			}
		}
		resultString.append(resultInt).append(resultDecimal);

		return resultString.toString();
	}


	public static void main(String[] args) {
		System.out.println(transCom(1000000000));
		
	}

}
