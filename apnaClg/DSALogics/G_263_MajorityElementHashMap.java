package DSALogics;

import java.util.HashMap;
import java.util.Map;

public class G_263_MajorityElementHashMap {

	public static void findMajority(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int limit = arr.length/3;
		System.out.println("limit "+limit);
		for(int i : arr) {
			if(map.containsKey(i)) {
				map.put(i, (map.get(i))+1);
			}
			else {
				map.put(i, 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//			System.out.print(entry.getKey() + " " + entry.getValue());
//			System.out.println();
			if(entry.getValue() > limit) {
				System.out.println("value is " + entry.getKey());
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,3,2,5,1,3,1,5,1,2,3,1,1,2,2,2,2};

		findMajority(nums);
	}

}
