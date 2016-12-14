package Singleton;

/**
 * 如何正确地写出单例模式?
 *  几种单例写法的整理，并分析其优缺点
 * <a>https://github.com/biezhi/java-bible/blob/master
 * /designpatterns/singleton.md</a>
 * 
 * @author 30868
 *
 */
public class Singleton {
	
	private static Singleton instance;

	private Singleton() {
	}

	/**
	 * 懒汉式，线程不安全。
	 * 这段代码简单明了，而且使用了懒加载模式，但是却存在致命的问题。当有多个线程并行调用 getInstance() 的时候，就会创建多个实例。
	 * 也就是说在多线程下不能正常工作。
	 */
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	/**
	 * getInstance2()虽然做到了线程安全，并且解决了多实例的问题，但是它并不高效。因为在任何时候只能有一个线程调用
	 * getInstance() 方法。但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。
	 * 
	 * @return
	 */
	public static synchronized Singleton getInstance2() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}
