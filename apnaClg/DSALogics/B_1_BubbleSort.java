package DSALogics;

public class B_1_BubbleSort {

	public static void main(String[] args) {
		System.out.println("lets do bubble sort");
		//we move the max value to right most position
		// keeping a track of the sorted array
		// worst case scenario : arraning elements from a descending array
		
		//process
		/*
		 * keep a pointer at the end : showing the sorted array
		 * in first loop, we start from 0th index
		 * we compare ith and i+1th elements and swap accordingly
		 * shifting the larger value to the right
		 * after each loop we shift the sorted pointer to one step left
		 * we do this till the sorted array index
		 * the main loop goes till the sorted pointer is at the beginning
		 */
		
		int[] arr = new int[] {9,8,7,6,5,4,3,2,1,0};
		int step=0;
		System.out.println("unsorted array");
		for(int i:arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int sortedpointer=arr.length-1;sortedpointer>0;sortedpointer--) {
			for(int i=0;i<sortedpointer;i++) {
				
				if(arr[i] > arr[i+1]) {
					swap(arr,i);
				}
			}
			step++;
			System.out.println("at step: " + step + " semi sorted array");
			for(int k:arr) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
	
	public static void swap(int[] arr,int i ) {
		/*
		 * how to swap => other way : a = (a+b) - (b = a)
		 * x = x + y
		 * y = x - y
		 * x = x - y
		 */
		arr[i] = arr[i] + arr[i+1];
		arr[i+1] = arr[i] - arr[i+1];
		arr[i] = arr[i] - arr[i+1];
	}
}
