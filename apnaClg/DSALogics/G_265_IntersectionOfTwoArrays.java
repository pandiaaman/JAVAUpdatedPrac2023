package DSALogics;

import java.util.HashSet;

public class G_265_IntersectionOfTwoArrays {

	public static void intersectionOfTwoArrays(int[] arr1, int[] arr2) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i : arr1) {
			set.add(i);
		}
		
		for(int i : arr2) {
			if(set.contains(i)) {
				System.out.println(i);
				set.remove(i);
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr1 = new int[] {7,3,9};
		int[] arr2 = new int[] {6,3,9,2,9,4};
		
		intersectionOfTwoArrays(arr1, arr2);

	}

}
