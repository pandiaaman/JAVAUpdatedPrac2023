package DSALogics;

public class B_42_MergeSort {

	public static void conquer(int[] arr, int low, int mid, int high) {
	
		//idea is to create two different arrays containing the values of both halves of incoming array separately
		
		//no of items in the arrays
		int n1 = mid - low +1; //size of array in the first half
		int n2 = high - mid; //size of array in the second half
		
		//declaring arrays
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		//we fill both the arrays 
		for(int i=0;i<n1;i++) {
			left[i] = arr[low+i];
		}
		for(int j=0;j<n2;j++) {
			right[j] = arr[mid+1+j];
		}
		
		//declaring indices to traverse
		int i=0,j=0;//i is left index, j is right index
		int k=low; //k is equal to the initial inxex of the merged subarray
		
		
		//filling up the final array using above two arrays, in sorted order
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
		
		//if left arrays is greater then right, then we put all the remaining values as it is
		while(i<n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		//dytto
		while(j<n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
		
	}
	
	public static void divide(int[] arr, int low, int high) {
		
		if(low>= high) {
			return;
		}
		
		int mid = low + (high - low)/2;
		
		divide(arr, low, mid);
		
		divide(arr, mid+1, high);
		
		conquer(arr, low, mid, high);
		
	}
	
	public static void main(String[] args) {
		int arr[] = {4,7,1,3,0,9,8,5,2,6};
		
		int n = arr.length;
		divide(arr, 0, n-1);
		
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}

	}

}
