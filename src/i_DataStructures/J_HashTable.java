package i_DataStructures;

import java.util.Hashtable;

public class J_HashTable {

	public static void main(String[] args) {
		
		Hashtable<Integer, String> studTable = new Hashtable<Integer, String>(10,0.75f); //not changing the load factor 
		//by default has capacity of 11 elements and load factor of 0.75
		//once 75% of this hashtable is filled, the hashtable will dynamically increase
		//uses hashcode of keys to store the values in the table
		
		//hash of key is same as key in case of an integer key
		//hash of key is calculated differently if the key is string
		
		//stores the unique keys
		//does not store the order
		//better for large data sets
		
		
		//values get stored in the table by doing %10 (i.e the initial capacity) of the key
		//key.hashcode() % capacity
				//eg, if key is 2345 then the value associated to this key is stored in index 5 of the table
				// now suppose there is a collision, then hashtable will store these values in linked list format in that index
				
				//less collisions => more efficiency
		
		//run time complexity : (if no collisions) => O(1) : best
		//worst case : O(n)
		
		
		
		//to put
		studTable.put(111, "Aman");
		studTable.put(123, "Vaibhav");
		studTable.put(154, "Anisha");
		studTable.put(456, "kajal");
		studTable.put(267, "Sanchit");
		studTable.put(777, "Ayaz");
		studTable.put(100, "Sourav");
		
		studTable.put(100, "Ajay"); //if duplicate key, then last value will be overriden
		
		//to get
		String getStud = studTable.get(456);
		System.out.println(getStud);
		
		//to remove
		studTable.remove(123);
		
		
		//for loop
		for(Integer key : studTable.keySet()) {
			System.out.println(key + " => \t " + studTable.get(key));
		}
		
		//hashcodes
		System.out.println("hashcode and keys for table : (key is integer)");
		for(Integer key : studTable.keySet()) {
			System.out.println(key.hashCode() + " => \t " + key + " => \t" + studTable.get(key));
		}
		
		
		Hashtable<String, String> studTableStr = new Hashtable<String, String>(10,0.75f);
		
		studTableStr.put("111", "Aman");
		studTableStr.put("123", "Vaibhav");
		studTableStr.put("154", "Anisha");
		studTableStr.put("456", "kajal");
		studTableStr.put("267", "Sanchit");
		studTableStr.put("777", "Ayaz");
		studTableStr.put("100", "Sourav");
		//hashcodes
		System.out.println("hashcode and keys for table : (key is string)");
			for(String key : studTableStr.keySet()) {
				System.out.println(key.hashCode() + " => \t " + key + " => \t" + studTableStr.get(key));
			}
		
		
	}

}
