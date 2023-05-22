package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapComparator {

	private static int counter = 0;
	
	public TreeMapComparator() {
		// TODO Auto-generated constructor stub
		counter = 220;
	}
	public static void main(String... args) {
		// TODO Auto-generated method stub

		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		
		TreeMap<Integer, String> tmap1 = new TreeMap<Integer, String>(Collections.reverseOrder());
		
		TreeMap<Integer, String> tmap2 = new TreeMap<Integer, String>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2-i1;
			}
		});
		
		//treemap is always sorted based on keys
		
		tmap.put(7, "hello");
		tmap.put(1, "wow");
		tmap.put(3, "well");
		tmap.put(9, "okay"); //gets overridens
		tmap.put(9, "asdf");
		
		System.out.println(tmap);
		
		for(Map.Entry<Integer, String> e : tmap.entrySet()) {
			System.out.println("key : " + e.getKey() + " -> value : " + e.getValue());
		}
		
		
		//checking the collections framework frequency method
		List<Integer> list = new ArrayList<Integer>();
		
		Integer[] arr = new Integer[] {1,2,4,6,3,4,1,4,7,5};
		list = Arrays.asList(arr);
		
		System.out.println(list);
		
		System.out.println(Collections.frequency(list, 4));
		
		
		System.out.println(0.1d / 0.0d);
		
		TreeMapComparator obj = new TreeMapComparator();
		System.out.println(obj.counter);
		
	}

}
