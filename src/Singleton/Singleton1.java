package Singleton;

/**
 * 饿汉式. 这种方法非常简单，因为单例的实例被声明成 static 和 final
 * 变量了，在第一次加载类到内存中时就会初始化，所以创建实例本身是线程安全的。 
 * 缺点是它不是一种懒加载模式（lazy initialization），单例会在加载类后一开始就被初始化，即使客户端没有调用
 * getInstance()方法。饿汉式的创建方式在一些场景中将无法使用：譬如 Singleton 实例的创建是依赖参数或者配置文件的，在
 * getInstance() 之前必须调用某个方法设置参数给它，那样这种单例写法就无法使用了。
 * 
 * @author 30868
 *
 */
public class Singleton1 {
	// 类加载时就初始化
	private static final Singleton1 instance = new Singleton1();

	private Singleton1() {
	}

	public static Singleton1 getInstance() {
		return instance;
	}
}
