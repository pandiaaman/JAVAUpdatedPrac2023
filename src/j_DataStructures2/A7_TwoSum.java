package j_DataStructures2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class A7_TwoSum {

	public static void main(String[] args) {
		
		int[] nums = new int[] {2,4,7,8,34,1,5};
		
		int[] result = twoSumMethodOne(nums,7);
		
		for(int i : result) {
			System.out.println(i);
		}
		
		twoSumMethodTwo(nums,7);
	}
	
	public static int[] twoSumMethodOne(int[] nums, int target) {
        int[] result = new int[2];

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
	
	public static void twoSumMethodTwo(int[] nums, int target) {
		
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		
		int k = 0;
		for(int i : nums) {
			map.put(i, k++);
		}
		
		System.out.println(map);
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			int required = target-entry.getKey();
			System.out.println(required + " when value : " + entry.getKey());
			
			if(map.containsValue(required)) {
				int otherKey = map.get(required);
				System.out.println(otherKey + " " + entry.getValue());
				return;
			}
			
		}
		System.out.println("no combination present");
		
	}
	
}
