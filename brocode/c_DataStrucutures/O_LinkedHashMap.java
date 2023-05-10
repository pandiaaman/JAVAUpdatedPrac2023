package c_DataStrucutures;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * A LinkedHashMap contains values based on the key.
 * It contains only unique elements.
 * It may have one null key and multiple null values.
 * It is non-synchronized.
 * 
 * It is the same as HashMap with an additional feature that it maintains insertion order. 
 * 
 */
public class O_LinkedHashMap {

	public static void main(String[] args) {
		LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<String,Integer>();
	
		linkedMap.put("aman", 84);
		linkedMap.put("anisha", 88);
		linkedMap.put("ayaz", 80);
		
		System.out.println(linkedMap);
		
		for(Map.Entry<String, Integer> entry : linkedMap.entrySet()) {
			String name = (String) entry.getKey();
			int marks = (int) entry.getValue();
			
			System.out.println("name : " + name + " got " + marks );
		}
		
		linkedMap.put("aarif", 66);
		linkedMap.put("amit", 99);
		
		boolean containsAman = linkedMap.containsKey("aman");
		System.out.println(containsAman);
		
		boolean isEmptyMap = linkedMap.isEmpty();
		System.out.println(isEmptyMap);
		
		
	}
}
