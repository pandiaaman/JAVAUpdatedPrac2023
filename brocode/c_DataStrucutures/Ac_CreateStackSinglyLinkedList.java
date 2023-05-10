package c_DataStrucutures;

public class Ac_CreateStackSinglyLinkedList<T> {

	//pointer
	transient Node<T> head;
	transient int size;
	
	//constructor
	public Ac_CreateStackSinglyLinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	static class Node<T>{
		private transient T data;
		private transient  Node<T> next;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
		
	}
	
	//add : push
	public synchronized void push(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if(this.head == null) {
			newNode.setNext(null);
		}
		else {
			newNode.setNext(this.head);
		}
		this.head = newNode;
		this.size++;
	}
	
	//pop
	public synchronized T pop() {
		
		
		if(this.size == 0) {
			System.out.println("can not pop since empty");
			throw new NullPointerException();
		}
		
		T data = this.head.getData();
		
		this.head = this.head.getNext();
		this.size--;
		
		return data;
	}
	
	//peek
	public T peek() {
		
		if(this.size == 0) {
			System.out.println("can not peek since empty");
			throw new NullPointerException();
		}
		
		return this.head.getData();
	}
	
	public String toString() {
		String res = "";
		Node<T> indexNode = this.head;
		while(indexNode != null) {
			res += indexNode.getData() + " ";
			indexNode = indexNode.getNext();
		}
		return res;
	}
	
	
	
	public static void main(String[] args) {
		Ac_CreateStackSinglyLinkedList<Integer> stack = new Ac_CreateStackSinglyLinkedList<Integer>();
		
		stack.push(3);
		stack.push(5);
		stack.push(9);
		stack.push(11);
		
		System.out.println(stack.size);
		System.out.println(stack);
		
		System.out.println("popped " + stack.pop());
		
		System.out.println(stack);
		
		stack.push(2);
		System.out.println(stack);
		
		System.out.println("popped " + stack.pop());
		System.out.println("popped " + stack.pop());
		System.out.println("popped " + stack.pop());
		System.out.println("popped " + stack.pop());
		try {
			System.out.println("popped " + stack.pop());
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		System.out.println("continuing");

	}

}
