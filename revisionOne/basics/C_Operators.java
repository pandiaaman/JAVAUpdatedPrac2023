package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class C_Operators {

	enum DaysInWeek{
		MON, TUE, WED, THU, FRI, SAT, SUN
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Operators in java:
		 * 
		 * 	arithmetic operators
		 * 		+ - * / %
		 * 	comparison/relational operators
		 * 		< > <= >= 
		 * 	logical
		 * 		! | &
		 * 	bit wise operators
		 * 		<< >> >>> & | ^ 
		 * 	equality operators
		 * 		!= == = 
		 * 	conditional
		 * 		&& ||
		 * 	ternary
		 * 		?:
		 */
		
		//wrapper classes
		/*
		 * 
		 * Integer
		 * Double
		 * Character
		 * Float
		 * Long
		 * Byte
		 * Boolean'
		 * Short
		 */
		
		
		DaysInWeek day = DaysInWeek.MON;
		boolean isweekend;
		
		switch(day) {
		case MON:
			isweekend = false;
			break;
		case TUE:
			isweekend = false;
			break;
		case SAT:
			isweekend=true;
			break;
		default:
			System.out.println("incorrectday");
			break;
		}
		
		boolean isWeekendSmart;
		
		switch(day) {
		case MON, TUE, WED, THU, FRI:
			isWeekendSmart = false;
			break;
		case SAT, SUN:
			isWeekendSmart = true;
			break;
		default:
			throw new IllegalArgumentException("incorrect day " + day.name());
		}
		
		//best approach for switch case
		boolean isWeekendSmartest;
		
		switch(day) {
		case MON, TUE, WED, THU, FRI -> isWeekendSmartest = false;
		case SAT, SUN -> isWeekendSmartest = true;
		default -> throw new IllegalArgumentException("incorrect day " + day.name());
		}
		
		//ternary to get the largest of the three
		int i=5,j=10,k=7;
		
		int max = i>j?(i>k?i:k):(j>k?j:k);
		System.out.println(max);
		
		
		//for loop for two things at same time
		for(;i<10 && j<17; i++) {
			System.out.println(i);
			System.out.println(j);
			j++;
		}
		
		for(;;) {
			i++;
			System.out.println(i);
			if(i>17) {
				break;
			}
		}
		
		System.out.println("here");
		
		//enhanced for loop
		Integer[] arr = new Integer[] {1,2,3,54,5,7,5,3,5,6,2,13,4,5};
		for(Integer a : arr) {
			System.out.println(a);
		}
		
		
		List<Integer> list1 = Arrays.asList(arr);
		
		String[] strarr = new String[] {"tyjtyj","rhe","wer","fdfg","asd"};
		List<String> list2 = Arrays.asList(strarr);
		
		Iterator<String> stitr = list2.iterator();
		while(stitr.hasNext()) {
			System.out.println(stitr.next());
		}
		
		
		List<String> list3 = List.of("aman","vaibhav","sumit");
		list3.forEach(System.out::println);
		
		list3.stream().forEach(System.out::println);
		
		
	}

}
