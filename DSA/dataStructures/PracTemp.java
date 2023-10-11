package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class PracTemp {

	public static List<String> stringBreaks(String str, int i){
		List<String> ans = new ArrayList<String>();
		String res = "";
		while(!str.isEmpty()) {
			if(str.length()<i) {
				ans.add(str);
//				System.out.println("here");
				break;
			}
			 res = str.substring(0,i);
//			 System.out.println(res);
			 ans.add(res);
			 str  = str.substring(i);
		}
		return ans;
	}
	
	//find target value index in rotated sorted array
	public static int findEl(int[] arr, int target) {
		
		int index = binarySearch(arr, 0, arr.length-1, target);
		System.out.println(index);
		
		int arr2[] = new int[] {50,60,70,80,90,100,10,20,30,40};
		int startIndex = findStartIndex(arr2, 0, arr.length-1);
		System.out.println(startIndex);
		return -1;
	}
	
	public static int findStartIndex(int[] arr, int low, int high) {
		
		
		int mid = low + (high - low)/2;
		
		if(arr[mid] > arr[mid+1]) {
			return mid;
		}
		else if(arr[mid] < arr[mid-1]) {
			return mid;
		}
		if(arr[low] > arr[high]) {
			low = mid+1;
		}else if(arr[low] < arr[high]) {
			high = mid-1;
		}
		
		return -1;
	}
	
	public static int binarySearch(int[] arr, int low, int high, int target) {
		
		//base case
		if(high>=low) {
			
			int mid = low + (high - low)/2;
			
			if(target > arr[mid]) {
				low = mid+1;
			}else if(target < arr[mid]) {
				high = mid-1;
			}else if(target == arr[mid]) {
				return mid;
			}
			
			return binarySearch(arr, low, high, target);
		}
		return -1;
	}
	
	 
	public static void main(String[] args) {
		//create function with parameters (string, int) and return type is List of strings

		//Input/Output examples

		//input "abcdef", 2 then output should be "ab","cd","ef"
		//input "abcdef", 3 -> "abc","def"
		
		List<String> ans = stringBreaks("abcdefg",5);
		for(String s : ans) {
			System.out.println(s);
		}
		
		int arr[] = new int[] {10,20,30,40,45,47,50,53,60};
//		int arr2[] = new int[100000];
//		for(int i=0;i<100000;i++) {
//			arr2[i] = i;
//		}
			
			
		findEl(arr,10);
		
	}

}
