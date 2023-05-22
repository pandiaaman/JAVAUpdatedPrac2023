package DSALogics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class B_11_BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] {1,9,3,5,7,2,4,6,8};
//		bubbleSort(arr);
//		selectionSort(arr);
		insertionSort(arr);
	}

	public static void bubbleSort(int[] arr) {
		for(int i=arr.length-1;i>=0;i--) { //sorted pointer beginning at the end and moving to start
			for(int j=0;j<i;j++) {
				if(arr[j] > arr[j+1]) {
//					a = (a+b)-(b=a)
					arr[j] = (arr[j] + arr[j+1]) - (arr[j+1] = arr[j]);
				}
			}
		}
		List<Integer> arrlist = Arrays.stream(arr).boxed().collect(Collectors.toList());
		arrlist.stream().forEach(System.out::print);
		
	}
	
	public static void selectionSort(int[] arr) {
		
		for(int sortedPartition = arr.length-1; sortedPartition >=0; sortedPartition--) {
			int maxIndex = 0;
			for(int i=0; i<=sortedPartition;i++) {
				if(arr[i]>arr[maxIndex]) {
					maxIndex = i;
				}
				arr[sortedPartition] = (arr[sortedPartition] + arr[maxIndex]) - (arr[maxIndex] = arr[sortedPartition]);
			}
		}
		
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	}
	
	public static void insertionSort(int[] arr) {
		//sorting left to right
		for(int sortedIndex = 1; sortedIndex <= arr.length-1 ; sortedIndex++) {
			int toCompare = arr[sortedIndex];
			int i;
			for(i=sortedIndex-1;i>=0;i--) {
				if(toCompare<arr[i]) {
					arr[i+1] = arr[i];
				}
				else if(toCompare>=arr[i]) {
					arr[i+1] = toCompare;
					break;
				}
			}
//			arr[i+1] = toCompare;
			
		}
		Arrays.stream(arr).forEach(x->System.out.print(x + " "));
	}
	
	
}
