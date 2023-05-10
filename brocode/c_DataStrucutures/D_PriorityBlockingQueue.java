package c_DataStrucutures;

import java.util.Vector;
import java.util.concurrent.PriorityBlockingQueue;

public class D_PriorityBlockingQueue {

	public static void main(String[] args) {
//		it is unbounded and is thread safe
		PriorityBlockingQueue<Integer> pbQueue = new PriorityBlockingQueue<Integer>();
		
		pbQueue.offer(22);
		pbQueue.offer(3);
		pbQueue.offer(4);
		
		
		Vector<Integer> vector = new Vector<Integer>();
		vector.addElement(11);
		vector.add(12);
		vector.add(33);
		
		pbQueue.addAll(vector);
		
		System.out.println(pbQueue.remainingCapacity());
		
		System.out.println(pbQueue); //again, only cares about the first element to be at the right place
		//all other elements are later arranged, uses heap sort
		

	}

}
