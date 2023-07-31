package revisionTwo;

import java.util.Arrays;

public class A2_BinarySearch {

	/*
	 * binary search
	 */
	public static int binarySearch(int[] arr, int low, int high, int target) {
		//base case
		if(low<=high) {
				
			System.out.println("///");
			int mid = low + (high -low)/2;
			System.out.println("mid : " + mid +  " mid value : " + arr[mid] + " target : " + target);
			if(arr[mid]==target) {
				System.out.println("found at " + mid);
				return mid;
			}
			if(target > arr[mid]) {
				System.out.println("since :: target > arr[mid]");
				binarySearch(arr,mid+1,high,target);
			}else {
				System.out.println("since :: target < arr[mid]");
				binarySearch(arr,low,mid,target);
			}
		}
		
		return -1;
	}
	
	/*
	 * main method
	 */
	public static void main(String[] args) {
		int[] arr = new int[] {3,4,-16,2,-14,-26,7,131,45,9,0,222,13,146,2462,467,2343,-6,47345,};
		quickSortImpl(arr);
		System.out.println(Arrays.toString(arr));//sorted array
		
		//binary search
		int target = 146;
		System.out.println(binarySearch(arr, 0, arr.length-1, target));
	}
	
	/*
	 * quicksort
	 */
	
	public static void quickSortImpl(int[] arr) {
		quickSort(arr,0,arr.length-1);
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if(low>=high) {
			return;
		}
		
		int pivotIndex = partition(arr,low,high);
		quickSort(arr,low,pivotIndex-1);
		quickSort(arr,pivotIndex+1,high);
		
	}
	
	public static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		
		int i = low-1;
		
		for(int j=low;j<high;j++) {
			
			if(arr[j]<pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i++;
		int temp = arr[i];
		arr[i] = arr[high];
		arr[high] = temp;
		
		return i;
	}
}
