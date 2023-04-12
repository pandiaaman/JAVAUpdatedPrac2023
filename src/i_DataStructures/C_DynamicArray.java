package i_DataStructures;

public class C_DynamicArray {
	
	private int size;
	private int capacity;
	private Object[] array;
	
	public C_DynamicArray() {
		this.capacity = 10; //default capacity
		this.array = new Object[this.capacity];
	}

	public C_DynamicArray(int capacity) {
		this.capacity = capacity;
		this.array = new Object[this.capacity];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String toString() {
		String res = "[";
		for(int i = 0; i < this.size; i++) {
			res += (this.array[i]);
			if(i!= this.size-1) {
				res += ", ";
			}
		}
		res += "]";
		
		return res;
	}
	
	//isempty
	public boolean isEmpty() {
		return this.size==0;
	}
	
	//adding item
	public void add(Object item) {
		if(this.size >= this.capacity) { //forgot to put = with > here
			this.grow();
		}
		this.array[this.size] = item;
		this.size++;
	}
	//inserting item at a given index
	public void insert(Object item, int index) {
		if(index > this.size) {
			System.out.println("index is greater than size, indexOutOfBoundsException");
			throw new IndexOutOfBoundsException();
		}
		else {
			if(this.size > this.capacity) {
				this.grow();
			}
			for(int i = size-1 ; i >= index ; i--) {
				this.array[i+1] = this.array[i];
			}
			this.array[index] = item;
			this.size++;
		}
	}
	
	
	//grow
	public void grow() {
		this.capacity *= 1.5;
		Object arrtemp[] = new Object[this.capacity];
		
		for(int i=0;i<this.size;i++) {
			arrtemp[i] = this.array[i];
		}
		
		this.array = arrtemp;
	}
	
	//shrink
	public void shrink() {
		this.capacity /= 3;
		
		Object arrtemp[] = new Object[this.capacity];
		
		for(int i=0;i<this.size;i++) {
			arrtemp[i] = this.array[i];
		}
		
		this.array = arrtemp;
	}
	
	//delete
	public void deleteData(Object data) {
		int flag = 0;
		for(int i = 0; i < this.size; i++) {
			if(this.array[i].equals(data)) {
				flag =1;
				deleteIndex(i);
			}
		}
		if(flag == 0) {
			System.out.println("given object not found");
		}
	}
	
	public void deleteIndex(int index) {
		if(index > this.size) {
			System.out.println("index is greater than size, indexOutOfBoundsException");
			throw new IndexOutOfBoundsException();
		}
		for(int i = index; i < this.size-1 ; i++) {
			this.array[i] = this.array[i+1];
		}
		this.array[size-1]=null;
		
		this.size--;
		System.out.println("deleted successfully");
		
		if(this.size < (int) (this.capacity/3)) {
			this.shrink();
		}
		
	}
	

	
	//search
	public int searchData(Object data) {
		for(int i = 0; i< this.size; i++) {
			if(this.array[i].equals(data)) {
				return i;
			}
		}
		
		System.out.println("value not present");
		return -1;
	}
	
}
