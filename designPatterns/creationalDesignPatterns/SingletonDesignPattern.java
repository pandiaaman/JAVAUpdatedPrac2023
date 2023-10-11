package creationalDesignPatterns;

class Logger{ //singleton
	
	static int counter;
	
	private static Logger logger;
	
	private Logger() {
		counter++;
		System.out.println("logger instance : " + counter);	
	}
	
	public static Logger getInstance() {
		if(logger == null) {
			synchronized(Logger.class) {
				logger = new Logger();
			}
		}
		return logger;
	}
	
	public void log(String msg) {
		System.out.println(msg);
	}
}

class A{
	public A() {
		
	}
	public void printmsg(String msg) {
		Logger logger = Logger.getInstance();
		logger.log("logging " + msg);
	}
}

class B{
	public B() {
		
	}
	public void printmsg(String msg) {
		Logger logger = Logger.getInstance();
		logger.log("logging " + msg);
	}
}

public class SingletonDesignPattern {

	public static void main(String... args) {
		
		
		int a = 10;
		int b = 15;
		int c = a + b;
		A alog = new A();
		alog.printmsg("creating " + c);
		
		int x = 14;
		int y = 6;
		int z = x+y;
		B blog = new B();
		blog.printmsg("creating " + z);
	}
}
