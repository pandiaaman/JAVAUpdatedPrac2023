package DSALogics;

public class G_21_LinkedListImpl<T> {

	static class Node<T>{
		private T data;
		private Node<T> next;
		private Node<T> prev;
		
		public Node(T data){
			this.data = data;
			this.next = null;
			this.prev = null;
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

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + ", prev=" + prev + "]";
		}
		
		
		
	}
	
	
	static class LinkedList<T>{
		
		private int size;
		private Node<T> head;
		private Node<T> tail;
		
		public LinkedList() {
			this.size = 0;
			this.head = null;
			this.tail = null;
		}
		
		public void addLast(T data) {
			Node<T> node = new Node<T>(data);
			
			node.setNext(null); //since last node so next will always be null
			
			if(this.head == null) { //its the first node
				node.setPrev(null);
				this.head = node;
				this.tail = node;
			}
			
			node.setPrev(tail);
			this.tail.setNext(node);
			
			this.tail = node;
			this.size++;
			
			System.out.println("at " + this.size + " we have head " + this.head.getData() );
			System.out.println("at " + this.size + " we have tail " + this.tail.getData());
			
		}
		
		public void addFirst(T data) {
			Node<T> node = new Node<T>(data);
			
			node.setPrev(null);//since first node so prev will always be null
			
			if(this.head == null) {
				node.setNext(null);
				this.head = node;
				this.tail = node;
			}
			
			node.setNext(this.head);
			this.head.setPrev(node);
			
			this.head = node;
			this.size++;
			
		}
		
		public void add(T data) {
			addLast(data);
		}
		
		public void push(T data) {//stack
			addFirst(data);
		}
		
		public void offer(T data) { //queue
			addLast(data);
		}
	
		public void remove() {
			removeLast();
		}
		
		public void removeFirst() {
			this.head = this.head.getNext();
			this.size--;
		}
		
		public void removeLast() {
			this.tail = this.tail.getPrev();
			this.size--;
		}
		
		public void pop() { //stack
			removeFirst();
		}
		
		public void poll() { //queue
			removeFirst();
		}
		
		public void pollFirst() {
			removeFirst();
		}
		
		public void pollLast() {
			removeLast();
		}
		
		public T peek() { //stack
			return this.head.getData();
		}
		
		public T peekFirst() {
			return peek();
		}
		
		public T peekLast() {
			return element();
		}
		
		public T element() { //queue
			return this.tail.getData();
		}
		
		
		public void removeAtIndex(int index) {
			if(index<-1 || index>size) {
				System.out.println("index is out of bounds");
				return;
			}
			
			Node<T> pointer = this.head;
			
			for(int i=0;i<index;i++) {
				pointer = pointer.getNext();
			}
			
			pointer.getPrev().setNext(pointer.getNext());
			pointer.getNext().setPrev(pointer.getPrev());
			this.size--;
			
		}
		
		public void addAtIndex(int index, T data) {
			if(index<-1 || index>size) {
				System.out.println("index is out of bounds");
				return;
			}
			
			Node<T> node = new Node<T>(data);
			
			Node<T> pointer =  this.head;
			
			for(int i=0;i<index;i++) {
				pointer = pointer.getNext();
			}
			
			node.setNext(pointer.getNext());
			node.setPrev(pointer);
			pointer.getNext().setPrev(node);
			pointer.setNext(node);

			this.size++;
		}
		
		@Override
		public String toString() {
			String res="[";
			
			Node<T> pointer  = this.head;
			
			while(pointer!= null) {
				res += pointer.getData()+" ";
				pointer = pointer.getNext();
			}
			
			return res+"]";
		}
		
		public void printReverse() {
			printReverseRec(this.head);
		}
		
		public void printReverseRec(Node<T> pointer) {
			if(pointer == null) {
				return;
			}
			
			printReverseRec(pointer.getNext()); //call karne ke baad me print karenge to ulta aate hue print hoga sara
			System.out.print(pointer.getData() + " ");
			
		}
		
		public void reverseLinkedList() {
			
			//if linkedlist is empty
			if(this.head == null) {
				System.out.println("nothing in the linked list");
				return;
			}
			
			if(this.head.getNext() == null) {
				System.out.println("already reversed since only one element");
				return;
			}
			
			
			Node<T> pointerPrev = this.head;
			Node<T> pointerCurr = this.head.getNext();
			Node<T> pointerNext = null;
			
			while(pointerCurr.getNext()!= null) {
				pointerNext = pointerCurr.getNext();
				
				pointerCurr.setNext(pointerPrev);
				
				//update
				pointerPrev = pointerCurr;
				pointerCurr = pointerNext;
			}
			
			this.head.setNext(null);
			this.head = pointerPrev;
		}
		
		
		public Node<T> reverseLinkedListRecursion(Node<T> head) {
			if(this.head == null) {
				return head;
			}
			Node<T> newHead = reverseLinkedListRecursion(head.getNext());
			
			head.getNext().setNext(head);
			head.setNext(null);
			
			return newHead;
			
		}
		
		//find nth node from last and delete it
		public void findNthNodeFromEndandDelete(int n) {
			if(n<-1||n>this.size) {
				System.out.println("index out of bounds");
				return;
			}
			
			int index = this.size - n + 1;//index of node to be deleted
			//so we need to go back one step
			index = index-1; //pointing to the node right before the node we want to delete
			
			Node<T> pointer = this.head;
			
			for(int i=0;i<=index;i++) {
				pointer = pointer.getNext();
			}
			
			//pointer points to the node right before the node to be deleted
			pointer.setNext(pointer.getNext().getNext());
			
		}
		
		
		public int getSizeOfLL() {
			if(this.head == null) {
				return 0;
			}
			
			
			Node<T> pointer =  this.head;
			int size = 0;
			while(pointer!=null) {
				pointer = pointer.getNext();
				size++;
			}
			
			return size;
		}
		
		
		private String printFront(Node<T> head,String res) {
			Node<T> pointer = head;
			while(pointer!=null) {
				res+=pointer.getData();
				pointer = pointer.getNext();
			}
			return res;			
		}
		
		public String printReverse(Node<T> pointer, String res) {
			if(pointer== null) {
				return "";
			}
			
			printReverse(pointer.getNext(),res);
			System.out.print(pointer.getData() + " ");
			res = res+pointer.getData();
			return res;
		}
		
		public boolean isListPalindrome() {
			
			String printfront = printFront(this.head,"");
			System.out.println(printfront);
			String printreverse = printReverse(this.head,"");
			System.out.println("revvv" + printreverse);
			if(printfront.equals(printreverse)) {
				return true;
			}
			return false;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> ls = new G_21_LinkedListImpl.LinkedList<Integer>();
		
		ls.add(3);
		ls.add(7);
		System.out.println(ls.size);
		System.out.println(ls);
		ls.addFirst(2);
		ls.addFirst(6);
		System.out.println(ls);
		ls.push(8);
		ls.push(0);
		System.out.println(ls);
		ls.offer(1);
		ls.offer(9);
		System.out.println(ls);
		ls.addLast(11);
		ls.addLast(13);
		System.out.println(ls);
		
		System.out.println("removing");
		ls.remove();
		System.out.println(ls);
		ls.removeFirst();
		System.out.println(ls);
		ls.removeLast();
		System.out.println(ls);
		ls.poll();
		System.out.println(ls);
		ls.pollFirst();
		System.out.println(ls);
		ls.pollLast();
		System.out.println(ls);
		ls.pop();
		System.out.println(ls);
		
		System.out.println(ls.peek());
		System.out.println(ls.peekFirst());
		System.out.println(ls.peekLast());
		System.out.println(ls.element());
		
		System.out.println(ls);
		
//		ls.printReverse();
		
		ls.findNthNodeFromEndandDelete(3);
		System.out.println(ls);
		
		System.out.println(ls.getSizeOfLL());
		ls.isListPalindrome();
	}

}
