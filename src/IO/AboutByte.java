package IO;

/**
 * 作者：Alex Wang 链接：https://zhuanlan.zhihu.com/p/24373777 来源：知乎
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class AboutByte {
	public static void main(String[] args) {
		byteGetValue();
	}

	/**
	 * 一个字节包含一个8位的二进制数字，在Java中使用byte来表示。最大值为127，最小值为-128。
	 * 下面的代码列出了所有byte的值
	 */
	public static void listAllByteValue() {
		for (int i = -128; i < 128; i++) {
			byte b = (byte) i;
			System.out
					.println("byte:" + b + ",Binary:" + byteToBinaryString(b));
		}
	}

	public static String byteToBinaryString(byte b) {
		String s = Integer.toBinaryString(b);
		if (b < 0) {
			s = s.substring(24);
		} else {
			if (s.length() < 8) {
				int len = s.length();
				for (int i = 0; i < 8 - len; i++) {
					s = "0" + s;
				}
			}
		}
		return s;
	}
	
	
	
	/**
	 * 字节（byte）的赋值
	 */

	public static void byteGetValue(){
	    //二进制以0b开头
	    //byte b1 = 00101010;
	   // System.out.println("b1:"+b1+",Binary:"+byteToBinaryString(b1));
	    //八进制以0开头
	    byte b2 = 052;
	    System.out.println("b2:"+b2+",Binary:"+byteToBinaryString(b2));
	    //十进制
	    byte b3 = 42;
	    System.out.println("b3:"+b3+",Binary:"+byteToBinaryString(b3));
	    //十六进制
	    byte b4 = 0x2a;
	    System.out.println("b4:"+b4+",Binary:"+byteToBinaryString(b4));

	    //-42的赋值
	    //二进制，由于11010110以原码来理解已经超过了127，因此必须使用byte进行强制类型转换
	    //byte b5 = (byte) 0b11010110;
	    //System.out.println("b5:"+b5+",Binary:"+byteToBinaryString(b5));
	    //八进制以0开头
	    byte b6 = -052;
	    System.out.println("b6:"+b6+",Binary:"+byteToBinaryString(b6));
	    //十进制
	    byte b7 = -42;
	    System.out.println("b7:"+b7+",Binary:"+byteToBinaryString(b7));
	    //十六进制，由于0xd6以原码来理解已经超过了127，因此必须使用byte进行强制类型转换
	    byte b8 = (byte) 0xd6;
	    System.out.println("b8:"+b8+",Binary:"+byteToBinaryString(b8));

	    //将两个int转为byte的示例，示例告诉我们int转byte，就是简单的截取最后8位
	    //int i1 = 0b001011010110;
	    //int i2 = 0b110011010110;
	    //System.out.println("i1 = "+i1+", i2 = "+i2);
	   // byte b9 = (byte) i1;
	   // byte b10 = (byte) i2;
	   // System.out.println("b9 = "+b9+", b10 = "+b10);
	}
}
