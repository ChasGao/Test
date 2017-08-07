package SystemClass;

import java.util.*;
import java.io.*;
/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class TestSystem
{
	public static void main(String[] args) throws Exception
	{
		//获取系统所有的环境变量
		Map<String,String> env = System.getenv();
		for (String name : env.keySet())
		{
			System.out.println(name + " ------> " + env.get(name));
		}
		//获取指定环境变量的值
		System.out.println(System.getenv("JAVA_HOME"));
		//获取所有的系统属性
		Properties props = System.getProperties();
		//将所有系统属性保存到props.txt文件中
		props.store(new FileOutputStream("props.txt") , "System Properties");
		//输出特定的系统属性
		System.out.println(System.getProperty("os.name"));
		timeTest();
	}
	/**
	 * nanoTime()返回数字单位是纳秒，
	 * currentTimeMillis()返回值单位是毫秒，
	 * 两单位相差6个数量级
	 */
	private static void timeTest() {
		long startTime=System.nanoTime();
		System.out.println("dsdsds");
		long endTime=System.nanoTime();
		long estimatedTime = endTime - startTime;
		System.err.println(startTime);
		System.err.println(endTime);
		System.err.println(estimatedTime);
	}
	
}
