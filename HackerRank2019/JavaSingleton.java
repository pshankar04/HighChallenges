package HackerRank;

public class JavaSingleton {
	public  String str;
	private static final JavaSingleton INSTANCE = new JavaSingleton();
	private JavaSingleton() {}

	public static JavaSingleton getSingleInstance(String sample) {
		INSTANCE.str = sample;
		return INSTANCE;
	}
}
