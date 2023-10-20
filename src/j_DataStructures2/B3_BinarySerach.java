package j_DataStructures2;

public class B3_BinarySerach {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,4,7,9,11,16,19,26,38,39,40,44,46,59,66,68,71,73,79};
		
		int target = 79;
		
		int index = binarySearch(arr, 0, arr.length - 1, target);
		System.out.println(index);
		
	}
	
	public static int binarySearch(int[] arr, int low, int high, int target) {
		
		if(low > high) {
			return -1;
		}
		
		int mid = low + (high-low)/2;
//		System.out.print(mid + " ");
		
		if(target > arr[mid]) {
			low = mid+1;
		}else if(target < arr[mid]) {
//			System.out.println(arr[mid]);
			high = mid-1;
		}else {
			return mid + 1;
		}
		
		return binarySearch(arr, low, high, target);
	}
}
