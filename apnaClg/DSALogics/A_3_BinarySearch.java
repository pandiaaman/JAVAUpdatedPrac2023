package DSALogics;

import java.util.Arrays;

public class A_3_BinarySearch {

	public static void main(String[] args) {
		int arr[] = new int[] {2,5,1,45,78,134,74,88,35,74354,63,23,234,7,4,87,22};
		Arrays.sort(arr);
		for(int a: arr) {
//			System.out.print(a + " ");
		}
//		System.out.println(arr.length);
		int key =88;
		System.out.println(binarySearch(arr,0,arr.length-1,key)+ 1);
	}

	public static int binarySearch(int[] arr, int low, int high, int key) {
		int mid = low + (high-low)/2;
		
		if(low>=high) {
			return -2;
		}
		
		if(key > arr[mid]) {
			low = mid+1;
		}
		else if(key < arr[mid]) {
			high = mid-1;
		}
		else {
			return mid;
		}
		
		return binarySearch(arr,low,high,key);
	}
}
