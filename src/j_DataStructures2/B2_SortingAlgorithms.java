package j_DataStructures2;

import java.util.Arrays;

public class B2_SortingAlgorithms {

	public static void main(String[] args) {
		System.out.println("bubble sort");
		
		int[] arr1 = new int[] {3,7,1,9,2,5,11,4,8,0};
//		Arrays.fill(arr1, 5);
		bubbleSort(arr1);
		System.out.println(Arrays.toString(arr1));
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
}
