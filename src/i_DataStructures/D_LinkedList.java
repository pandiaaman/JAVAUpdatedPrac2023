package i_DataStructures;

public class D_LinkedList {

	private int size;
	
	//pointers
	D_LinkedListNode firstNode;
	D_LinkedListNode lastNode;
	
	public D_LinkedList() {
		this.size = 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	//add
	public void add(Object val) {
		D_LinkedListNode newNode = new D_LinkedListNode();
		newNode.setValue(val);
		newNode.setNext(null);
		newNode.setPrev(this.lastNode);
		this.lastNode.setNext(newNode);
		this.lastNode = newNode;
		this.size++;
	}
	
	//addfirst
	public void addFirst(Object val) {
		D_LinkedListNode newNode = new D_LinkedListNode();
		newNode.setValue(val);
		newNode.setPrev(null);
		if(this.size==0) {
			newNode.setNext(null);
		}else {
			newNode.setNext(this.firstNode);
			this.firstNode.setPrev(newNode);
		}
		this.firstNode = newNode;
		if(this.size == 0) {
			this.lastNode = newNode;
			System.out.println("last node is : " + this.lastNode.getValue().toString());
		}
		this.size++;
	}
	
	//addlast
	public void addLast(Object val) {
		D_LinkedListNode newNode = new D_LinkedListNode();
		newNode.setValue(val);
		newNode.setNext(null);
		newNode.setPrev(this.lastNode);
		this.lastNode.setNext(newNode);
		this.lastNode = newNode;
		this.size++;
		}
	//insert
	public void insertFromFront(Object val, int index) {
		D_LinkedListNode newNode = new D_LinkedListNode();
		newNode.setValue(val);
		int counter = 1;
		D_LinkedListNode pointer = this.firstNode;
		while(counter < index) {
			pointer = pointer.getNext();
			counter++;
		}
		pointer.getNext().setPrev(newNode);
		newNode.setNext(pointer.getNext());
		newNode.setPrev(pointer.getPrev());
		pointer.setNext(newNode);
		
		this.size++;
	}
	//deletefirst
	
	//deletelast
	
	//search
	
	//toString
	public String toString() {
		if(size == 0) {
			return "empty";
		}
		if(size == 1) {
			return ("[" + this.firstNode.getValue().toString() + "]");
		}
		D_LinkedListNode pointer = this.firstNode;
		String res = "[";
		while(pointer != this.lastNode) {
			res += (pointer.getValue() + ",");
		}
		res += "]";
		return res;
	}
}
