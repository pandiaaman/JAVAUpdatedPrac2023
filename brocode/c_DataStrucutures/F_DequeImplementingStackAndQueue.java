package c_DataStrucutures;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * the logic is to implement stack and queue using Deque,
 * now Queue and Deque are both interfaces, and we use linkedList to implement them
 * On the other hand, stack is a class that extends vector, which is weird, vector gives you the ability to insert elements at
 * 		any required location, and this is not how stacks work
 * we can use Deque to implement both stack and queue
 */

public class F_DequeImplementingStackAndQueue {

	public static void main(String[] args) {
		
		Iterator itr;
		
		//implementing queue : 
			/*
			 * FIFO
			 * offerLast to insert element in queue at last
			 * pollFirst to remove element from queue at beginning
			 */
		
		Deque<Integer> queue = new LinkedList<Integer>();
		
		itr = queue.iterator();
		
		System.out.println("is queue empty? " + queue.isEmpty());
		
		//insert in queue
		queue.offerLast(3);
		queue.offerLast(1);
		queue.offerLast(7);
		queue.offerLast(9);
		queue.offerLast(5);
		
		System.out.println();
		queue.forEach(x-> System.out.print(x + " "));
		//peeking in queue
		queue.peekFirst();
		
		//removing from queue
		queue.pollFirst();
		queue.pollFirst();
		
		System.out.println();
		queue.forEach(x-> System.out.print(x + " "));
		
		
		//implementing stack
			/*
			 * LIFO
			 * adds elements to last : pushLast
			 * removes from last : popLast
			 */
		System.out.println();
		
		Deque<Integer> stack = new LinkedList<Integer>();
		
		itr = stack.iterator();
		
		System.out.println("is queue empty? " + stack.isEmpty());
		
		//insert in queue
		stack.offerLast(3);
		stack.offerLast(1);
		stack.offerLast(7);
		stack.offerLast(9);
		stack.offerLast(5);
		
		System.out.println();
		stack.forEach(x-> System.out.print(x + " "));
		//peeking in queue
		stack.peekLast();
		
		//removing from queue
		stack.pollLast();
		stack.pollLast();
		
		System.out.println();
		stack.forEach(x-> System.out.print(x + " "));
		
		
		
	}
	
}
