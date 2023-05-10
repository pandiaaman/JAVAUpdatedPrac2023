package c_DataStrucutures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class G_DynamicArray {

	/*
	 * since this is the array implementation:
	 * 		accessing element at a given location is O(1)
	 * 		searching for an element needs traversal which is O(n)
	 * 		inserting and deleting an element again needs traversal which is O(n)
	 * 		if the size has reached the capacity of the array, then we for insertion we need to copy all elements to new array
	 */
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.add(2);
		arrList.add(5);
		arrList.add(8);
		arrList.add(1);
		arrList.add(10);
		
		System.out.println(arrList);
		Object[] toArr = arrList.toArray();
		Integer arr[] = new Integer[arrList.size()];
		arr = arrList.toArray(arr); //calls Arrays.copyOf(elements[], size)
		
		arrList.remove(2); //indexing is 0 based
		
		System.out.println(arrList);
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> arrListClone = (ArrayList<Integer>) arrList.clone();
		
		System.out.println(arrList.equals(arrListClone));
		System.out.println(arrList == arrListClone); //== checks the object addresses
		
		arrListClone.add(4);
		System.out.println(arrListClone);
		
		arrList.forEach(x -> System.out.println(x*2));
		
		int val = arrList.get(1);
		System.out.println(val);
		
		boolean contains5 = arrList.contains(5);
		System.out.println(contains5);
		
		System.out.println(arrList.equals(arrListClone));
		
		Iterator<Integer> itr = arrList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		ArrayList<Integer> arrStream = (ArrayList<Integer>) arrList.stream().map(x-> x+2).filter(x-> x%2==0).collect(Collectors.toList());
		arrStream.forEach(x-> System.out.print(x + " "));
		System.out.println();
		int sum1 = (int) arrList.stream().map(x-> x+2).filter(x-> x%2==0).reduce(0,(a,b) -> a+b);
		System.out.println(sum1);

		
	}

}
