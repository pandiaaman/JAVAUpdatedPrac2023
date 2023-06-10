package dataStructures;

public class Z_2_SearchKeyInRotatedSortedArray {
	
	/*
	 * time complexity : O(log N)
	 */
	public static int binarySearch(int[] arr, int low, int high, int key) {
		System.out.println(low + " " + high);
		//base case
		if(low > high) {
			return -1;
		}
		
		int mid = low +(high - low)/2;
				System.out.println("binsearch :" + arr[mid] + "key " + key);
		if(key < arr[mid]) {
			return binarySearch(arr, low, mid, key);
		}else if(key > arr[mid]) {
			return binarySearch(arr, mid+1, high, key);
		}else if(key == arr[mid]) {
			return mid;
		}
		
		return -1;
		
	}
	
	static int step = 0;
	
	public static int findPivot(int[] arr, int low, int high) {
		System.out.println("step: " + ++step);
		
		int mid = low + (high-low)/2;
		
		System.out.println("mid:" + mid);
		//base case
		System.out.println("arr[mid]  arr[low]  arr[high] " + arr[mid] + " " + arr[low] + " " + arr[high]);
		
		if(arr[mid] > arr[low] && arr[mid] < arr[high]) { //if everything is allright then low is the index we are looking for
			return low;
		}
		
		if(arr[mid] < arr[low]) {
			System.out.println("arr[mid] < arr[low] : exists in left half");
			return findPivot(arr, low, mid);
		}
		else if(arr[mid] > arr[high]) {
			System.out.println("arr[mid] > arr[high] : exists in right half");
			return findPivot(arr, mid+1, high);
		}
		
		return low;
		
	}
	
	public static void main(String[] args) {
		
//		int[] arr = new int[] {50,60,70,75,79,80,90,10,20,30,40};
//		int key = 20;
		
		int[] arr = new int[] {1,3};
		int key = 3;
		int pivotIdx = findPivot(arr, 0, arr.length-1);
		System.out.println("pivotIdx:" + pivotIdx);
		
		int finalKeyIdx = -1;
		//check if the key is less or more than the pivot index
		
		System.out.println("key :" + key + " arr[pivotIdx] " + arr[pivotIdx] + " arr[arr.length-1] : " + arr[arr.length-1] + " arr[0] " + arr[0]);
		if(key == arr[pivotIdx]) {
			finalKeyIdx = pivotIdx;
		}
		else if(key > arr[pivotIdx] && key <= arr[arr.length-1]) { //second half binary search
			System.out.println("second half binary search");
			finalKeyIdx = binarySearch(arr, pivotIdx, arr.length-1, key);
		}else if(key > arr[pivotIdx] && key >= arr[0]) { //first half binary search
			System.out.println("first half binary search");
			finalKeyIdx = binarySearch(arr, 0, pivotIdx, key);
		}
		System.out.println(finalKeyIdx);
	}

}
