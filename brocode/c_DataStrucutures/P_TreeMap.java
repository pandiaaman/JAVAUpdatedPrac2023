package c_DataStrucutures;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
 * The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time
 */
public class P_TreeMap {

	public static void main(String[] args) {

		//#1
		TreeMap<String,Character> treeMap = new TreeMap<String,Character>();
		
		//#2
		//with comparator as input
		TreeMap<String, Character> treeMapRev = new TreeMap<String,Character>(Collections.reverseOrder());
		
		//#3
		TreeMap<String, Character> treeMapComp1 = new TreeMap<String,Character>(new Comparator<String>() {
			//comparing on the basis of length of keys
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}	
		});
		
		//#4
		TreeMap<String, Character> treeMapComp2 = new TreeMap<String, Character>((String s1, String s2)-> s2.length()-s1.length());
		
		/************************************************/
		//operations on #1
		treeMap.put("Aman", 'A');
		treeMap.put("Sanchit", 'C');
		treeMap.put("Anisha" , 'A');
		treeMap.put("Zainab Zaid" , 'A');
		treeMap.put("Ayaz Zargham", 'B');
		treeMap.put("Aysha Khandelwaal" , null);
		treeMap.put("Sumit Gup", 'B');
		treeMap.put("Kunal Yogi", 'C');
		treeMap.put("Anand Singh", 'B');
		
		System.out.println(treeMap); //does not take null values as input in keys and arranges everything by alphabetical order
		
		for(Entry<String, Character> entry : treeMap.entrySet()){
			String key = entry.getKey();
			Character value = entry.getValue();
			System.out.println(key + " got " + value);
		}
		System.out.println("******");
		treeMap.forEach((key, value) -> {
			System.out.println(key + " got " + value);
		});
		
		/************************************************/
		//operations on #2
		treeMapRev.put("Aman", 'A');
		treeMapRev.put("Sanchit", 'C');
		treeMapRev.put("Anisha" , 'A');
		treeMapRev.put("Zainab Zaid" , 'A');
		treeMapRev.put("Ayaz Zargham", 'B');
		treeMapRev.put("Aysha Khandelwaal" , null);
		treeMapRev.put("Sumit Gup", 'B');
		treeMapRev.put("Kunal Yogi", 'C');
		treeMapRev.put("Anand Singh", 'B');
		
		System.out.println(treeMapRev); //does not take null values as input in keys and arranges everything by alphabetical order
		
		for(Entry<String, Character> entry : treeMapRev.entrySet()){
			String key = entry.getKey();
			Character value = entry.getValue();
			System.out.println(key + " got " + value);
		}
		System.out.println("******");
		treeMapRev.forEach((key, value) -> {
			System.out.println(key + " got " + value);
		});
		
		
		/************************************************/
		//operations on #3
		treeMapComp1.put("Aman", 'A');
		treeMapComp1.put("Sanchit", 'C');
		treeMapComp1.put("Anisha" , 'A');
		treeMapComp1.put("Zainab Zaid" , 'A');
		treeMapComp1.put("Ayaz Zargham", 'B');
		treeMapComp1.put("Aysha Khandelwaal" , null);
		treeMapComp1.put("Sumit Gup", 'B');
		treeMapComp1.put("Kunal Yogi", 'C');
		treeMapComp1.put("Anand Singh", 'B');
		
		System.out.println(treeMapComp1); //does not take null values as input in keys and arranges everything by alphabetical order
		
		for(Entry<String, Character> entry : treeMapComp1.entrySet()){
			String key = entry.getKey();
			Character value = entry.getValue();
			System.out.println(key + " got " + value);
		}
		System.out.println("******");
		treeMapComp1.forEach((key, value) -> {
			System.out.println(key + " got " + value);
		});
		
		
		/************************************************/
		//operations on #4
		treeMapComp2.put("Aman", 'A');
		treeMapComp2.put("Sanchit", 'C');
		treeMapComp2.put("Anisha" , 'A');
		treeMapComp2.put("Zainab Zaid" , 'A');
		treeMapComp2.put("Ayaz Zargham", 'B');
		treeMapComp2.put("Aysha Khandelwaal" , null);
		treeMapComp2.put("Sumit Gup", 'B');
		treeMapComp2.put("Kunal Yogi", 'C');
		treeMapComp2.put("Anand Singh", 'B');
		
		System.out.println(treeMapComp2); //does not take null values as input in keys and arranges everything by alphabetical order
		
		for(Entry<String, Character> entry : treeMapComp2.entrySet()){
			String key = entry.getKey();
			Character value = entry.getValue();
			System.out.println(key + " got " + value);
		}
		System.out.println("******");
		treeMapComp2.forEach((key, value) -> {
			System.out.println(key + " got " + value);
		});
		
	}
}
