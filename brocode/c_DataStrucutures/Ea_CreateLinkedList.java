package c_DataStrucutures;

import java.io.Serializable;

public class Ea_CreateLinkedList<T> implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Linked List is the implementation of the doubly linked list in java
	//values are transient because we dont want these to be serialized 
	transient Node<T> head;
	transient Node<T> tail;
	transient int size;
	
	//constructor of the linkedList class
	public Ea_CreateLinkedList(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	
	//inner static nested class : 
	//An instance of an inner class cannot be created without an instance of the outer class. 
	//Therefore, an inner class instance can access all of the members of its outer class, without using a reference to the outer class instance
	//A static nested class may be instantiated without instantiating its outer class.
	private static class Node<T>{
		private T val;
		private Node<T> prev;
		private Node<T> next;
		
		public Node(T val){
			this.val = val;
		}

		public T getVal() {
			return val;
		}

		public void setVal(T val) {
			this.val = val;
		}

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
		
	}
	
	//to add an element in the linked list at end by default
	public void add(T val) {
		if(this.head != null) {
			addLast(val);
		}else {
			addFirst(val);
		}
	}
	
	//adding the element to first: addFirst
	public void addFirst(T val) {
		//since the Node is a static inner class we need to use below way of defining the node
		Ea_CreateLinkedList.Node<T> node = new Ea_CreateLinkedList.Node<T>(val); 
		
		node.setPrev(null); //since it will be head, its prev has to be null
		
		//case : there is an existing head
		if(this.head != null) {
			this.head.setPrev(node);
			node.setNext(this.head);
		}
		//case : no head exists : hence the first element
		else {
			node.setNext(null);
			this.tail = node; //since its the first element, it will be both, head and tail
		}
		
		this.head = node;
		this.size++;
	}
	
	public void addLast(T val) {
		Ea_CreateLinkedList.Node<T> node = new Ea_CreateLinkedList.Node<T>(val);
		
		node.setNext(null); // since last in the list, next will be null
		//setting the current tail's next as node
		this.tail.setNext(node);
		node.setPrev(this.tail);
		
		this.tail = node;
		this.size++;
	}
	
	//adding a new element at a given specific position
	public void addElementAt(T val, int index) throws Exception { //indexing is 0 basis : if added on 0 then its the head
		
		//if the index is greater than the current size of linkedList
		if(index >= this.size) {
			throw new Exception("Index is acceding the size of the list");
		}
		
		if(index == 0) {
			addFirst(val);
		}
		
		if(index == size-1) {
			addLast(val);
		}
		
		Ea_CreateLinkedList.Node<T> node = new Ea_CreateLinkedList.Node<T>(val);
		
		Ea_CreateLinkedList.Node<T> nodeIndex = this.head; //used for iterating in the nodes
		
		int counter = 0;
		
		while(nodeIndex!=null) {
			counter++;
			
			if(counter == index) {
				break;
			}

			nodeIndex = nodeIndex.getNext();		
		}
		nodeIndex.getNext().setPrev(node);
		node.setPrev(nodeIndex);
		node.setNext(nodeIndex.getNext());
		nodeIndex.setNext(node);
	}
	
	//remove element at given index (0: head, size-1 : tail)
	public void removeElementAt(int index) {
		int counter = 0;
		Ea_CreateLinkedList.Node<T> indexNode = this.head;
		
		if(index == 0) {
			removeFirst();
			return;
		}
		else if(index == size-1) {
			removeLast();
			return;
		}else if(index<0 || index>=size) {
			System.out.println("index is not present in the list");
			return;
		}
		
		while(indexNode != null) {
			
			if(counter == index) {
				break;
			}
			counter++;
			indexNode = indexNode.getNext();
		}
		
		indexNode.getNext().setPrev(indexNode.getPrev());
		indexNode.getPrev().setNext(indexNode.getNext());
	}
	
	public void removeFirst() {
		this.head.getNext().setPrev(null);
		this.head = this.head.getNext();
	}
	
	public void removeLast() {
		this.tail.getPrev().setNext(null);
		this.tail = this.tail.getPrev();
	}
	
	//to search for an element in the linked list
	public int search(T val) {
		
		Ea_CreateLinkedList.Node<T> indexNode = this.head;
		
		int counter = 0;
		
		while(indexNode != null) {
			
			if(indexNode.getVal().equals(val)) {
				return counter;
			}
			
			counter++;
			indexNode = indexNode.getNext();
		}
		
		System.out.println("value not found");
		return -1;
	}
	
	//to check if its empty
	public boolean isEmpty() {
		
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//to display or print the linked list
	public String toString() {
		String res = "";
		Ea_CreateLinkedList.Node<T> indexNode = this.head;
		
		while(indexNode != null) {
			res += indexNode.getVal() + " ";
			
			indexNode = indexNode.getNext();
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ea_CreateLinkedList<Integer> linkedList = new Ea_CreateLinkedList<Integer>();
		
		System.out.println(linkedList.isEmpty());
		
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(1);
		linkedList.add(7);
		linkedList.add(2);
		
		System.out.println(linkedList.isEmpty());
		System.out.println("size : " + linkedList.size);
		
		System.out.println(linkedList);
		
		linkedList.addFirst(1);
		System.out.println(linkedList);
		
		try {
			linkedList.addElementAt(99, 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(linkedList);
		
		System.out.println(linkedList.search(99));
		
		linkedList.removeFirst();
		
		System.out.println(linkedList);
		
		linkedList.removeElementAt(3); //index is 0 based
		
		System.out.println(linkedList);
		
	}

}
