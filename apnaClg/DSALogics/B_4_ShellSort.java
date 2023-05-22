package DSALogics;

public class B_4_ShellSort {

	/*
	 * shell sort is introduced after insertion sort and is named after the scientist who defined it
	 * here if we think, insertion sort takes a lot of time in shifting the values
	 * but in case of almost sorted arrays, insertion sort will not have to do lots of shifting hence will take very less time
	 * shell sort does some preliminary work on insertion sort to make the array as sorted as it can get or to bring the elements closer to the sorted postitions
	 * there is concept of gap in shell sort, which says that we start with higher gap value and go to one, where when gap is one, it is doing insertion sort
	 * this gap value to be used can be calculated using : (3^k -1) where k is the no of elements in the array
	 * we keep decreasing this gap value to one at the end
	 * 
	 * so there is a pre-sorting phase where we compare the elements at a particular gap from each other and do the swaps
	 */
	
	public static void main(String[] args) {
		int[] arr = new int[] {12,5,-2,33,64,8,2,-5,37,22,-44};
	
		//creating a gap generation loop, starting with array length/2 going till 1
		for(int gap = arr.length/2 ; gap>=1; gap/=2) {
			System.out.println("***********for gap: " + gap);
			for(int sortedindexpointer = gap; sortedindexpointer <= arr.length-1; sortedindexpointer++) {
				int value = arr[sortedindexpointer];
				int i;
				for(i=sortedindexpointer; i>=gap && arr[i-gap]>value ;i-=gap) {
					arr[i] = arr[i - gap];
				}
				arr[i] = value;
				for(int k:arr) {System.out.print(k + " ");}
				System.out.println();
			}
			System.out.print("final out for given gap : ");
			for(int i:arr) {System.out.print(i + " ");}
			System.out.println();
		}
		
	}
}
