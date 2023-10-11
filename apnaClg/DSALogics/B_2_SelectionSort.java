package DSALogics;

import java.util.Arrays;

public class B_2_SelectionSort {

	public static void main(String[] args) {
		
		/*
		 * lets understand selection sort first
		 * here we have a pointer for sorted array (after this pointer the array is sorted) same as bubble sort
		 * the pointer starts from the right most side and moves to 0th index
		 * we set the first index as the max value (later will be swapped)
		 * we loop through the array and find the max value and swap it with the pointer of the sorted array
		 * it is better than bubble sort coz we only swap once each loop
		 */
		int[] arr = new int[] {1,34,99,56,-38,9,23,-56,12,7};
		arr = new int[] {1,7,13,-5,8,-12,9,6,3,2,22,4};
		int turn = 0;
		for(int sortedpartition=arr.length-1;sortedpartition>0;sortedpartition--) {
			int maxindex = 0;
			for(int i=1;i<=sortedpartition;i++) {
				if(arr[maxindex]<arr[i]) {
					maxindex=i;
				}
			}
			turn++;
			System.out.println("turn : " + turn + " maxx value " + arr[maxindex]);
			swap(arr,maxindex,sortedpartition);
			
			System.out.print("for sortedindex as :" + sortedpartition + " : ");
			System.out.println(Arrays.toString(arr));
			System.out.println();
		}
		
	}
	
	public static void swap(int[] arr, int maxindex, int sortedpartition) {
		if(maxindex == sortedpartition) {
			return;
		}
//		a = (a + b) -(b=a)
		arr[maxindex] = (arr[maxindex] + arr[sortedpartition]) - (arr[sortedpartition] = arr[maxindex]);
	}
}
