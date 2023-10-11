package lcwdDataStructures;

import java.util.*;
import java.util.stream.Collectors;

public class A_PracPring {

	public static void main(String[] args) {
		System.out.println("asd");
		
		List<Integer> arraylist = new ArrayList<Integer>();
		
			arraylist.add(2);
			arraylist.add(3);
			arraylist.add(1);
			arraylist.add(5);
			arraylist.add(4);
			
		//first way of iterating : iterable : foreach
			System.out.println("for each loop for iteration");
			for(Integer i : arraylist) {
				System.out.print(i + " ");
			}
			System.out.println();
			
		//second way : iterator
			System.out.println("iterator for iteration");
			Iterator<Integer> itrarraylist = arraylist.iterator();
			while(itrarraylist.hasNext()) {
				System.out.print(itrarraylist.next() + " ");
			}
			System.out.println();
			
		//third way
			System.out.println("foreach method for iteration");
			arraylist.forEach(x -> {x = x*3;});
			arraylist.forEach(x -> {System.out.print(x + " ");});
			System.out.println();
			
		//fourth way : backward iteration
			System.out.println("listiterator for backward iteration");
			ListIterator<Integer> listitrarraylist = arraylist.listIterator(arraylist.size());
			while(listitrarraylist.hasPrevious()) {
				System.out.print(listitrarraylist.previous() + " ");
			}
			System.out.println();
			
		//sorting the list
			System.out.println("collections.sort to sort");
			Collections.sort(arraylist,new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					
					return o1 - o2;
				}
				
			});
			
			for(Integer i : arraylist) {
				System.out.print(i + " ");
			}
			System.out.println();
			
		//sorting in reverse order
			System.out.println("using collections.reverseorder to arrange in reverse order");
			Collections.sort(arraylist, Collections.reverseOrder());
			arraylist.forEach(x -> {System.out.print(x + " ");});
			System.out.println();
			
		//using arrays.sort method to sort it back in ascending order
			System.out.println("using arrays.sort method to sort array ");
			int[] intarr = new int[] {1,6,5,8};
			Arrays.sort(intarr);
			for(int i : intarr) {
				System.out.print(i + " ");
			}
//			Arrays.sort(arraylist.toArray());
			System.out.println();
			
		//using streams to manipulate array list
			System.out.println("using streams to manipulate array list");
			List<Integer> arrayliststream = arraylist.stream().map(x -> x*3).filter(x -> (x%2==0)).collect(Collectors.toList());
			System.out.println(arrayliststream);
			
		//converting an interger array to array list of integer
			System.out.println("converting an integer array to array list of integer");
			Integer[] arrInteger = new Integer[] {1,6,4,5,3,2,8,9};
			List<Integer> integerarraylist = Arrays.asList(arrInteger);
			System.out.println(integerarraylist);
			
			
		//arraylist is a ordered collection that is it maintains the order we provide the values to it in
			Integer valAt3 = arraylist.get(3);
			System.out.println("value at 3rd index : " + valAt3);
			
			arraylist.set(3, 5);
			System.out.println("updated value at 3rd index to 5 : " + arraylist.get(3));
			
			arraylist.remove(3);
			System.out.println("removed index at 3 : " + arraylist);
			
			boolean is4Present = arraylist.contains(4);
			System.out.println("is 4 present in array : " + is4Present);
			
			System.out.println("size of the arraylist : "+ arraylist.size());
			
			/*
			 * arrays.sort uses timsort (merge sort + insertion sort) for sorting objects
			 * 		although merge sort is less memory efficient then quick sort, it is stable sorting algorightm
			 * 		that means that equal elements retain their positions after sorting
			 * 		we need to make sure that object type data should not switch positions
			 * 		also merge sort clones the array of objects, which in case of primitives is almost double in size 
			 * 		hence its not a good idea to use merge sort with primitives
			 * array.sort uses double pivot quick sort for sorting primitives
			 * 		quick sort is the most efficient algorithm in general but it has dramatic worst case time complexity of n^2
			 * 		quick sort is not a stable algorithm hence its better to use it with primitives that have no identitiy
			 * Collections.sort uses the timsort algorithm similar to arrays.sort
			 * 
			 */
			
		List<Integer> arrlist2 = Arrays.asList(2,4,5,3,5,6);
		
		
		List<Integer> linkedlist = new LinkedList<Integer>();
			//linkedlist uses doubly linked list
			linkedlist.add(3);
			linkedlist.add(6);
			linkedlist.add(7);
			linkedlist.add(2);
			linkedlist.add(5);
			linkedlist.add(9);
			linkedlist.add(1);
			
			System.out.println(linkedlist);
			linkedlist.contains(3);
			
			
			
			
			
		
		List<Integer> vector = new Vector<Integer>();
		
		
		List<Integer> stack = new Stack<Integer>();
		
		
		Vector<Integer> stackUsingVector = new Stack<Integer>();
		
		
		Deque<Integer> stackUsingLinkedList = new LinkedList<Integer>();
		
		//stack implementation using linked list
		//stack is lifo : last element goes out first
		//we use push and pop in stack and peek to check the last element
		stackUsingLinkedList.push(4);
		stackUsingLinkedList.push(3);
		stackUsingLinkedList.push(7);
		stackUsingLinkedList.push(8);
		stackUsingLinkedList.push(1);
		
		System.out.println(stackUsingLinkedList);
		System.out.println(stackUsingLinkedList.peek());
		
		System.out.println(stackUsingLinkedList.pop());
		System.out.println(stackUsingLinkedList);
		
		//queue methods : offer, poll, element 
		
		
		//priority Queue
		
		
		
		//tree set
		TreeSet<Integer> treeset = new TreeSet<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1-i2;
			}
		});
		
		treeset.add(5);
		treeset.add(7);
		treeset.add(6);
		treeset.add(3);
		treeset.add(9);
		System.out.println(treeset);
		
		for(int i : treeset) {
			System.out.println(i);
		}
		
		treeset.forEach(x -> {System.out.print(x+ " ");});
		
		System.out.println();
		treeset.stream().map(x->x*2).forEach(System.out::println);
		
		System.out.println("asdf");
		
		System.out.println(Thread.currentThread().getName());
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(i);
					try {
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i : arraylist) {
					System.out.println(i);
					try {
						Thread.sleep(200);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		t2.start();
		t1.start();
	}
}
