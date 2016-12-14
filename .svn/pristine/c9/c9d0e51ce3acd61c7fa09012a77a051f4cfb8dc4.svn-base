package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

/**
 * <br>
 * <b>功能：</b>详细描述类的功能<br>
 * <b>作者：</b>开发人员<br>
 * <b>日期：</b>创建日期<br>
 * <b>版权所有：<b>策诚财富<br>
 */
public class OperateArray {

	// 定义数组
	static String[] aArray = new String[5];
	static String[] bArray = { "a", "b", "c", "d", "e" };
	static String[] cArray = new String[] { "a", "b", "c", "d", "e" };
	static int[] dArray = new int[] { 2, 1};

	/**
	 * 方法的详细描述
	 * 
	 * @param param1
	 *            参数含义
	 * @param param2
	 *            参数含义
	 * @param ... ... 参数含义
	 * @return 返回值说明
	 * @throws Exception
	 *             异常说明
	 */

	/**
	 * 数组的值和引用 打印数组的值
	 */
	public static String printArrayValues(Object[] ob) {

		System.out.println("打印数组的值：" + Arrays.toString(ob));
		return Arrays.toString(ob);
	}

	public static void main(String[] args) {
		// OperateArray.createArrayList();
		// System.out.println(checkElement());
		// System.out.println(linkArrays());
		// System.out.println(printArrayValues(reversalArray()));
		// sortArray();
	/*	for(int i=0;i<args.length;i++){
			System.out.print(args[i]);
		}
		System.out.println(printArrayReference(bArray));*/
		int[] ddArray=(int[])resizeArray(dArray, 3);
		for(int i=0;i<ddArray.length;i++){
			System.out.println(ddArray[i]);
		}
	}

	/**
	 * @param ob
	 * @return 数组的引用
	 */
	public static String printArrayReference(Object[] ob) {

		System.out.println("打印数组的引用：" + ob);
		return Arrays.toString(ob);
	}

	/**
	 * 从Array中创建ArrayList; ArrayList是动态链表，我们可以更方便地对ArrayList进行增删改
	 * 我们并不需要循环Array将每一个元素加入到ArrayList中，用以上的代码即可简单实现转换
	 */
	public static void createArrayList() {
		ArrayList<String> arrayList = new ArrayList<String>(
				Arrays.asList(bArray));
		arrayList.add("g");
		System.out.println(arrayList);
	}

	/**
	 * 检查 中是否包含某一个值
	 * 
	 * @return boolean
	 */
	public static boolean checkElement() {
		return Arrays.asList(bArray).contains("i");
	}

	/**
	 * 合并两个数组
	 */
	public static String[] linkArrays() {
		String[] dArray = new String[bArray.length + cArray.length];
		System.arraycopy(bArray, 0, dArray, 0, bArray.length);
		System.arraycopy(cArray, 0, dArray, bArray.length, cArray.length);

		System.out.println(Arrays.asList(dArray));
		return dArray;
	}

	/**
	 * 数组元素翻转
	 * 
	 * @return翻转后的数组
	 */
	public static String[] reversalArray() {
		for (int i = 0; i < bArray.length / 2; i++) {
			String temp = bArray[i];
			bArray[i] = bArray[bArray.length - 1 - i];
			bArray[bArray.length - 1 - i] = temp;
		}
		return bArray;
	}

	/**
	 * <br>
	 * 组的比较排序，可以直接利用Arrays.sort()方法
	 */
	public static void sortArray() {
		Arrays.sort(bArray);// 数组的比较排序
		printArrayValues(bArray);
		Arrays.sort(cArray, Collections.reverseOrder());// 要实现反序排列
		printArrayValues(cArray);
	}
/*
 * Java中动态修改数组(Array)的大小，Java数组大小需要预先指定，下面的代码演示了如何在运行时修改数组的大小
 * 
 */
	public static Object resizeArray(Object oldArray,int newSize){
		   int oldSize = java.lang.reflect.Array.getLength(oldArray);
		   Class elementType = oldArray.getClass().getComponentType();
		   Object newArray = java.lang.reflect.Array.newInstance(
		         elementType,newSize);
		   int preserveLength = Math.min(oldSize,newSize);
		   if (preserveLength > 0)
		      System.arraycopy (oldArray,0,newArray,0,preserveLength);
		   return newArray;

	}
	
}
