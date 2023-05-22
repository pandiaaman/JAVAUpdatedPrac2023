package javaIntro;

import java.util.Arrays;

public class B_binarySearch {

	public static int binarySearch(int[] sortedArray, int key, int low, int high) {
				
		while(low <= high) {
			int mid = low + (high-low)/2;
			
			if(key > sortedArray[mid]) {
				low = mid+1;
			}
			else if(key < sortedArray[mid]) {
				high = mid-1;
			}
			else if(key == sortedArray[mid]) {
				return mid;
			}
		}
		return -1;
	}
	
	
	public static int binarySearchRec(int[] sortedArr, int key, int low, int high) {
		//base case
		if(low > high) {
			return -1;
		}
		
		int mid = low + (high-low)/2;
		
		if(key > sortedArr[mid]) {
			return binarySearchRec(sortedArr, key, mid+1, high);
		}
		else if(key < sortedArr[mid]) {
			return binarySearchRec(sortedArr, key, low, mid-1);
		}
		else { //key == sortedArr[mid]
			return mid;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[10_000]; 
		
		for(int i=1;i<10_000;i++) {
			arr[i] = i;
		}
		
		Arrays.sort(arr);
		
		long startTime = System.nanoTime();
		
		int search5 = binarySearch(arr,7749,0,arr.length-1);
		System.out.println(search5);
		
		long endTime = System.nanoTime();
		System.out.println("it took " + (endTime - startTime) + " to finish with while loop" );
		startTime = System.currentTimeMillis();
		
		int searchrec = binarySearchRec(arr,7749,0,arr.length-1);
		System.out.println(searchrec);
		endTime = System.nanoTime();
		System.out.println("it took " + (endTime - startTime) + " to finish with recursion" );

	}

}
