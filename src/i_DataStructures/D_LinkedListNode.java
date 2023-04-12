package i_DataStructures;

public class D_LinkedListNode {

	//Doubly linked list
		private Object value;
		private D_LinkedListNode prev;
		private D_LinkedListNode next;
		
		public D_LinkedListNode() {
			this.value = null;
			this.prev = null;
			this.next = null;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public D_LinkedListNode getPrev() {
			return prev;
		}

		public void setPrev(D_LinkedListNode prev) {
			this.prev = prev;
		}

		public D_LinkedListNode getNext() {
			return next;
		}

		public void setNext(D_LinkedListNode next) {
			this.next = next;
		}

		
		public String toString() {
			return ("[ " + this.value + " ]");
		}
}
