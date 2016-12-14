package DuoTai;

public class SubClass  extends Base{

	/**
	 * @param args
	 */
	//重新定义一个book实例属性覆盖父类的book实例属性
		
	public String book = "轻量级J2EE企业应用实战";
	public int count=4; 
		public void test()
		{
			System.out.println("子类的覆盖父类的方法");
			count++;
		}
		public void sub()
		{
			System.out.println("子类的普通方法");
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*//下面编译时类型和运行时类型完全一样，因此不存在多态
				BaseClass bc = new BaseClass();
				//输出 6
				System.out.println(bc.book);
				//下面两次调用将执行BaseClass的方法
				bc.base();
				bc.test();

				//下面编译时类型和运行时类型完全一样，因此不存在多态
				SubClass sc = new SubClass();
				//输出"轻量级J2EE企业应用实战"
				System.out.println(sc.book);
				//下面调用将执行从父类继承到的base方法
				sc.base();
				//下面调用将执行从当前类的test方法
				sc.test();
				//下面调用将执行从当前类的sub方法
				sc.sub();
*/
		
		
				//下面编译时类型和运行时类型不一样，多态发生
				Base  ploymophicBc = new SubClass();
				//1.向上类型转换，ploymophicBc对象中有父类的count，被屏蔽的子类count，子类test方法中操作的是子类count。
				//2.在父类、子类中添加同样的属性，那么通过父类引用所访问的属性是父类的属性；如果要访问子类的属性，则要把引用类型强制转换为子类类型。取决于引用类型 
				
				System.out.println(ploymophicBc.book+"book");//输出父类的book
				System.out.println(ploymophicBc.count+"count");//输出父类的count0
				
				//下面调用将执行从父类继承到的base方法
				//SubClass sc=(SubClass)ploymophicBc;
				//System.out.println(sc.book);

				//ploymophicBc.base();
				//test方法被重写， 下面调用将执行子类的test方法。
				ploymophicBc.test();
				System.out.println(ploymophicBc.book+"book");
				System.out.println(((SubClass)ploymophicBc).count+"count");
				//因为ploymophicBc的编译类型是BaseClass，BaseClass类没有提供sub方法
				//所以下面代码编译时会出现错误。
				//ploymophicBc.sub();

}

}