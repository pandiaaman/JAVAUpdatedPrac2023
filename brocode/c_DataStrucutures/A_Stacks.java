package c_DataStrucutures;

import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class A_Stacks {

	public static void main(String[] args) {
		//stack is LIFO : we use it in scenarios where we need to fetch the latest item entered into the DS
		//used in scenarios like undo, moving backward/forward through browser history
		//stores objects into vertical towers
		
		//stacks extends Vector
		Stack<Integer> stack = new Stack<Integer>();
		int a = stack.push(1); // as we can see push returns the added element
//		int b = stack.add(9); //add does not return the added element
		stack.add(9); //better use push
		//both push and add are synchronized
		stack.push(2);
		stack.push(5);
		stack.push(3);
		stack.push(10);
		stack.push(6);
		
//		Collections.sort(stack); // sorts the stack in descending
//		Collections.sort(stack, new Comparator<Integer>() { //sorts the stack in ascending
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				
//				return o2-o1;
//			}
//
//		});
		
		System.out.println(stack.peek());
		
		System.out.println(stack);
		
		stack.pop();
		System.out.println(stack);
		
		System.out.println(stack.pop());
		
		System.out.println(stack);
		
		stack.add(7);
		System.out.println(stack);
		
		System.out.println(stack.size());
		
		stack.forEach(x->{
			System.out.print(x + " -> ");
		});
		
		
		Stack<String> stack2 = new Stack<String>();
		//push,pop,peek,empty,search
		
		System.out.println("is stack2 empty? " + stack2.empty());
		
		//searching an element
		int searchres = stack.search(5);
		System.out.println(searchres);
		
		
		System.out.println(stack.peek());
		

	}

}
