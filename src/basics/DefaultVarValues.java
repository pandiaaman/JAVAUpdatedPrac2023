package basics;

public class DefaultVarValues implements Cloneable{
	int a;
	String str;
	double d;
	long l;
	char c;
	byte b;
	short s;
	float f;
	
	public static void main(String[] args) {
		
		DefaultVarValues obj = new DefaultVarValues();
		
		System.out.println(obj.a + " " + obj.str + " " + obj.d + " " + obj.l + " " + obj.c + " " + obj.b + " " + obj.s + " " + obj.f);
		
		
		System.out.println(100+100+"aman");
		System.out.println("aman"+100+100);
	}
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

}
