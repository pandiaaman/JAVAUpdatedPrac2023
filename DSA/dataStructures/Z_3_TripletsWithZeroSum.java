package dataStructures;

public class Z_3_TripletsWithZeroSum {

	public static int[] createPrefixArray(int[] arr) {
		int[] prefixArr = new int[arr.length];
		prefixArr[0] = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			prefixArr[i] = prefixArr[i-1] + arr[i];
		}
		
		return prefixArr;
	}
	
	public static void main(String[] args) {
		int arr[] = new int[] {0,-1,2,-3,1};
		
		int[] prefixarr = createPrefixArray(arr);
		for(int i : prefixarr) {
			System.out.print(i+" ");
		}
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			int val = arr[i];
			for(int j=0;j<prefixarr.length;j++) {
				if(prefixarr[j] == (-val) && i!=j) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
