package c_DataStrucutures;

class DequeNode<T>{
	private T value;
	private DequeNode<T> next;
	private DequeNode<T> prev;
	
	public DequeNode(T val) {
		this.value = val;
		this.next = null;
		this.prev = null;
	}
	
	public void setValue(T val) {
		this.value = val;
	}
	
	public void setNext(DequeNode<T> next) {
		this.next = next;
	}
	
	public DequeNode<T> getNext() {
		return this.next;
	}
	
	public void setPrev(DequeNode<T> prev) {
		this.prev = prev;
	}
	
	public DequeNode<T> getPrev() {
		return this.prev;
	}
	
	public String toString() {
		String res = "this node has value of ";
		res += this.value + " ";
		res += " and has previous node of " + this.prev;
		res += " and has next node of " + this.next;
		
		return res;
	}
}

class DequeImpl<T>{
	
	DequeNode<T> head;
	DequeNode<T> tail;
	
	public DequeImpl() {
		this.head = this.tail = null;
	}
	
	public synchronized void addFirst(T val) {
		DequeNode<T> node = new DequeNode<T>(val);
		
		node.setPrev(null); // in all cases, the prev of head will be null
		
		if(this.head != null) { // case : if head already exists
			this.head.setPrev(node); // setting existing head prev to current node (new head)
			node.setNext(this.head.getNext()); // setting next of current node to existing head's next 
		}else { // case : if no head exists
			node.setNext(null); // next to the head will be null
			this.tail = node; // setting tail to the first node
		}
		
		this.head = node;
	}

	public synchronized void addLast(T val) {
		DequeNode<T> node = new DequeNode<T>(val);
		
		node.setNext(null);
		
		if(this.tail != null) {
			this.tail.getPrev().setNext(node);
			node.setPrev(this.tail.getPrev());
		}
		
		this.tail = node;
	}
}

class StackDeque {
	
}

class QueueDeque {
	
}

public class Fa_CreateDequeStackAndQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
