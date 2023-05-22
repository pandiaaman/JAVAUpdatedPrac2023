package DSALogics;

public class B_3_1_InsertionSort {

	public static void main(String[] args) {
		
		int[] arr = new int[] {12,5,-2,33,64,8,2,-5,37,22,-44};
		
		int step=0;
		
		for(int sortedindexpointer = 1; sortedindexpointer <= arr.length-1; sortedindexpointer++) {
			int value = arr[sortedindexpointer];
			int i;
			for(i=sortedindexpointer-1; i>=0 && arr[i]>value; i--) {
				arr[i+1] = arr[i];
			}
			arr[i+1] = value;
	
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
