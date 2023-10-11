package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class A_ArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(5);
		list1.add(3);
		list1.add(7);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(2);
		
		for(Integer i : list1) {
			System.out.print(i +  " ");
		}
		
		boolean contains4 = list1.contains(4);
		System.out.println(contains4);
		
		ArrayList<Integer> list2 = (ArrayList<Integer>)list1.clone();
		
		for(Integer i : list2) {
			System.out.print(i +  " ");
		}
		
		
		System.out.println(list1.equals(list2));
		
		int freq5 = Collections.frequency(list1, 5);
		System.out.println(freq5);
		
		list1.forEach(x -> System.out.print(x + " "));
		
		List<Integer> list3 = list1.stream().map(x->x+3).filter(x->x%2==0).collect(Collectors.toList());
		for(Integer i : list3) {
			System.out.println(i);
		}
		
		System.out.println();
		List<Integer> list4 = list1.stream().map(x-> x*2).filter(x->x%3==0).collect(Collectors.toList());
		for(Integer i : list4) {
			System.out.println(i);
		}
		
		int sum = list1.stream().map(x-> x*2).filter(x->x%3==0).reduce(0, (a,b)->a+b);
		System.out.println(sum);
		
		
		System.out.println(list4.isEmpty());
		
		System.out.println(list1.get(4));
		System.out.println(list1.size());
		list1.set(4, 55);
		System.out.println(list1.get(4));
		System.out.println(list1.size());
		
		list1.add(4, 17);
		System.out.println(list1.size());
		for(Integer i : list1) {
			System.out.println(i);
		}
		System.out.println();
		Collections.reverse(list1);
		System.out.println();
		for(Integer i : list1) {
			System.out.println(i);
		}
		
		
		List<String> listst = List.of("asdf","asdfasd","asdft4","asf");
		Iterator<String> itst = listst.iterator();
		while(itst.hasNext()) {
			System.out.println(itst.next());
		}
		
		
	}

}
