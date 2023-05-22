package DSALogics;

public class B_3_InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * here, we have again a sorted and an unsorted partition in the array
		 * we move the sorted partition from left to right
		 * consider the first element to be in the sorted partition in the beginning
		 * we store the first element in the unsorted index in a variable
		 * we compare the values in the sorted index with this value
		 * all elements in sorted index greater than the value are shifted one position right
		 * then the value is stored to that position
		 * 
		 * cons : lots of shifting of elements
		 * 
		 * O(n^2); stable(the duplicate values preserve the order); in place(no additional variables depending on no of elements)
		 */
		
		int[] arr = new int[] {12,5,-2,33,64,8,2,-5,37,22,-44};
		
		
		int step=0;
		for(int sortedindexpointer = 1; sortedindexpointer<= arr.length-1 ; sortedindexpointer++) {
			
			int value = arr[sortedindexpointer];
			
			for(int i = sortedindexpointer-1; i>=0 ; i--) {
				if(arr[i] > value) {
					arr[i+1] = arr[i];
					arr[i] = value;
				}
				else if(arr[i] <= value) {
					arr[i+1] = value;
					break;
				}
				
			}
			
			//*************printing***********//
			step++;
			System.out.print("on step: " + step + " value is: " + value +  " sorted array is : " );
			for(int a : arr) {
				System.out.print(a +" ");
			}
			System.out.println();
		}
	}

}
