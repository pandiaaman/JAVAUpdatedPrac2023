package A_Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class A_PeakElementInArray {

	public static void main(String[] args) {
		//a peak element in an array is an element that is greater than both its neighbors
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the no of elements in the array");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		int counter = 0;
		for(int i = 1; i<=n; i++) {
			System.out.println("enter the element no " + counter);
			arr[i-1] = sc.nextInt();
			counter++;
		}
		
		ArrayList<Integer> resPeakElements = new ArrayList<Integer>();
		try {
			resPeakElements = findPeakElementsInArray(arr);
			resPeakElements.forEach(x -> System.out.print(x + " "));
		}catch(Exception e) {
			System.out.println("error : " + e);
		}
		
		System.out.println();
		
		findPeakElementsInArrayUsingRecursion(arr,1);
		
		System.out.printf("%n %n");
		
		int element = findAnyPeakElementUsingRecursiveBinarySearch(arr,0,n-1,n);
		System.out.println("peak " + arr[element]);
		
		element = findAnyPeakElementUsingIterativeBinarySearch(arr);
		System.out.println("peak using iteration" + arr[element]);
		
	}


	private static int findAnyPeakElementUsingIterativeBinarySearch(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		
		while(low <= high) {
			mid = low + (high - low)/2;
			
			if((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == arr.length-1 || arr[mid+1] <= arr[mid])) {
				break;
			}
			
			if(mid > 0 && arr[mid-1] > arr[mid]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		
		return mid;
		
		
	}


	private static int findAnyPeakElementUsingRecursiveBinarySearch(int[] arr, int low, int high, int n) {
		
		int mid = low + (high - low)/2;
		
		System.out.println("mid is " + mid);
		
		
		if((mid==0 || arr[mid] >= arr[mid-1] ) && (mid == n-1 || arr[mid] >= arr[mid+1])) {
			System.out.println("peak element : " + arr[mid]);
			return mid;
		}
		
		if(mid > 0 && arr[mid] < arr[mid-1]) {
			//peak element lies at left side
			high = mid-1;
			return findAnyPeakElementUsingRecursiveBinarySearch(arr, low, high, n);
		}

		else {
			//peak element lies at the right side
			low = mid + 1;
			return findAnyPeakElementUsingRecursiveBinarySearch(arr, low, high, n);
		}
		
	}


	public static ArrayList<Integer> findPeakElementsInArray(int[] arr) throws Exception{
		
		if(arr.length <= 2) {
			System.out.println("array length too short");
			throw new Exception();
		}
		
		ArrayList<Integer> resPeakElements = new ArrayList<Integer>();
		
		for(int i = 1 ; i < arr.length - 1 ; i++) {
			if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
				resPeakElements.add(arr[i]);
			}
		}
		
		return resPeakElements;
	}
	
	public static void findPeakElementsInArrayUsingRecursion(int[] arr,int i){
		if(i == arr.length - 1) {
			return;
		}
		if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
			System.out.println(arr[i]);
		}
		
		findPeakElementsInArrayUsingRecursion(arr,i+1);
	}
}
