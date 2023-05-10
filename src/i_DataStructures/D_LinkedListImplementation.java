package i_DataStructures;

public class D_LinkedListImplementation {

	public static void main(String[] args) {
		D_LinkedList ll = new D_LinkedList();
		System.out.println("initial list : " + ll);
		System.out.println("initial size : " + ll.getSize());

		ll.addFirst(1);
		ll.addFirst(3);
		
		System.out.println("middle list : " + ll);
		System.out.println("middle size : " + ll.getSize());
	}

}
