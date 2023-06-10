package DSALogics;

import java.util.HashSet;

public class G_264_UnionOfTwoArrays {

	public static int[] unionTwoArrays(int[] arr1, int[] arr2) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i : arr1) {
			set.add(i);
		}
		for(int i: arr2) {
			set.add(i);
		}
		
		//below is the code to convert the set into an array, we can also have simply printed it here
		int n = set.size();
		
		int[] res = new int[n];
		
		int j =0;
		for(int i : set) {
			res[j] = i;
			j++;
		}
		
		return res;
	}
	public static void main(String[] args) {
		int arr1[] = new int[] {7,3,9};
		int arr2[] = new int[] {6,3,9,2,9,4};
		
		int res[] = unionTwoArrays(arr1, arr2);
		
		for(int i: res) {
			System.out.print(i + " ");
		}

	}

}
