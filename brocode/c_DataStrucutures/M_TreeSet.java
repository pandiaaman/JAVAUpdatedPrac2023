package c_DataStrucutures;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class M_TreeSet {

	// implementation of the SortedSet Interface and SortedSet extends Set Interface.
	// 
	/*
	 * 
	 * TreeSet uses tree data structure for storage.
	 * Objects are stored in sorted, ascending order. But we can iterate in descending order using the method TreeSet.descendingIterator()
	 * Access and retrieval times are very fast which make TreeSet an excellent choice for storage of large volume of data in sorted format.
	 * TreeSet doesn’t use hashCode() and equals() methods to compare it’s elements. It uses compare() (or compareTo()) method to determine the equality of two elements.
	 * 
	 */
	//automatically sorts the data in the set
	
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		
		treeSet.add(5);
		treeSet.add(2);
		treeSet.add(7);
		treeSet.add(1);
		treeSet.add(6);
		
		System.out.println(treeSet); //sorts the values
		
		// as its a set, does not allow any duplicates
		treeSet.add(5);
		
		System.out.println(treeSet);
		
		treeSet.remove(5);
		System.out.println(treeSet);
		
		
		//iterating asscending
		Iterator<Integer> ascItr = treeSet.iterator();
		while(ascItr.hasNext()) {
			System.out.print(ascItr.next() + " ");
		}
		System.out.println();
		//iterating descending
		Iterator<Integer> descItr = treeSet.descendingIterator();
		while(descItr.hasNext()) {
			System.out.print(descItr.next() + " ");
		}
		
		
		treeSet.add(9);
		treeSet.add(8);
		treeSet.add(3);
		
		System.out.println(treeSet);
		
		System.out.println(treeSet.subSet(3, 8));
		
	}
}
