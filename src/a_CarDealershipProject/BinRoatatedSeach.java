package a_CarDealershipProject;

public class BinRoatatedSeach {

	public static void main(String[] args) {
		int[] arr = new int[] {25,30,40,50,10,20};
		int key = 20;
		int index = binarySortedSearch(arr, 0, arr.length-1, key);
		System.out.println(index);
	}
	
	public static int findStart(int[] arr, int low, int high) {

		if(low >= high) {
			
		}
		int mid = low + (high-low)/2;
		
		if(mid < low) {
			return findStart(arr, low, mid);
		}
		if(mid > high) {
			return findStart(arr, mid, high);
		}
		else {
			return mid;
		}
			
		
	}
	
	
	public static int binarySortedSearch(int[] arr, int low, int high, int key) {
		//base case
		if(low >= high) {
			return -1;
		}
		
		int mid = low + (high-low)/2;
		
		if(key > arr[mid]) {
			return binarySortedSearch(arr, mid, high, key);
		}
		else if(key < arr[mid]) {
			return binarySortedSearch(arr, low, mid, key);
		}else {
			return mid;
		}
		
		
	}
}
