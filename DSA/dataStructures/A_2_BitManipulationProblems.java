package dataStructures;

import java.util.Arrays;

public class A_2_BitManipulationProblems {

	
	    public static int countTotalSetBitsFrom1ToA(int A) {
	        int count=0;
	        for(int i=1;i<=A;i++){
	        	int n = i;
	            while(n!=0){
	                n = n&(n-1);
	                count++;
	            }
	        }
	        return count;
	    }
	    
	    public static int nonRepeatingForEveryElementTwice(int[] arr) {
	    	//if we XOR 5 with 5 then we get 0, so if we xor every element in the array with each other, last remaining value will be the solution
	    	if(arr.length < 2) {
	    		return -1;
	    	}
	    	
	    	int value = arr[0];
	    	for(int i=1;i<arr.length;i++) {
	    		value = value^arr[i];
	    	}
	    	return value;
	    }
	    
	    public static int nonRepeatingForEveryElementThrice(int[] arr, int k) {
	    	int[] countArray = new int[32];
	    	System.out.println(Arrays.toString(countArray));
	    	for(int i : arr) {
	    		int count = 0;
	    		while(i!=0) {
	    			if((i&1)==1) {
	    				countArray[count]++;
	    			}
	    			i>>=1;
	    			count++;
	    		}
	    	}
	    	
	    	System.out.println(Arrays.toString(countArray));
	    	
	    	for(int count : countArray) {
	    		count %= k;
	    	}
	    	
	    	int res = 0;
	    	for(int i=0;i<32;i++) {
	    		res = (int) (res + (countArray[i]*(Math.pow(2, i))));
	    	}
	    	
	    	return res;
	    }
	
	public static void main(String[] args) {
		
		System.out.println("no of bits in 15 " + (int)(Math.log(15)+1));
		
		int ans = countTotalSetBitsFrom1ToA(100);
		System.out.println(ans);
		
		
		//find only non repeating element in the array where every element is repeating twice
		int[] arr1 = new int[] {5,1,4,1,3,5,4,7,7};
		int ans2 = nonRepeatingForEveryElementTwice(arr1);
		System.out.println(ans2);
		
		//find only non repeating element in the array where every element is repeating thrice or k times
		int[] arr2 = new int[] {2,4,6,7,4,3,2,6,7,2,4,6,7};
		arr2= new int[] {2,2,1,1,5,1,1,2};
		int ans3 = nonRepeatingForEveryElementThrice(arr2, 3);
		System.out.println(ans3);
		
	}
}
