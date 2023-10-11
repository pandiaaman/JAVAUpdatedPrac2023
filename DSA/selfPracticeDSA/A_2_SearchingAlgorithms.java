package selfPracticeDSA;

import java.util.Arrays;

public class A_2_SearchingAlgorithms {

	public static void main(String[] args) {
		System.out.println("searching algos");
		
		int[] arr = new int[] {22,5,66,-32,555,-21,4,775,8,344};
		
		System.out.println(linearSearch(arr, -21));
		
		int[] arr1 = new int[] {1,2,3,4,5,6,7};
		Arrays.sort(arr1);
		System.out.println(binarySearch(arr1,0,arr1.length-1,7));
		
		//System.out.println(Integer.parseInt("44") + 45);
	}
	
	public static int linearSearch(int[] arr, int target) {
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == target) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static int binarySearch(int[] arr, int low, int high, int target) {
		int mid = low + (high - low)/2;
		//base case
		if(low>high) {
			return -1;
		}
		
		if(target > arr[mid]) {
			low = mid+1;
		}else if(target < arr[mid]){
			high = mid-1;
		}else {
			return mid;
		}
		System.out.println("mid" + mid + " arr[mid] : " + arr[mid] + " target : " + target);
		return binarySearch(arr, low, high, target);
	}
}
