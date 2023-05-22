package DSALogics;
import java.util.*;
import java.util.stream.Collectors;

public class G_2_LinkedList {

	public static void main(String[] args) {
		// implements doubly linked list internally, we can implement both stack and queue using this
		
		LinkedList<Integer> ls = new LinkedList<Integer>();

		ls.add(3);
		ls.add(7);
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
		
		
		Iterator<Integer> itr = ls.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		ls.addFirst(6);
		ls.addFirst(8);
		List<Integer> lss = ls.stream().filter(x->x%2==0).map(x->x*x).collect(Collectors.toList());//.forEach(x->System.out.print(x + " "));
		lss.stream().forEach(x->System.out.println(x));
	}

}
