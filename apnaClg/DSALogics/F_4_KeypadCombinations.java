package DSALogics;

import java.util.HashMap;
import java.util.Map;

public class F_4_KeypadCombinations {
	
	/*
	 * given an old phone with each key mapped to a set of characters, we need to find the 
	 * all possible combinations when given keys are pressed
	 *  time complexity : O(4^n) : since the max possible characters related to a string are pqrs so 4
	 *  hence if one presses 6 n times : then we get 4*4*4*4...n : 4^n
	 */

	public static void findAllMappings(String input, int indexOne, int indexTwo, String mappings, Map<Integer, String> keyMap) {
		
		if(indexOne == input.length()) {
			System.out.println(mappings);
			return;
		}
		
		int currentKeypadNo = Integer.parseInt(input.substring(indexOne, indexTwo));
		
		String mappingForKey = keyMap.get(currentKeypadNo);
		
		for(int i=0;i<mappingForKey.length();i++) {
			char mappedAlphabet = mappingForKey.charAt(i);
			
			//adding the keypad combination
			findAllMappings(input,indexOne+1,indexTwo+1,mappings+mappedAlphabet,keyMap);
		}
	
	}
	
	public static void main(String[] args) {
		
		Map<Integer, String> keyMap = new HashMap<Integer, String>();
		keyMap.put(1, "abc");
		keyMap.put(2, "def");
		keyMap.put(3, "ghi");
		keyMap.put(4, "jkl");
		keyMap.put(5, "mno");
		keyMap.put(6, "pqrs");
		keyMap.put(7, "tu");
		keyMap.put(8, "vwx");
		keyMap.put(9, "yz");
		keyMap.put(0, ".");
//		String keypadCombinataions()
		
//		int currentKeypadNo = Integer.parseInt("23".substring(1,2));
//		System.out.println(currentKeypadNo);
		
		String input = "231";
		
		System.out.println("using map");
		findAllMappings(input,0,1,"",keyMap);
		
		System.out.println("using static array of strings");
		//other way of finding mapping using array
		findAllMappingsUsingArray(input, 0, "");
	}
	
	public static String[] keyMappings = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	
	public static void findAllMappingsUsingArray(String input, int index, String mappings) {
		//base case
		if(index == input.length()) {
			System.out.println(mappings);
			return;
		}
		
		char currentKey = input.charAt(index);
		
		String keyMapping = keyMappings[currentKey - '0']; //'2' - '0' : 2
		
		for(int i=0;i<keyMapping.length();i++) {
			findAllMappingsUsingArray(input, index+1, mappings+keyMapping.charAt(i));
		}
		
		
		
	}

}
