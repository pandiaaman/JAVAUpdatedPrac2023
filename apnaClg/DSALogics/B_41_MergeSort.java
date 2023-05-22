package DSALogics;

public class B_41_MergeSort {

	
	/*
	 * time complexity : O(n log n)
	 * 
	 * the problem with merge sort is that it needs extra space for creating an array at the conquer step
	 * 
	 * divide : O(log n) : (like binary search)
	 * conquer : O(n)
	 */
	public static void mergeConquer(int[] arr, int low, int mid, int high) {
		//create a new array where we will store the sorted values
		int[] merged = new int[high - low + 1];
		
		int idx1 = low; //tracking the first array
		int idx2 = mid + 1; //tracking the second array
		
		int x = 0; //tracking the merged array index, the new one
		
		while(idx1<= mid && idx2<= high) {
			if(arr[idx1] <= arr[idx2]) {
				merged[x] = arr[idx1];
				x++; 
				idx1++;
			}
			else {
				merged[x++] = arr[idx2++];
			}
		}
		
		//if one of the arrays is completely stored then we can safely copy the remaining content of the other array to main
		while(idx1<=mid) {
			merged[x++] = arr[idx1++];
		}
		
		while(idx2<=high) {
			merged[x++] = arr[idx2++];
		}
		
		
		//copying the elements into the original array now
		for(int i= 0, j= low; i<merged.length;i++,j++) {
			arr[j] = merged[i];
		}
	}
	
	public static void divide(int[] arr, int low, int high) {
		
		if(low >= high) {
			return;
		}
		
		int mid = low +(high-low)/2;
		
		divide(arr,low, mid);
		
		divide(arr, mid+1, high);
		
		mergeConquer(arr, low, mid, high);
	}
	
	public static void main(String[] args) {
		int arr[] = {6,3,9,5,2,8};
		
		int n = arr.length;
		divide(arr, 0, n-1);
		
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
	}
}
