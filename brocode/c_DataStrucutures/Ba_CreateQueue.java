package c_DataStrucutures;

public class Ba_CreateQueue<T> {

	Object[] queueArray;
	int endIndex;
	int startIndex;
	
	public Ba_CreateQueue() {
		queueArray = new Object[5];
		endIndex = 0;
		startIndex = 0;
	}
	
	public T offer(T val) {
		if((double)this.endIndex >= (double)(this.queueArray.length)*2/3) {
			grow();
		}
		this.queueArray[this.endIndex++] = val;
		return val;
	}
	
	
	private void grow() {
		int currentSize = this.queueArray.length;
		int updatedSize = currentSize*3/2;
		Object[] copyArray = new Object[updatedSize];
		
		int i=0;
		while(i<this.endIndex) {
			copyArray[i] = this.queueArray[i];
			i++;
		}
		
		this.queueArray = copyArray;
	}
	
	public int getSize() {
		return this.endIndex;
	}
	
	public T poll() {
		T val = null;
		try {
			val = (T) this.queueArray[0];
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.startIndex++;
		return val;
	}

	public int search(T val) {
		int i = this.startIndex;
		while(i<this.endIndex) {
			if(this.queueArray[i] == val) {
				return i+1;
			}
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return this.endIndex==0?true:false;
	}
	
	@Override
	public String toString() {
		String res="";
		int i=this.startIndex;
		while(i<this.endIndex) {
			res += this.queueArray[i] + " ";
			i++;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		
		Ba_CreateQueue<String> queue = new Ba_CreateQueue<String>();
		
		System.out.println(queue.isEmpty());
		queue.offer("aman");
		
		queue.offer("sanchit");
		queue.offer("anisha");
		queue.offer("ayaz");
		
		System.out.println(queue);

		System.out.println(queue.isEmpty());
		
		System.out.println(queue.poll());
		
		System.out.println(queue);
		
	}

}
