package i_DataStructures;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class A_Stack {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		System.out.println("is stack empty? " + stack.isEmpty());

		//lets push
		stack.push("vaibhav");
		stack.push("sourav");
		stack.push("anisha");
		stack.push("aman");
		stack.push("kunal");
		
		System.out.println("stack : " + stack);
		
		System.out.println("peeking last item :" + stack.peek());
		
		System.out.println("peeking does not delete item : " + stack);
		
		try {
		stack.pop(); //removes the last item => LILO
		}catch(EmptyStackException e) { //if the stack is empty : Runtime exception
			System.out.println(e);
		}
		System.out.println("stack after pop : " + stack);
		
		//to search an item
		System.out.println(stack.search("aman")); //last item is the first item
		//if item is not found then the result of search will be -1
		System.out.println(stack.search("angela"));
		
		
		//practical application of stack 
		/*
		 * undo/redo feature in the text editor
		 * moving forward/backward in the browser history tabs
		 * backtracking algos
		 * calling functions call stacks
		 */
		
		
		
		
	}

}
