package revisionTwo;

public class B_1_TowerOfHanoi {

	//time complexity : there are two possibilities for each disk : so 2 *2 *2 *2... : 2^n
	public static void main(String[] args) {
		int n=4;
		int no = hanoi(n,"source","helper","desitnation");
		System.out.println(no);
	}
	static int steps = 0;
	public static int hanoi(int n, String source, String helper, String dest) {
		//base case
		if(n<=0) {
			return 1;
		}
		
		hanoi(n-1,source,dest,helper);
		System.out.println("moving disk " + n + " from " + source + " to  " + dest);
		steps++;
		hanoi(n-1,helper,source,dest);
		return steps;
	}
}
