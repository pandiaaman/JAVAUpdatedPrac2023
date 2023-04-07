package basics;

class Parent{
	private int a;
	private String b;
	
	public Parent(int a, String b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public void print() {
		System.out.println("printing from parent");
	}
	
	public void print1() {
		System.out.println("printing from parent 1");
	}
	
	public String toString() {
		return ("values of a and b -> " + this.a + " " + this.b);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}
	
	
}


class Child extends Parent{
	double c;
	
	public Child(int a, String b, double c) {
		super(a,b);
		this.c = c;
	}
	
	public void print() {
		System.out.println("printing from child");
	}	
	public void print2() {
		System.out.println("printing from child 2");
	}
}

class A{
	public void printhi() {
		for(int i=0;i<10;i++) {
			System.out.println("hi");
			
		}
	}
}

class B{
	public void printhello() {
		for(int i=0;i<10;i++) {
			System.out.println("hello");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class AA_ExampleConcepts {

	public static void main(String[] args) {
		Parent obj = new Child(1,"asd",23.2);
		obj.print();
		obj.print1();
		
		A ob1 = new A();
		B ob2 = new B();
		
//		ob1.printhi();
//		ob2.printhello();
		
		new Thread(() -> {
			ob2.printhello();
		}).start(); 
		
		new Thread(() -> {
			for(int i=0;i<10;i++) {
				System.out.println("hi");
				try {
					Thread.sleep(2000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
