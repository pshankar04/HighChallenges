package HackerRank;

public class SingletonDemo {

	public static void main(String[] args) {
		JavaSingleton single = JavaSingleton.getSingleInstance("hello world");
		System.out.println("Hello I am a singleton! Let me say "+single.str+" to you");

	}

}
