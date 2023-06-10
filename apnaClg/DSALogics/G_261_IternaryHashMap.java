package DSALogics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class G_261_IternaryHashMap {

	public static void iternary(HashMap<String, String> tickets) {
		HashSet<String> fromSet = new HashSet<String>();
		HashSet<String> toSet = new HashSet<String>();
		
		for(Map.Entry<String, String> e : tickets.entrySet()) {
			fromSet.add(e.getKey());
			toSet.add(e.getValue());
		}
		
		System.out.println(fromSet);
		System.out.println(toSet);
		
		String startCity = "";
		
		for(String str : fromSet) {
			if(!toSet.contains(str)) {
				startCity = str;
			}
		}
		
		System.out.println(startCity);
		
		for(int i = 0; i < tickets.size(); i++) {
			if(!tickets.keySet().contains(startCity)) {
				break;
			}
			
			System.out.println(startCity + " -> " + tickets.get(startCity));
			startCity = tickets.get(startCity);
		}
	}
	
	public static void main(String[] args) {
		HashMap<String, String> tickets = new HashMap<String, String>();
		
		tickets.put("Chennai", "Bengaluru");
		tickets.put("Mumbai", "Delhi");
		tickets.put("Goa", "Chennai");
		tickets.put("Delhi", "Goa");
		
		iternary(tickets);
		
	}
}
