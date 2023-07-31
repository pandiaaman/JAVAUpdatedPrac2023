package revisionTwo;

import java.util.Arrays;

public class A1_SortingAlgos {

	
	public static void main(String[] args) {
		
		int[] arr1 = new int[] {1,7,13,-5,8,-12,9,6,3,2,22,4};
		
		bubbleSort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		int[] arr2 = new int[] {1,7,13,-5,8,-12,9,6,3,2,22,4};
		
		selectionSort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 = new int[] {1,7,13,-5,8,-12,9,6,3,2,22,4};
		
		insertionSort(arr3);
		System.out.println(Arrays.toString(arr3));
		
		int[] arr4 = new int[] {1,7,13,-5,8,-12,9,6,3,2,22,4};
		
		mergeSort(arr4);
		System.out.println(Arrays.toString(arr4));
		
		int[] arr5 = new int[] {1,7,13,-5,8,-12,9,6,3,2,22,4};
		
		quickSortImpl(arr5);
		System.out.println(Arrays.toString(arr5));
	}
	
	//multiple swaps per loop
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		
		for(int sortedPointer = n-1; sortedPointer>0; sortedPointer--) {
			for(int i = 0; i<sortedPointer;i++) {
				if(arr[i] > arr[i+1]) {
					arr[i] = arr[i] + arr[i+1] - (arr[i+1] = arr[i]);
				}
			}
		}
	}
	
	//one swap per loop
	public static void selectionSort(int[] arr) {
		int n = arr.length;
		
		for(int sortedPointer = n-1; sortedPointer >0; sortedPointer--) {
			int maxValIndex = 0;
			for(int i=1; i<=sortedPointer; i++) {
				if(arr[i] > arr[maxValIndex]) {
					maxValIndex = i;
				}
				arr[maxValIndex] = arr[sortedPointer] + arr[maxValIndex] - (arr[sortedPointer] = arr[maxValIndex]);
			}
		}
	}
	
	//no swapping needed
	public static void insertionSort(int[] arr) {
		//no swapping
		for(int sortedTill = 1; sortedTill<=arr.length-1;sortedTill++) {
			int value = arr[sortedTill];
			for(int i=sortedTill-1;i>=0;i--) {
				if(arr[i] > value) {
					arr[i+1] = arr[i];
					arr[i] = value;
				}else {
					break;
				}
				
			}
		}
	}
	
	//stable sort : needs more space
	public static void mergeSort(int[] arr) {
		//divide and conquer
		divide(arr, 0, arr.length-1);
	}
	
	public static void divide(int[] arr, int low, int high) {
		
		if(low>=high) {
			return;
		}
		
		int mid = low + (high - low)/2;
		
		divide(arr,low,mid);
		divide(arr,mid+1,high);
		conquer(arr,low,mid,high);
	}
	
	public static void conquer(int[] arr, int low, int mid, int high) {
		
		int n1 = mid-low+1;
		int n2 = high-mid;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		
		for(int i = 0; i<n1; i++) {
			left[i] = arr[low+i];
		}
		for(int i = 0; i<n2; i++) {
			right[i] = arr[mid+i+1];
		}
		

		int i = 0, j = 0;
		int k = low;
		
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
			k++;
			i++;
		}
		
		while(j<n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
		
	}
	
	//unstable, needs less space
	public static void quickSortImpl(int[] arr) {
		//pivot partition
		quickSort(arr, 0, arr.length-1);
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		
		if(low>=high) {
			return;
		}
		
		int pivotIndex = partition(arr, low, high);
		quickSort(arr,0,pivotIndex-1);
		quickSort(arr,pivotIndex+1,high);
	}
	
	public static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		
		int i = low-1;
		
		for(int j=low; j<high; j++) {
			if(arr[j] < pivot) {
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
