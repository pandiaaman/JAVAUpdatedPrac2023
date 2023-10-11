package selfPracticeDSA;

import java.util.Arrays;

public class A_1_SortingAlgorithms {

	public static void main(String... args) {
		int arr1[] = new int[] {4,7,1,3,0,9,8,5,2,6};
		
		bubbleSort(arr1);
//		for(int k=0;k<arr1.length;k++) {
//			System.out.print(arr1[k] + " ");
//		}		
		System.out.println("bubble sort");
		Arrays.stream(arr1).forEach(System.out::print);
		System.out.println();
		System.out.println(Arrays.toString(arr1));
		
		
		int arr2[] = new int[] {4,7,1,3,0,9,8,5,2,6};
		
		selectionSort(arr2);
		System.out.println("selection sort");
		System.out.println(Arrays.toString(arr2));
		
		int arr3[] = new int[] {4,7,1,3,0,9,8,5,2,6};
		
		selectionSort(arr3);
		System.out.println("insertion sort");
		System.out.println(Arrays.toString(arr3));
		
		
		int arr4[] = new int[] {4,7,1,3,0,9,8,5,2,6};
		
		mergeSort(arr4);
		System.out.println("merge sort");
		System.out.println(Arrays.toString(arr4));
		
		int arr5[] = new int[] {4,7,1,3,0,9,8,5,2,6};
		
		quickSort(arr5,0,arr5.length-1);
		System.out.println("quick sort");
		System.out.println(Arrays.toString(arr5));
	}
	
	public static void bubbleSort(int[] arr) {
		//multiple swaps per loop
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					arr[i] = arr[j] + arr[i] - (arr[j] = arr[i]);
				}
			}
		}
	}
	
	public static void selectionSort(int[] arr) {
		//one swap per loop
		for(int i=arr.length-1;i>0;i--) {
			int value = i;
			for(int j=0;j<=i;j++) {
				if(arr[j] > arr[value]) {
					value = j;
				}
				arr[value] = arr[i] + arr[value] - (arr[i] = arr[value]);
			}
		}
	}
	
	public static void insertionSort(int[] arr) {
		//no swaps : consider first element as sorted : only move the elements
		for(int i=1;i<arr.length;i++) {
			int value = arr[i];
			for(int j=i-1; j>=0; j--) {
				if(arr[j]>value) {
					arr[j+1] = arr[j];
				}
				arr[j] = value;
			}
		}
	}
	
	public static void mergeSort(int[] arr) {
		//divide and merge
		//O(n) but not good space complexity
		divide(arr,0,arr.length-1);
	}
	
	public static void divide(int[] arr, int low, int high) {
		
		//base case
		if(low >= high) {
			return;
		}
		
		int mid = low + (high - low)/2;
		
		divide(arr, low, mid);
		divide(arr, mid+1, high);
		
		merge(arr, low, mid, high);
	}
	
	public static void merge(int[] arr, int low, int mid, int high) {
		
		int n1 = mid - low + 1;
		int n2 = high-mid;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i=0;i<n1;i++) {
			left[i] = arr[low+i];
		}
		
		for(int j=0;j<n2;j++) {
			right[j] = arr[mid+1+j];
		}
		
		int i=0, j=0;
		int k=low;
		
//		for(;i<left.length && j<right.length;i++,j++) {
//			if(left[i] < right[j]) {
//				arr[k] = left[i];
//			}else {
//				arr[k] = right[j];
//			}
//			k++;
//		}
		while(i<n1 && j<n2) {
			if(left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		//better space complexity
		//base case
		if(low>=high) {
			return;
		}
		
		int pivotIndex = partition(arr, low, high);
		
		quickSort(arr, low, pivotIndex-1);
		quickSort(arr, pivotIndex+1, high);
	}
	
	public static int partition(int[] arr, int low, int high) {
//		System.out.println("temp : " + low + " " + high);
		int i = low-1;
		int pivot = arr[high];
		
		for(int j=low; j<high;j++) {
			if(arr[j] < pivot) {
				i++;
				arr[i] = arr[j] + arr[i] - (arr[j] = arr[i]);
			}
		}
		i++;
		//after loop ends, we need to insert thepivot value in place of i
		int temp = arr[i];
		arr[i] = pivot;
		arr[high] = temp;
		
		
		return i;
	}
}
