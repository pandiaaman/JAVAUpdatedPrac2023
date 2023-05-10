package c_DataStrucutures;

import java.util.LinkedHashSet;
import java.util.Set;

public class I_LinkedHashSet {

	public static void main(String[] args) {
		// is an ordered version of HashSet that maintains a doubly-linked List across all elements.
		
		Set<Integer> linkedHS = new LinkedHashSet<Integer>();

		linkedHS.add(3);
		linkedHS.add(2);
		linkedHS.add(5);
		
		System.out.println(linkedHS);
		
		linkedHS.add(2); //no duplicates
		System.out.println(linkedHS);
		
		linkedHS.remove(5);
		System.out.println(linkedHS);
		
		
		
	}

}
