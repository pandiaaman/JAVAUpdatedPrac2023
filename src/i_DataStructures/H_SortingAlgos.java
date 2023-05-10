package i_DataStructures;

public class H_SortingAlgos {

	public static void main(String[] args) {
		

		int[] arr = new int[] {9,4,2,6,8,5,12,33,14,10,1,22};
		for(int a : arr) {System.out.print(a + " ");}
		System.out.println();
		
		System.out.println();
		bubbleSort(arr);
		System.out.println();
		arr = new int[] {9,4,2,6,8,5,12,33,14,10,1,22};
		selectionSort(arr);
		System.out.println();
		arr = new int[] {9,4,2,6,8,5,12,33,14,10,1,22};
		insertionSort(arr);
		//advanced sorting using recursion
		arr = new int[] {9,4,2,6,8,5,12,33,14,10,1,22};
		mergeSort(arr);
		System.out.println();
		System.out.println("after merge sort ");
		for(int a : arr) {System.out.print(a + " ");}
		
		arr = new int[] {9,4,2,6,8,5,12,33,14,10,1,22};
		quickSort(arr, 0 , arr.length-1);
		System.out.println();
		System.out.println("after quick sort ");
		for(int a : arr) {System.out.print(a + " ");}
	}

	private static void quickSort(int[] arr, int start, int end) {
		
		/*
		 * moves smaller elements to the left of pivot, keeps the pivot at end and keeps comparing elements, later swaps the pivot
		 * run time complexity : O(n log n)
		 * 		worst case : O(n^2)
		 * 
		 * space complexity : O(n log n) due to recursion
		 */
		
		/*
		 * we set the pivot to the end
		 * we use two indices to find the final resting place for the pivot value
		 * 		lets use indices i and j, at the beginning of the array , i is one before j and j is first element
		 * we use temp value to check if the value at j is less than pivot, if greater than or equal to we ignore
		 * 
		 * if the value at pivot is greater than j, then we increment i and swap i and j
		 * once j reaches the pivot we put pivot value at i+1
		 * 
		 * now we divide the array into two parts, one before pivot and one after pivot
		 * quick sort is recursive algo, we will pass the array partitions to the quicksort function
		 * 
		 * it is also a recursive devide and conquer algo, but unlike merge sort, we dont create sub arrays, we sort these arrays in place
		 * we need to keep the track of the beginning and ending indices of these partitions
		 * 
		 * now in the next loop, pivot will become the last element of sub array that is passed
		 */
		
		if(end<=start) {
			return; //base case
		}
		int pivot = partition(arr,start,end);
		quickSort(arr,start,pivot-1);
		quickSort(arr,pivot+1,end);
		
	}

	private static int partition(int[] arr, int start, int end) {
		//pivot is always at the end in this method
		int pivot = arr[end];
		int i = start - 1;
		
		for(int j=start; j<=end-1;j++) {
			if(arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i++;
		int temp = arr[i];
		arr[i] = arr[end];
		arr[end] = temp;
		
		return i;
	}

	private static void mergeSort(int[] arr) {
		/*
		 * O(n log n) : quasi linear time : (quick sort, heap sort)
		 * merge sort has O(n) for space complexity, since we create n no of sub arrays
		 * divide and conquer
		 * contains two parts : breaking and joining of array, uses recursion
		 * divide array into two equal parts until we have one element left in each array
		 * in the joining part, compare two array elements and arrange them before joining
		 */
		int length = arr.length;
		if(length<=1) return; //base case
		
		int mid = length/2;
		
		int[] leftArr = new int[mid];
		int[] rightArr = new int[length - mid];
		
		int i = 0; //left array
		int j = 0; //right array
		
		for(; i<length; i++) {
			if(i<mid) {
				leftArr[i] = arr[i];
			}
			else {
				rightArr[j] = arr[i];
				j++;
			}
		}
		System.out.println("leftArr : ");
		for(int a : leftArr) {System.out.print(a + " ");}
		System.out.println();
		System.out.println("rightArr : ");
		for(int a : rightArr) {System.out.print(a + " ");}
		System.out.println();
		
		
		mergeSort(leftArr);
		mergeSort(rightArr);
		merge(leftArr, rightArr, arr);
	}
	
	private static void merge(int[] leftArray, int[] rightArray, int[] array) {
		
		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;
		int i = 0, l = 0, r = 0; //indices
		
		//check the conditions for merging
		while(l < leftSize && r < rightSize) {
			if(leftArray[l] < rightArray[r]) {
				array[i] = leftArray[l];
				i++;
				l++;
			}
			else {
				array[i] = rightArray[r];
				i++;
				r++;
			}
		}
		while(l < leftSize) {
			array[i] = leftArray[l];
			i++;
			l++;
		}
		while(r < rightSize) {
			array[i] = rightArray[r];
			i++;
			r++;
		}
		System.out.println();
		System.out.println("arr merged : ");
		for(int a : array) {
			System.out.print(a + " ");
		}
	}

	private static void insertionSort(int[] arr) {
		//insertion sort
		/*
		 * in given array, we keep 
		 */
		
		for(int i=1;i<arr.length-1;i++) {
			int temp = arr[i];
			int j = i-1; 
			
			while(j >= 0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
//			for(int a : arr) {System.out.print(a + " ");}
//			System.out.println(" => " + temp);
		}
		System.out.println();
		System.out.println("after swapping insertion sort ");
		for(int a : arr) {System.out.print(a + " ");}
	}

	private static void selectionSort(int[] arr) {
		//selection sort
		/*
		 *  we keep track of the minimum value in a temp box and at the end of each loop swap it with the lowest index available
		 */
//		int tempMin = 0;
		int counter = 0;
		for(int i = 0 ; i< arr.length -1; i++) {
			int tempMin = i;
			for(int j = i+1 ; j< arr.length ; j++) {
				if(arr[j] < arr[tempMin]) {
					tempMin = j;
				}
				counter++;
			}
			int temp = arr[i];
			arr[i] = arr[tempMin];
			arr[tempMin] = temp;
		}
		System.out.println();
		System.out.println("after swapping selection sort took : " + counter + " loops");
		for(int a : arr) {System.out.print(a + " ");}
	}

	private static void bubbleSort(int[] arr) {
		//bubble sort
				/*
				 * O(n^2) : larger the dataset, heavier it gets and is very expensive
				 * 
				 * the element with higher value bubbles up to the end
				 * we compare one element to the next one and check if it is larger, if yes we swap
				 */
		int counter = 0;

		for(int i = 0 ; i< arr.length-1 ; i++) {
			for(int j = 0 ; j< arr.length-i-1 ; j++) {
				if(arr[j] > arr[j+1]) {
					arr[j] = arr[j] + arr[j+1];
					arr[j+1] = arr[j] - arr[j+1];
					arr[j] = arr[j] - arr[j+1];
					
//					for(int a : arr) {System.out.print(a + " ");}
//					System.out.println();
					counter++;
				}
			}
		}
		
		System.out.println("after swapping Bubble sort took : " + counter + " loops");
		for(int a : arr) {System.out.print(a + " ");}
		
	}

}
