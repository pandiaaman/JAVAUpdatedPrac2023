package i_DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;

public class E_CollectionLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		long startTime;
		long elapsedTime;
		long endTime;
		
		for(int i=0;i<1000_000;i++) {
			linkedList.add(i); //autoboxing
			arrayList.add(i);
		}
		
//*************linked list******************
		
		//*****get(0)
		startTime = System.nanoTime();
		
		linkedList.get(0);
		
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		
		System.out.println("time taken: linked list : get(0) \t" + elapsedTime + "ns");
		
		//*****get(50000)
		startTime = System.nanoTime();
		
		linkedList.get(50_000);
		
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		
		System.out.println("time taken: linked list : get(50000) \t" + elapsedTime + "ns");
		
		//*****get(99999)
		startTime = System.nanoTime();
		
		linkedList.get(99_999);
		
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		
		System.out.println("time taken: linked list : get(99999) \t" + elapsedTime + "ns");
		
//*************array list*******************
		
		//*****get(0)
		startTime = System.nanoTime();
				
		arrayList.get(0);
				
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
				
		System.out.println("time taken: array list : get(0) \t" + elapsedTime + "ns");	
		
		//*****get(50000)
		startTime = System.nanoTime();
		
		arrayList.get(50_000);
		
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		
		System.out.println("time taken: array list : get(50000) \t" + elapsedTime + "ns");
		
		//*****get(99999)
		startTime = System.nanoTime();
		
		arrayList.get(99_999);
		
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		
		System.out.println("time taken: array list : get(99999) \t" + elapsedTime + "ns");
		
		
	}

}
