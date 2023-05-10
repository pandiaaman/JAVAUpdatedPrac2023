package c_DataStrucutures;

import java.util.Arrays;

public class Ca_CreatePrioriyQueue<T> {

	Object[] priorityQueueArray;
	int startIndex;
	int endIndex;
	
	public Ca_CreatePrioriyQueue() {
		priorityQueueArray = new Object[11];
		startIndex = 0;
		endIndex = 0;
	}
	
	public Ca_CreatePrioriyQueue(int capacity) {
		super();
		priorityQueueArray = new Object[capacity];
	}

	public void add(T val) {
		if((double)this.endIndex >= (double)(this.priorityQueueArray.length)*2/3) {
			grow();
		}
		if(this.endIndex>=1) {
			int i=this.endIndex-1;
			while(i >= this.startIndex) {
				this.priorityQueueArray[i+1] = this.priorityQueueArray[i];
			}
		}
		this.priorityQueueArray[this.endIndex++] = val;
		
	}
	public T offer(T val) {
		this.add(val);
		return val;
	}
	
	public void grow() {
		int updatedLength = (3/2)*(this.priorityQueueArray.length);
		Object[] copyArray = new Object[updatedLength];
		
		int i=this.startIndex;
		while(i <= this.endIndex) {
			copyArray[i] = this.priorityQueueArray[i];        
		}
		
		this.priorityQueueArray = copyArray;
	}
	
	public T poll() {
		T res = (T) this.priorityQueueArray[startIndex];
		startIndex++;
		return res;
	}
	
	public String toString() {
		String res = "";
		int i = startIndex;
		while(i < endIndex) {
			res += this.priorityQueueArray[i] + " ";
			i++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Ca_CreatePrioriyQueue<String> queue = new Ca_CreatePrioriyQueue<String>();
		
		
		queue.offer("aman");
		
		queue.offer("sanchit");
		queue.offer("anisha");
		queue.offer("ayaz");
		
		System.out.println(queue);

		
		System.out.println(queue.poll());
		
		System.out.println(queue);

	}

}
