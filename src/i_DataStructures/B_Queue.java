package i_DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class B_Queue {

	public static void main(String[] args) {
		/*
		 * Queue is FIFO
		 * collection for holding elements prior to processing, to make sure processing
		 * takes place in the correct order
		 * linear data structure
		 * 
		 * add => enqueue, offer()
		 * remove => dequeue, poll()
		 */
		
		//first come first serve
		
//		Queue<String> queue = new Queue<String>(); 
		//queue is an interface, not a class, so we can not create an object of queue
		Queue<String> queue = new LinkedList<String>();
		//linked list is the only way in java to apply queue as it implements dequeue
		
		//for now lets only concentrate on queue
		/*
		 * from queue we only get three methods:
		 * add : enqueue : offer()
		 * remove : dequeue : poll()
		 * element : peek : peek()
		 * 
		 */
 
		queue.offer("Karen");
		queue.offer("chunnu");
		queue.offer("aman");
		queue.offer("ayaz");
		queue.offer("anisha");	
		
		System.out.println(queue);
		
		//peek method to see the first element that will be passed first
		System.out.println(queue.peek());
		
		//polling the first element out
		queue.poll();
		
		System.out.println(queue);
	}

}
