package dataStructures;
import java.util.*;
public class Trial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
//		System.out.println(sc.nextLine());
//		System.out.println(sc.nextInt());
		String str = sc.nextLine();
		
//		int[] arr = new int[2];
		String[] strarr = str.split("\\s");
//		System.out.println(strarr[0]);
//		System.out.println(strarr[1]);
		
		System.out.println(Integer.parseInt(strarr[0]) + Integer.parseInt(strarr[1]));
		
	}

}
