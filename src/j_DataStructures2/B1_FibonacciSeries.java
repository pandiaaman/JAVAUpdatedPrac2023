package j_DataStructures2;

public class B1_FibonacciSeries {

	public static void main(String[] args) {
	
		System.out.println(fibonacci(9));
	}
	
	public static int fibonacci(int n) {
		//base case
		if(n<=1) {
			return n;
		}
		
		return fibonacci(n-1)+fibonacci(n-2);
	}
}
