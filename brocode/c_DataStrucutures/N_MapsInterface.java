package c_DataStrucutures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class N_MapsInterface {

	//implementing Maps using hashMaps
	/*
	 * HashMaps
	 * 
	 * unsynchronized (smiliar to hashTable(which is synchronized))
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> map = new HashMap<>();
	       
        // adding the key-value pairs to map
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        
        
	 /*****************************************/
          //using entrySet in Maps:
        
        for (Map.Entry<Integer, String> entry :map.entrySet())
        {
            Integer key = (Integer)entry.getKey();
            String value = entry.getValue();
 
            System.out.println(key + "=" + value);
        }
        
        //using entrySet with the iterator
        Iterator<Map.Entry<Integer, String> > itr = map.entrySet().iterator();
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        
        //using entrySet with Stream.of method
        Stream.of(map.entrySet().toArray()).forEach(System.out::println);
        
        
        
        /***************************************/
        	//using KeySet in maps
        
        Iterator<Integer> itrKey = map.keySet().iterator();
        
        while (itrKey.hasNext())
        {
            System.out.print(itrKey.next() + " ");
        }
        System.out.println();
        
        
        /*************************************/
        	//other operations
        
        System.out.println("size of the map is : " + map.size());
        
        System.out.println("value of 2 :" + map.get(2));
        
        if(map.containsKey(1)) {
        	String val = map.get(1);
        	System.out.println(val);
        }
        
       //changing elements
       map.put(2, "dwitiya");
       System.out.println(map);
        
        
        map.forEach((key,value)->{
        	System.out.println("key:" + key + " -> value: " + value);
        });
        
        
        
	}

}
