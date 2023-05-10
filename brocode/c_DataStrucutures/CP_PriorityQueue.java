package c_DataStrucutures;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class CP_PriorityQueue {

	//does NOT permit null values, NOT thread safe (PriorityBlockingQueue for thread safety)
	/*
	 * is used when objects are to be processed based on priority
	 * PriorityQueue is  a class unlike Queue that is only an interface and uses LinkedList to implement it
	 * The insertion order is not retained in the PriorityQueue.
	 * The elements are stored based on the priority order which is ascending by default. 
	 * We will not get sorted elements by printing PriorityQueue.
	 * you can only see the order on peeking
	 * by default the order is ascending
	 * we can use add and offer interchangibly to add elements
	 * Priority Queue only makes sure that the first element is at the right place, all other elements are randomly arranged
	 * 
	 * Priority Queue uses heap to keep the elements in the right order : it uses heap sort
	 * Heap : visualizing array as a special kind of complete binary tree
	 * 		a complete binary tree is the one that has all its levels filled except maybe for the last one, all parents have two kids
	 * 		another important factor for a tree to be complete binary is all the leaf nodes should lean towards left
	 * 		the difference between full binary tree and a complete binary tree is that the last level also has two children for full tree
	 * 
	 */
	public static void main(String[] args) {
		//5 ways we can initiate a priorityQueue
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
//		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(15); //by default the capacity is 11
//		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
//		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(15,(Integer i1, Integer i2) -> i1-i2); //using a comparator with lambda
//		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(15,new Comparator<Integer>() {
//			@Override
//			public int compare(Integer i1, Integer i2) {
//				return i2-i1;
//			}
//		});
		
		priorityQueue.add(4);
		priorityQueue.offer(2);
		priorityQueue.offer(5);
		priorityQueue.offer(1);
		priorityQueue.add(7);
		priorityQueue.add(9);
		priorityQueue.add(8);
		
		System.out.println(priorityQueue);
		
		System.out.println("polling to see the order " + priorityQueue.poll());
		System.out.println("polling to see the order " + priorityQueue.poll());
		System.out.println("polling to see the order " + priorityQueue.poll());
		System.out.println("polling to see the order " + priorityQueue.poll());
		System.out.println("polling to see the order " + priorityQueue.poll());
		
		Iterator<Integer> itr = priorityQueue.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}
}