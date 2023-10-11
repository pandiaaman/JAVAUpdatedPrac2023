package B_oops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IsArrayEqual {
	public static void main(String[] args) {
		System.out.println("heelo");
		
		int[] arr1 = new int[] {3,7,15,9,3,3,7,8,9};
		int[] arr2 = new int[] {7,3,9,15,3,3,9,8,7};

		isEqual(arr1, arr2);
		
//		Arrays.sort(arr1);
//		Arrays.sort(arr2);
//		
//		System.out.println(Arrays.equals(arr1, arr2));
//		
//		
//		List<Integer> list1 = new ArrayList<Integer>();
//		for(int i : arr1) {
//			list1.add(i);
//		}
		
		
	}

	public static void isEqual(int[] arr1, int[] arr2) {
		if(arr1.length != arr2.length) {
			System.out.println("not equal");
			return;
		}
		
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for(int i : arr1) {
			if(map1.containsKey(i)) {
				map1.put(i, map1.get(i) + 1);
			}else {
				map1.put(i, 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> i : map1.entrySet() ){
			System.out.println(i.getKey() + " " + i.getValue());
		}
		
		for(int i : arr2) {
			if(map1.containsKey(i)) {
				map1.put(i, map1.get(i) - 1);
			}
			else {
				System.out.println( i + " is not present in other array");
				return;
			}
		}
		
		System.out.println("after removing");
		int sumval = 0;
		for(Map.Entry<Integer, Integer> i : map1.entrySet() ){
			System.out.println(i.getKey() + " " + i.getValue());
			sumval += i.getValue();
		}
		
		if(sumval != 0) {
			System.out.println("arrays are different");
			return;
		}
		
		else {
			System.out.println("arrays are same");
		}
	}
}
