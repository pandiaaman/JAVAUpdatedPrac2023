package collections;

public class A1_DynamicArray {

	int size;
	int capacity;
	Object[] array;
	
	public A1_DynamicArray() {
		this.capacity = 10;
		array = new Object[this.capacity];
	}
	
	public A1_DynamicArray(int capacity) {
		this.capacity = capacity;
		array = new Object[this.capacity];
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public boolean isEmpty() {
		return this.size == 0? true : false;
	}
	
	public void add(Object t) {
		if(this.size >= this.capacity) {
			grow();
		}
		
		this.array[this.size] = t;
		this.size++;
	}
	
	private void grow() {
		this.capacity = (3/2)*(this.capacity);
		Object[] tempArr = new Object[this.size];
		for(int i=0;i<this.size;i++) {
			tempArr[i] = this.array[i];
		}
		
		this.array = tempArr;
	}
	
	public static void main(String[] args) {
		
		

	}

}
