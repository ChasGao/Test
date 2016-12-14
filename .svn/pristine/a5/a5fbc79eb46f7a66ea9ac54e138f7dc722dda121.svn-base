package lang;

import java.lang.Exception;

public class ExceptionTest {
	/**发生异常时，代码执行情况。<br/>
	 *打印结果如下：<br/>
	 * bf 
	 * java.lang.ArithmeticException: 除以零 
	 * finally 
	 * out 
	 * af
	 */
	public static void main(String[] args) {

		System.out.println("bf");
		excetpionOccur();
		System.out.println("af");// 这个地方还会执行

	}

	public static void excetpionOccur() {
		try {
			int i = 1 / 0;
			System.out.println("....");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("finally");
		}

		System.out.println("out");
	}

}
