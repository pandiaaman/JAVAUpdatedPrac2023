package c_DataStrucutures;

import java.util.Arrays;

public class Ga_CreateDynamicArray<T> {

	//data
	private transient int size = 0;
	private transient int capacity;
	Object[] arrData;
	
	
	
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

	//constructors
	public Ga_CreateDynamicArray() {
		this.capacity = 11;
		this.arrData = new Object[capacity];
	}
	
	public Ga_CreateDynamicArray(int capacity) {
		this.capacity = capacity;
		this.arrData = new Object[capacity];
	}
	
	//add an element
	public void add(T val) {
		System.out.println("adding " + val);
		addAtIndex(this.size, val);
	}
	
	public void addAtIndex(int index, T val) {
		
		if(index > size || index < 0) {
			System.out.println("index is out of limits");
			return;
		}
		
		if((double)this.size >= (double) (2*(this.capacity)/3)) {
			System.out.println("(double)this.size and (double) ((2/3)*this.capacity) " + (double)this.size +" " + (double) (2*(this.capacity)/3) + " " + this.capacity);
			grow();
		}
		
		int i = this.size-1;
		while(i>=index) {
			this.arrData[i+1] = this.arrData[i];
			i--;
		}
		
		this.arrData[index] = val;
		
		this.size++;
	}
	
	private void grow() { //grow is private since we don't want users to call grow
		System.out.println("growing");
		this.capacity = 3*(this.capacity)/2;
		Object[] copyArr = new Object[this.capacity];
		
		int i=0;
		while(this.arrData[i] != null) {
			copyArr[i] = arrData[i];
			i++;
		}
		
		this.arrData = copyArr;
	}
	
	public void removeIndex(int index) {
		if(index > this.size || index < 0) {
			System.out.println("index is out of bounds");
			return;
		}
		
		if((double)this.size < (double) ((this.capacity)/2)) {
			System.out.println("(double)this.size < (double) ((this.capacity)/2) " + (double)this.size +" " + (double) ((this.capacity)/2) + " " + this.getCapacity());
			if(this.capacity > 15) {
				shrink();
			}
		}
		
		int i = index;
		while(i<size) {
			this.arrData[i] = this.arrData[i+1];
			i++;
		}
		
		this.arrData[size] = null;
		this.size--;
		
	}
	
	private void shrink() {
		System.out.println("shrinking");
		this.arrData = Arrays.copyOf(this.arrData, (2*(this.capacity)/3));	
		this.capacity = (2*(this.capacity)/3);
		System.out.println("new shrinked capacity :" + this.capacity);
	}
	
	public String toString() {
		String res = "";
		
		int i = 0;
		while(i<this.size) {
			res += this.arrData[i] + ", ";
			i++;
		}
		if(res!="") {
			res = res.substring(0,res.length()-2);
		}
		
		return res;
	}
	
	public boolean isEmpty() {
		return size==0? true: false;
	}
	
	public int search(T val) {
		int index = 0;
		while(index < this.size) {
			if(this.arrData[index] == val) {
				return index;
			}
			index++;
		}
		return -1;
	}
	
	public void removeData(T val) {
		int index = search(val);
		if(index == -1) {
			System.out.println("element not present");
			return;
		}
		this.removeIndex(index);
	}
	

	public static void main(String[] args) {
		Ga_CreateDynamicArray<Integer> arrayList = new Ga_CreateDynamicArray<Integer>(9);
		
		System.out.println(arrayList.getCapacity());
		
		arrayList.add(2);
		arrayList.add(1);
		System.out.println(arrayList.getSize());
		arrayList.add(7);
		arrayList.add(4);
		arrayList.add(4);
		arrayList.add(4);
		arrayList.add(54);
		arrayList.add(4);
		arrayList.add(4);
		arrayList.add(54);
		arrayList.add(4);
		arrayList.add(4);
		arrayList.add(54);
		arrayList.add(4);
		arrayList.add(4);
		arrayList.add(54);
		arrayList.add(4);
		arrayList.add(4);
		arrayList.add(54);
		arrayList.add(4);
		arrayList.add(4);
		arrayList.add(54);
		
		arrayList.addAtIndex(3, 99);
		System.out.println(arrayList.getSize());
		System.out.println(arrayList);
		
		arrayList.removeIndex(2);
		System.out.println(arrayList.getSize());
		System.out.println(arrayList);
		
		arrayList.removeData(4);
		System.out.println(arrayList);

		
		arrayList.removeData(4);
		arrayList.removeData(54);
		arrayList.removeData(4);
		System.out.println(arrayList);
		arrayList.removeData(4);
		arrayList.removeData(54);
		arrayList.removeData(4);
		System.out.println(arrayList);
		arrayList.removeData(4);
		arrayList.removeData(54);
		arrayList.removeData(4);
		System.out.println(arrayList);
		arrayList.removeData(4);
		arrayList.removeData(54);
		arrayList.removeData(4);
		
		System.out.println(arrayList);
	}

}
