package revisionTwo;

import java.util.Arrays;

public class A_SortingAlgos {

	
	public static void main(String[] args) {
		
		int[] arr = new int[] {5,6,3,2,7,9,1,4,8,0};
		
		bubbleSort(arr);
		
		for(int i:arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int[] arr1 = new int[] {1,34,99,56,-38,9,23,-56,12,7};
		arr1 = new int[] {1,7,13,-5,8,-12,9,6,3,2,22,4};
		selectionSort(arr1);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println();
		
		int[] arr2 = new int[] {1,34,99,56,-38,9,23,-56,12,7};
		
		insertionSort(arr2);
		
		System.out.println(Arrays.toString(arr2));
		System.out.println();
		
		
		int[] arr3 = new int[] {1,34,99,56,-38,9,23,-56,12,7};
		
		mergeSort(arr3);
		
		System.out.println(Arrays.toString(arr3));
		System.out.println();
		
		int[] arr4 = new int[] {1,34,99,56,-38,9,23,-56,12,7};
		
		quickSort(arr4);
		
		System.out.println(Arrays.toString(arr4));
		System.out.println();
	}
	
	/*
	 * temp
	 * temp = a;
	 * a = b;
	 * b = temp;
	 * 
	 * without temp
	 * a = a + b;
	 * b = a - b;
	 * a = a - b;
	 * 
	 * one line
	 * a = (a + b)-(b = a)
	 */
	
	//bubble sort
	public static void bubbleSort(int[] arr) {
		//O(n^2)
		int n = arr.length;
		for(int sortedPointer=n-1;sortedPointer>0;sortedPointer--) {
			for(int i=0;i<sortedPointer;i++) {
				if(arr[i]>arr[i+1]) {
					arr[i] = (arr[i] + arr[i+1]) - (arr[i+1] = arr[i]);
				}
			}
		}
	}
	
	//selection sort
	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for(int sortedPointer = n-1;sortedPointer>0;sortedPointer--) {
			int maxValIndex = 0;
			for(int i=1; i<sortedPointer; i++) {
				if(arr[i] > arr[maxValIndex]) {
					maxValIndex = i;
				}
			}
			//a = (a + b) - (b = a)
			arr[maxValIndex] = (arr[maxValIndex] + arr[sortedPointer]) - (arr[sortedPointer] = arr[maxValIndex]);
			
		}
	}
	
	//insertion sort
	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for(int sortedTill = 1; sortedTill <= n; sortedTill++) {
			int value = arr[sortedTill];
			for(int j = sortedTill-1; j >=0; j-- ) {
				if(arr[j] > value) {
					arr[j+1] = arr[j];
					arr[j] = value;
				}else if(arr[j] <= value) {
//					arr[j+1] = value;
					break;
				}
				
			}
		}
	}
	
	
	//merge sort
	public static void mergeSort(int[] arr) {
		//divide
		divide(arr,0,arr.length-1);
	}
	
	public static void divide(int[] arr, int start, int end) {
		
		if(start>=end) {
			return;
		}
		
		int mid = start+(end-start)/2;
		divide(arr,start,mid);
		divide(arr,mid+1,end);
		conquer(arr,start,mid,end);
	}
	
	public static void conquer(int[]arr, int start, int mid, int end) {
		
		int n1 = mid - start +1;
		int n2 = end - mid;
		
		int left[] = new int[n1];
		int right[] = new int[n2];
		
		for(int i=0;i<n1;i++) {
			left[i] = arr[start + i];
		}
		
		for(int i=0; i<n2; i++) {
			right[i] = arr[mid + 1 + i];
		}
		
		int i=0,j=0;
		int k=start;
		
		//filling up the final array
		while(i<n1 && j<n2) {
			if(left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			}else if(right[j] < left[i]) {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		
		while(i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}	
	}
	
	
	//quick sort
	public static void quickSort(int[] arr) {
		
		quickSortImpl(arr,0,arr.length-1);
	}
	
	public static void quickSortImpl(int[] arr, int low, int high) {
		if(low>=high) {
			return;
		}
		
		int pivotIndex = partition(arr, low, high);
		quickSortImpl(arr,low,pivotIndex-1);
		quickSortImpl(arr,pivotIndex+1,high);
		
	}
	
	public static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		
		int i = low-1;
		
		for(int j=low;j<high;j++) {
			if(arr[j]<pivot) {
				i++;
//				System.out.println("arr[i] " + arr[i] + " and arr[j] " + arr[j]);
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i++;
		//swap pivot and i value
		
		arr[high] = (arr[i] + arr[high]) - (arr[i] = arr[high]);
		
		return i;
	}
}
