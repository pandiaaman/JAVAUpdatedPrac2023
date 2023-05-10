package i_DataStructures;

import java.util.Arrays;
import java.util.List;

public class G_Searches {

	public static void main(String[] args) {
	
		//**********linear search**********
		List<Integer> arr1 = Arrays.asList(3,5,7,1,2,8,0,9,4);
	
		int index = linearSearch(arr1,2);
		if(index == -1) {
			System.out.println("element not found");
		}
		else {
			System.out.println("found element at index : " + index);
		}
		
		//**********inbuilt binary search**********
		
		int[] arr2 = new int[10_00_000];
		for(int i=0;i<1000000;i++) {
			arr2[i] = i;
		}
		int indexBin1 = Arrays.binarySearch(arr2, 52);
		if(indexBin1<-1) {
			System.out.println("value not found");
		}
		else {
			System.out.println("using inbuild binary search : " + indexBin1);
		}
		
		//**********binary search**********
		int indexBin2 = binaraySearch(arr2,2); //array needs to be sorted
		
		if(indexBin2<-1) {
			System.out.println("value not found");
		}
		else {
			System.out.println("using inbuild binary search : " + indexBin2);
		}
		
		//**********recursion binary search**********
		int indexBin3 = binarySearchUsingRecusrsion(arr2,0,arr2.length-1,8_77_756); //array needs to be sorted
		
		if(indexBin3<-1) {
			System.out.println("value not found");
		}
		else {
			System.out.println("using recursion binary search : " + indexBin3);
		}
		
		//**********interpolation search**********
		
		/* O(log(log n)) : for uniformally distributed data
		 * imporovement over binary search
		 * we will guess the value based on calculated probe results, if guess is incorrect, we narrow search area
		 * 
		 * worst case : o(n) : in case the values increase exponentially : 1,2,4,8,16,32,64...
		 */
		

		int[] arr4 = new int[700];
		for(int i = 0; i< 100 ; i++) {
			arr4[i] = i*i*i;
		}
		for(int i= 100; i<200; i++) {
			arr4[i] = i/3;
		}
		for(int i = 200; i<300;i++) {
			arr4[i] = i*2;
		}
		for(int i= 300; i<400;i++) {
			arr4[i] = i+37;
		}
		for(int i= 400; i<700; i++) {
			arr4[i] = (i*13+4*i*i)/43+i;
		}
		
		int arr5[] = {1,2,4,8,16,32,64,128,256,512};
		
		int index5 = interpolationSearch(arr5, 256);
		
		if(index5 == -1) {
			System.out.println("not found");
		}else {
			System.out.println("using interpolation element found at : " + index5);
		}
	}

	private static int interpolationSearch(int[] arr, int value) {
		int high = arr.length -1;
		int low = 0;
		
		while(value >= arr[low] && value <= arr[high] && low <= high) {
			//probe is the guess value
//			System.out.println("low high value arr[low] arr[high] :" + low + " " + high + " " + value + " " + arr[low] + " " + arr[high]);
//			System.out.println(" (high - low) " + (high - low) + " (value - arr[low]) " + (value - arr[low]) + " (arr[high] - arr[low]) " + (arr[high] - arr[low]));
//			System.out.println(" (value - arr[low]) / (arr[high] - arr[low])"  +  (value - arr[low]) / (arr[high] - arr[low]));
			int probe = low + (high - low) * (value - arr[low]) / (arr[high] - arr[low]);
			System.out.println("probe : " + probe);
			
			if (arr[probe] == value) {
				return probe;
			} else if(arr[probe] > value) {
				high = probe -1;
			}else {
				low = probe +1;
			}
		}
		
		return -1;
	}

	private static int binaraySearch(int[] arr, int value) {
		//O(log n)
		//sort array
		//check if target value is equal to middle value, if yes return middle index
		//if not, check if target value is lesser or more than the middle value => disregard that half accordingly
		
		int low = 0;
		int high = arr.length-1;
		
		while(low<=high) {
		int mid = (low+(high-low))/2;
		
		if(arr[mid] < value) {
			low = mid+1;
		}
		else if(arr[mid] > value) {
			high = mid-1;
		}
		else {
			return mid;
		}
		}
		
		return -1;
	}

	private static int binarySearchUsingRecusrsion(int[] arr, int low, int high, int value) {
		int mid = (low + high)/2;

		System.out.print("low : " + low + " high :" + high + " mid : " + mid + " value : " + value + "  => ");
		
		if(low == high) {
			return -1;
		}
		if(arr[mid] == value) {
			System.out.println("mid is equal to value");
			return mid;
		}
		else if(value < arr[mid]) {
			System.out.println("value is less than mid");
			high = mid-1;
			return binarySearchUsingRecusrsion(arr, low, high, value);
		}else if(value > arr[mid]) {
			System.out.println("value is greater than mid");
			low = mid+1;
			return binarySearchUsingRecusrsion(arr, low, high, value);
		}else {
			return -1;
		}
	}
	
	
	private static int linearSearch(List<Integer> arr1, int value) {
		for(int i=0;i<=arr1.size();i++) {
			if(value==arr1.get(i)) {
				return i;
			}
		}
		return -1;
	}

}
