package j_DataStructures2;

import java.util.Arrays;

public class B2_SortingAlgorithms {

	public static void main(String[] args) {
		System.out.println("bubble sort");
		
		int[] arr1 = new int[] {3,7,1,9,2,5,11,4,8,0};
//		Arrays.fill(arr1, 5);
		bubbleSort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		int[] arr2 = new int[] {3,7,1,9,2,5,11,4,8,0};
		selectionSort(arr2);
		System.out.println(Arrays.toString(arr2));
	}
	
	public static void bubbleSort(int[] arr) {
		//check each element with all next occurring element, swap them if earlier one is larger
		for(int i=0;i<arr.length - 1;i++) { //n
			for(int j=i+1;j<arr.length;j++) { //n
				if(arr[i] > arr[j]) {
					arr[i] = arr[j] + arr[i] - (arr[j] = arr[i]);
				}
			}
		}
	}
	
	public static void selectionSort(int[] arr) {
		//don't compare everything with everything, we store the value and if the value is higher we swap
		for(int sortedPartition = arr.length-1; sortedPartition>=0 ; sortedPartition--) {
			int maxIndex = 0;
			for(int i = 0; i <= sortedPartition; i++) {
				if(arr[i] > arr[maxIndex]) {
					maxIndex = i;
				}
			}
			arr[maxIndex] = arr[sortedPartition] + arr[maxIndex] - (arr[sortedPartition] = arr[maxIndex]);
		}
	}
	
}
