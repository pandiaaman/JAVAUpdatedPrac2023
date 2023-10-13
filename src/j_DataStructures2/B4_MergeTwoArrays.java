package j_DataStructures2;

import java.util.Arrays;

public class B4_MergeTwoArrays {

	public static void main(String[] args) {
		int[] arr1 = new int[] {2,5,8,15,19,25,29,35,39,45,49};
		int[] arr2 = new int[] {1,4,6,12,22,38,43,44,55};
		
		int[] result = merge(arr1,arr2);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int n = arr1.length + arr2.length - 1;
		System.out.println(n);
		int[] merged = new int[n];
		int x = 0; //pointer to merged array
		int i = 0,j = 0; //pointer to arr1 and arr2 beginnings
		
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i] < arr2[j]) {
				merged[x] = arr1[i];
				i++;
			}
			else {
				merged[x] = arr2[j];
				j++;
			}
			x++;
		}
		System.out.println(x + " "+ i + " " + j);
		while(i<arr1.length - 1) {
			merged[x] = arr1[i];
			i++;
			x++;
		}
		while(j<arr2.length - 1) {
			merged[x] = arr2[j];
			j++;
			x++;
		}
		
		return merged;
	}
}
