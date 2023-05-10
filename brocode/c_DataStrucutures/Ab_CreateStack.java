package c_DataStrucutures;

public class Ab_CreateStack<T> {

	//pointers
	Node<T> head;
	Node<T> tail;
	int size;
	
	//constructor
	public Ab_CreateStack() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	//implementing stack using linked list
	static class Node<T>{
		private T data;
		private Node<T> prev;
		private Node<T> next;
		
		public Node(T data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public T getData() {
			return this.data;
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
	
	//add node : push
	public void push(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if(this.head == null) { // no nodes added yet
			newNode.setPrev(null);
			this.head = newNode;
		}
		else {
			newNode.setPrev(this.tail);
			this.tail.setNext(newNode);
		}
		
		//all newly added nodes will have next null
		newNode.setNext(null);
				
		this.tail = newNode;
		this.size++;
	}
	//remove node : pop
	public T pop() {
		T data = this.tail.getData();
		
		this.tail = this.tail.getPrev();
		this.tail.setNext(null);
		
		this.size--;
		return data;
	}
	//peek
	public T peek() {
		return this.tail.getData();
	}
	
	//isempty
	public boolean isEmpty() {
		return size==0?true:false;
	}
	
	//print
	public String toString() {
		String res = "";
		Node<T> index = this.head;
		while(index != null) {
			res += index.getData() + " ";
			index = index.getNext();
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		Ab_CreateStack<Integer> stack = new Ab_CreateStack<Integer>();
		stack.push(4);
		stack.push(7);
		stack.push(9);
		stack.push(11);
		
		System.out.println(stack.size);
		System.out.println(stack.head.getData());
		System.out.println(stack.tail.getData());
		System.out.println(stack);
		
		System.out.println("popped" + stack.pop());
		
		System.out.println(stack.size);
		System.out.println(stack.head.getData());
		System.out.println(stack.tail.getData());
		System.out.println(stack);
		
		stack.push(8);
		
		System.out.println(stack.size);
		System.out.println(stack.head.getData());
		System.out.println(stack.tail.getData());
		System.out.println(stack);
	}

}
