package DSALogics;

import java.util.Collections;

public class B_SortingMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("here we will sort with differnt methods");
		/*
		 * stable vs unstable sorting
		 * 
		 * in case of duplicates, if we switch the positions while sorting of duplicate values, then its unstable
		 * if on sorting the duplicate values preserve their original order then its stable 
		 * 
		 * for ints it doesnt seem important but in case of objects with various arrays inside it, it might lead to discrepency
		 */
		
		int[] arr = new int[] {32,-4,5,62,-6,67,82,-34,-65,564,927,346,23,-321,65};
//		bubbleSort(arr);
//		selectionSort(arr);
//		insertionSort(arr);
		shellSort(arr);
		
		
		for(int a : arr) {
			System.out.print(a+" ");
		}
	}
	
	public static void bubbleSort(int[] arr) { // O(n^2)
		for(int sortedPartition = arr.length-1;sortedPartition>=0;sortedPartition--) {
			for(int i=0;i<sortedPartition;i++) {
				if(arr[i] > arr[i+1]) {
					arr[i] = arr[i] + arr[i+1] - (arr[i+1] = arr[i]);
				}
			}
		}
	}
	
	public static void selectionSort(int[] arr) {
		for(int sortedPartition=arr.length-1; sortedPartition >= 0; sortedPartition--) {
			int maxIndex = 0;
			for(int i=0;i<=sortedPartition;i++) {
				if(arr[maxIndex]<arr[i]) {
					maxIndex = i;
				}
			}
			arr[sortedPartition] = arr[sortedPartition] + arr[maxIndex] - (arr[maxIndex] = arr[sortedPartition]);
		}
	}
	
	public static void insertionSort(int[] arr) {
		for(int sortedIndex=1; sortedIndex<=arr.length-1; sortedIndex++) {
			int value = arr[sortedIndex];
			for(int i=sortedIndex-1;i>=0;i--) {
				if(value<arr[i]) {
					arr[i+1] = arr[i];
					arr[i] = value;
				}
				else if(value>arr[i]) {
					arr[i+1] = value;
					break;
				}
			}
		}
	}
	
	public static void shellSort(int[] arr) {
		for(int gap=arr.length; gap>=1 ; gap/=2) {
			for(int sortedIndex=1;sortedIndex<=arr.length-1;sortedIndex++) {
				int value = arr[sortedIndex];
				for(int i=sortedIndex-1;i>=0;i--) {
					if(value<arr[i]) {
						arr[i+1] = arr[i];
						arr[i] = value;
					}
					else {
						arr[i+1] = value;
						break;
					}
				}
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
