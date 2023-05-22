package DSALogics;

public class F_9_SubsetsOfSet {

	public static void subsetsOfSet(int[] arr, int index, String subset) {
		
		if(index == arr.length) {
			System.out.println(subset);
			return;
		}
		
		//adding into subset
		subsetsOfSet(arr,index+1,subset+arr[index]);
		
		//not adding
		subsetsOfSet(arr,index+1,subset);
		
	}
	
	
	public static void main(String[] args) {
		int n = 3;
		int[] arr = new int[n];
		for(int i=0;i<3;i++) {
			arr[i] = i+1;
		}
		subsetsOfSet(arr, 0, "");

	}

}
