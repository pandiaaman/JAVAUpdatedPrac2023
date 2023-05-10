package c_DataStrucutures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class E_LinkedList {

	public static void main(String[] args) {
		// linked list provides various advantages over arrays or arrayList
		//arrays are static and arrayList are dynamic, but both store values in contiguous memory locations
		//linked list on the other hand, helps us to store the data in non contiguous manner and connects the data with addresses
		//linked list makes it easier to add/remove elements from a location
		//but to access an element at a given position is harder in linked list and takes time
		
		//implements List, Dequeue(extends Queue), Serializable, Cloneable
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		linkedList.add(3);
		linkedList.add(5);
		linkedList.add(1);
		linkedList.add(7);
		linkedList.add(4);
		
		System.out.println(linkedList);
		
		//linkedlist implments both stack's (push pop peek) and queue's methods(offer poll element)
		
		//implementing stack methods : should add on top and remove from top
		linkedList.push(2);
		linkedList.push(9);
		System.out.println(linkedList.peek());
		System.out.println(linkedList);
		
		System.out.println(linkedList.pop());
		System.out.println(linkedList.pop());
		System.out.println(linkedList);
		
		//implementing queue methods : should add to back and remove from front
		linkedList.offer(2);
		linkedList.offer(9);
		
		System.out.println(linkedList.element());
		System.out.println(linkedList);
		
		System.out.println(linkedList.poll());
		System.out.println(linkedList);
		
		//implementing linked List
		linkedList.remove(); //removes from front
		System.out.println(linkedList);
	}

}
