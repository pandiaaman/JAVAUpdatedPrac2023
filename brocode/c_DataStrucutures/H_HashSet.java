package c_DataStrucutures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class H_HashSet {
	public static void main (String[] args) {
		Set<Integer> hashSet = new HashSet<Integer>();
		
		
		
		hashSet.add(2);
		hashSet.add(3);
		hashSet.add(2); //doesnt restrict you but do not allow duplicates
		hashSet.add(null); //allows null values to be added
		hashSet.add(6);
		hashSet.add(1);
		hashSet.add(4);
		hashSet.add(15); //maintains order
		hashSet.add(-5);
		hashSet.add(5);
		hashSet.add(9);
		
		System.out.println(hashSet);
		
		
		hashSet.remove(5);
		
		Iterator<Integer> hashSetItr = hashSet.iterator();
		while(hashSetItr.hasNext()) {
			System.out.print(hashSetItr.next() + " ");
		}
		
		System.out.println();
		
		for(Integer i : hashSet) {
			System.out.println(i);
		}
		
		//creating hashsets using addAll from arrays
		HashSet<Integer> hs1 = new HashSet<Integer>();	
		Integer[] ar1 = new Integer[] {1,5,2,3,7,8,4,6,7,9};	
		hs1.addAll(Arrays.asList(ar1));
		
		System.out.println(hs1);
		
		HashSet<Integer> hs2 = new HashSet<Integer>();
		Integer[] ar2 = new Integer[] {1,2,3,8,12,44,0};
		hs2.addAll(Arrays.asList(ar2));
		
		System.out.println(hs2);
		
		//doing set operations:
		//union : using addAll
		HashSet<Integer> unionHS = new HashSet<Integer>(hs1); //contains the hs1 hashset
		unionHS.addAll(hs2);
		System.out.println(unionHS);
 		
		//intersection : retainAll
		HashSet<Integer> intersectHS = new HashSet<Integer>(hs1);
		intersectHS.retainAll(hs2);
		System.out.println(intersectHS);
		
		//finding symmetric difference
		HashSet<Integer> diffHS = new HashSet<Integer>(hs1);
		diffHS.removeAll(hs2);
		System.out.println(diffHS);
		
		System.out.println();
		/******************************************/
		/******************************************/
			  /*******  HASHTABLE ********/
		/******************************************/
		/******************************************/
		
		//hashtable was introduced in java 1.0 before any other collection framework
		/*
		 * it is used to define key value pair of the data structure
		 * it was defined before the map interface and does not provide full range of applications
		 * it is now obsolete and is discouraged to use because of the map interface
		 * it has poor performance
		 * 
		 * however,
		 * it is thread safe and simple to use
		 */
		Hashtable<Integer,String> hashTable = new Hashtable<Integer,String>();
		hashTable.put(1, "one");
		hashTable.put(2, "two");
		hashTable.put(3, "three");
		
		System.out.println(hashTable.get(2));
		
		hashTable.remove(3);
		
		//using keys enumeration in hashtable
		Enumeration<Integer> keys = hashTable.keys();
		while(keys.hasMoreElements()) {
			Integer key = keys.nextElement();
			System.out.println("key : " + key + " value : " + hashTable.get(key));
		}
		
		//using elements enumeration in hashtable
		Enumeration<String> elements = hashTable.elements();
		while(elements.hasMoreElements()) {
			String element = elements.nextElement();
			System.out.println(" value : " + element);
		}
		
		
		Hashtable<Integer, String> ht1 = new Hashtable<>(4, 0.75f); //4 is the capacity and 0.75f is the load factor
		ht1.putAll(hashTable);
		
		System.out.println(ht1.containsKey(1));
		System.out.println(ht1.containsValue("three")); //removed three	
		
		//getting the setView of the hashtable
		
		
		//understanding Arrays.asList
		Integer[] intArr = new Integer[] {1,2,3,4,5,6,7};
		List<Integer> arrList = Arrays.asList(intArr);
		
		
		System.out.println(arrList.get(1));
		
	}
}
