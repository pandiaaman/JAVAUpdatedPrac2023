package DSALogics;

public class G_22_IsLinkedListPalindrome {

	static class Node<T>{
		T data;
		Node<T> next;
		
		public Node(T data){
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + this.data + ", next=" + this.next + "]";
		}
			
	}
	
	static class SinglyLinkedList<T>{
		int size;
		Node<T> head;
		
		SinglyLinkedList(){
			this.size = 0;
			this.head = null;
		}
		
		public void addLast(T data) {
			Node<T> node =  new Node<T>(data);
			
			node.next = null;
			
			if(this.head == null) {
				this.head = node;
			}else {
				Node<T> pointer = this.head;
				
				while(pointer.next!=null) {
					pointer = pointer.next;
				}
				
				pointer.next = node;
			}
			this.size++;
		}
		
		public void addFirst(T data) {
			Node<T> node =  new Node<T>(data);
			
			if(this.head == null) {
				this.head = node;
			}else {
				node.next = this.head;
				this.head = node;
			}
			this.size++;
		}
		
		public void removeAt(int index) {
			Node<T> pointer = this.head;
			int i=1;
			
			while(i<index) {
				pointer = pointer.next;
				i++;
			}
			
			pointer.next = pointer.next.next;
			this.size--;
		}
		
		public void print() {
			Node<T> pointer = this.head;
			
			while(pointer!=null) {
				System.out.print(pointer.data + " ");
				pointer = pointer.next;
			}
			
		}
		
		public void reverseLinkedList() {
			if(this.head == null) {
				System.out.println("head is null");
				return;
			}
			
			if(this.head.next == null) {
				System.out.println("only one element, already reversed");
				return;
			}
			
			Node<T> currPointer = this.head;
			Node<T> prevPointer = null;
			
			while(currPointer !=null) {
				Node<T> nextPointer = currPointer.next;
				currPointer.next = prevPointer;
				
				
				prevPointer = currPointer;
				currPointer = nextPointer;
			}
			
			this.head = prevPointer;
			
			
		}
		
		
	}
	
	
	

	
	public static void main(String[] args) {
		/*
		 * there are multiple ways to check if a linked list is palindrome or not
		 * first, we can copy all the elements of LL in array and then check if array is palindrome or not
		 * but this will require us to create a new area of memory
		 * 
		 * so we will try to solve this by no creating anything new
		 * we can go to mid point of the LL and then reverse it from there and then compare both the halves
		 * 
		 */

		SinglyLinkedList<Integer> ll = new G_22_IsLinkedListPalindrome.SinglyLinkedList<Integer>();
		
		ll.addFirst(2);
		ll.print();
		System.out.println();
		ll.addFirst(5);
		ll.print();
		System.out.println();
		ll.addFirst(9);
		ll.print();
		System.out.println();
		ll.addLast(1);
		ll.print();
		System.out.println();
		ll.addLast(8);
		ll.print();
		System.out.println();
		
		ll.removeAt(2);
		ll.print();
		System.out.println();
		
		ll.reverseLinkedList();
		ll.print();
		
	}

}
