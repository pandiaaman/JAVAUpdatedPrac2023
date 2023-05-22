package DSALogics;

public class B_43_QuickSort {

	public static int partition(int[] arr, int low, int high) {
		
		int pivot  = arr[high];
		
		int i = low - 1; //i shows the no of elements that are smaller then pivot, using this we can know the pivot index
		
		for(int j = low; j < high; j++) {
			if(arr[j] < pivot) {
				i++; //we need a space to insert a value smaller then pivot
				//swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i++;
		//after loop ends, we need to insert thepivot value in place of i
		int temp = arr[i];
		arr[i] = pivot;
		arr[high] = temp;
		
		return i;
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int pivotIndex = partition(arr, low, high);
			
			quickSort(arr, low, pivotIndex-1);
			quickSort(arr, pivotIndex+1, high);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,4,5,1,7,3,6,9,8,14};
		
		quickSort(arr,0,arr.length-1);
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
