package selfPracticeDSA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class B_1_ArrayListCollection {

	public static void main(String[] args) {
		List<Integer> inbuiltList = new ArrayList<Integer>();
		
		inbuiltList.add(2);
		inbuiltList.add(4);
		inbuiltList.add(6);
		inbuiltList.add(1);
		
		System.out.println(inbuiltList);
		
		System.out.println("is the list empty ? : " + inbuiltList.isEmpty());
		
		System.out.println("get value at index 2 : " + inbuiltList.get(2));
		
		System.out.println("index of 6 is : " + inbuiltList.indexOf(6));
		
		System.out.println("if the list contains 4 : " + inbuiltList.contains(4));
		
		//ascending sorting
		inbuiltList.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return (o1-o2) > 0 ? 1 : -1;
			}
			
		});
		
		System.out.println(inbuiltList);
		
		//descending sorting
		inbuiltList.sort((Integer o1, Integer o2)->{
			return (o1-o2) > 0 ? -1 : 1;
		});
		
		System.out.println(inbuiltList);
		
		inbuiltList.remove(2);
		System.out.println(inbuiltList);
		
		inbuiltList.add(2,3);
		System.out.println(inbuiltList);
		
	}
}
