package c_DataStrucutures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B_Queues {

	public static void main(String[] args) {
		// Queues are FIFO : 
		/*
		 * push : add : enqueue : offer
		 * pop : remove : dequeue : poll
		 * peek to see
		 */
		//Queue is an interface, hence we can not create an object of interface directly
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		
		System.out.println(queue.poll());
		
		System.out.println(queue);
		
		System.out.println(queue.element()); //like peeking or peek method in stack

		
		Scanner sc = new Scanner(System.in);
		List<Integer> lst1 = new ArrayList<Integer>();
		List<Integer> lst2 = new ArrayList<Integer>();
		
		
		
		//checking retainAll method
		System.out.println("enter the elements in both arrays");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		int p;
		for(int i = 1; i<=n1; i++) {
			System.out.println("enter next element in first array");
			p = sc.nextInt();
			lst1.add(p);
		}
		for(int i = 1; i<=n2; i++) {
			System.out.println("enter next element in second array");
			p = sc.nextInt();
			lst2.add(p);
		}
		
		lst1.forEach(x-> System.out.print(x + " "));
		System.out.println();
		lst2.forEach(x-> System.out.print(x + " "));
		
		lst1.retainAll(lst2);
		System.out.println();
		lst1.forEach(x->System.out.println(x + "-> "));
	}

}
