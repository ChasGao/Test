package webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class WebServiceImpl implements WebServiceI {

	String name1;
	/**
	 * 跑10个多线程，返回结果如下；
		hello aa3 ??? aa2
		hello aa8 ??? aa2
		hello aa1 ??? aa2
		hello aa4 ??? aa2
		hello aa9 ??? aa2
		hello aa10 ??? aa2
		hello aa8 ??? aa2
		hello aa6 ??? aa2
		hello aa5 ??? aa2
		hello aa2 ??? aa2
	 */
	@Override
	public String sayHello(String name) {
		name1 = name;
		System.out.println(name + " WebService sayHello "+name1);
		return "hello "+ name +" ??? "+name1;
	}
	
	/**
	 * 
	 * 跑10个多线程，返回结果如下；
sava sucess！ name7:pwd7
sava sucess！ 1 name4:pwd4 1
sava sucess！ 1 name5:pwd5 1
sava sucess！ 1 name10:pwd10 1
sava sucess！ 1 name9:pwd9 1
sava sucess！ 1 name3:pwd3 1
sava sucess！ 1 name7:pwd7 1
sava sucess！ 1 name2:pwd2 1
sava sucess！ 1 name8:pwd8 1
sava sucess！ 1 name6:pwd6 1
sava sucess！ 1 name2:pwd2 1
save方法里使用局部变量，在高并发下，表现正常。上面sayHello方法里引用了成员变量，返回结果不可预期。
	 *对比说明，使用jdk编写的web接口，实现类中使用成员变量事不真确的，高并发调用接口可能返回不可预期的结果。
	 *
	 */
	@Override
	public String save(String name, String pwd) {
		int i = 0;
//		name=name+i;
//		pwd=pwd + i;
		System.out.println("WebService save "+name+"， "+pwd);
		++i;
		return "sava sucess！ "+i +" "+name+ ":"+ pwd+" "+i;
	}

	public WebServiceImpl() {
		super();
		System.out.println("----------------------------");
}

	
}
