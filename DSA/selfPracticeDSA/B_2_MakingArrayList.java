package selfPracticeDSA;

import java.util.Arrays;

class MyArrayList{
	
	private int[] arr;
	
	private int size;
	
	public MyArrayList() {
		arr = new int[11];
		size = 0;
	}
	
	public int get(int index) {
		
		if(index<0 || index>this.size) {
			return -1;
		}
		return this.arr[index];
	}
	
	public void add(int val) {
		
		if(this.size > (this.arr.length)/2) {
			grow();
		}
		
		this.arr[this.size] = val;
		this.size++;
	}
	
	private void grow() {
		int currentTotalSize = this.arr.length;
		int newSize = 2*currentTotalSize;
		
		int[] newArr = new int[newSize];
		
		for(int i=0;i<this.arr.length;i++) {
			newArr[i] = this.arr[i];
		}
		
		this.arr = newArr;
	}
	
	public void removeAt(int index) {
		if(index > this.size-1) {
			throw new IndexOutOfBoundsException("attempt to remove the index out of the array length");
		}
		
		if(this.size < (this.arr.length)/3) {
			shrink();
			
		}
		
		for(int i=index;i<=this.size;i++) {
			arr[i] = arr[i+1];
		}
		this.size--;
	}
	
	private void shrink() {
		int currentLength = this.arr.length;
		int newLength = currentLength/2;
		
		int[] newArr = new int[newLength];
		for(int i=0;i<this.arr.length;i++) {
			newArr[i] = this.arr[i];
		}
	}
	
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.arr);
	}
	
	public int indexOf(int val) {
		int index = -1;
		if(this.size == 1 && this.arr[0] == val) {
			return 0;
		}else {
			int[] arrSorted = this.arr;
			quickSort(arrSorted, 0, this.size);
			index = this.binarySearch(arrSorted, 0 , this.size, val);
		}
		return index;
	}
	
	private void quickSort(int[] arr, int low, int high) {
		
		//base case
		if(low>=high) {
			return;
		}
		
		int pivotIndex = partition(arr, low, high);
		
		quickSort(arr, low, pivotIndex-1);
		quickSort(arr, pivotIndex+1, high);
	}
	
	private int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		
		int i = low-1;
		
		for(int j=0;j<high;j++) {
			if(arr[j] < pivot) {
				i++;
				arr[j] = arr[i] + arr[j] - (arr[i] = arr[j]);
			}
		}
		i++;
		int temp = arr[i];
		arr[i] = pivot;
		arr[high] = temp;
		
		return i;
	}
	
	private int binarySearch(int[] arr, int low, int high, int target) {
		
		int mid = low + (high-low)/2;
		
		//base case
		if(low>=high) {
			return -1;
		}
		
		if(target < arr[mid]) {
			high = mid-1;
		}else if(target > arr[mid]) {
			low = mid+1;
		}else {
			return mid;
		}
		
		return binarySearch(arr, low, mid, target);
	}
}


public class B_2_MakingArrayList {

	public static void main(String[] args) {
		System.out.println("hello there");
		
		MyArrayList list = new MyArrayList();
		
		System.out.println(list.isEmpty());
		
		System.out.println(list.size());
		
		list.add(4);
		list.add(2);
		list.add(7);
		System.out.println(list.size());
		System.out.println(list);
		
		list.add(5);
		list.add(9);
		list.add(1);
		System.out.println(list.size());
		System.out.println(list);
		
		list.add(4);
		list.add(8);
		list.add(6);
		list.add(11);
		System.out.println(list.size());
		System.out.println(list);
		
		list.removeAt(9);
		System.out.println(list.size());
		System.out.println(list);
		
		list.removeAt(0);
		list.removeAt(0);
		list.removeAt(0);
		list.removeAt(0);
//		list.removeAt(0);
//		list.removeAt(0);

		
		System.out.println(list.size());
		System.out.println(list);
	}
}
