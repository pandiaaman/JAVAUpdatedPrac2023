package DSALogics;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;



public class A_1_ArraysIntro {
	public static void main(String[] args) {
	//arrays can be defined in different ways
	int[] a = new int[5];//defines an array with length 5
	int len = a.length;
	System.out.println("length of the array is : " + len);
	
	int ar[] = new int[10];//another way of defining an array
	System.out.println("legth of array is :" + ar.length);
	
	int arr[] = new int[] {1,2,3,4,5}; // define right then
	for(int i:arr) { //use of for each loop in java
		System.out.println(i);
	}
	
	//2d arrays
	int[][] arr2d = new int[3][4];
	System.out.println("length of the 2d array : " + arr2d.length + " * " + arr2d[0].length);
	
	int []arr2d2[] = new int[][] {{1,2},{3,4,8},{1,4},{2,3,45,5}};
	for(int i[]:arr2d2) { // OR for(int[] i:arr2d2) 
		for(int j:i) {
			System.out.print(j + " ");
		}
		System.out.println("");
	}
	
	//taking inputs for an array
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the length of the array");
//	int k = sc.nextInt();
//	int arr1[] = new int[k];
//	System.out.println("enter the values in the array");
//	for(int i:arr1) {	// since i here defines the value of the array not the key we cant take input using this
//	}
//	for(int i=0; i<k;i++) {
//		arr1[i] = sc.nextInt();
//	}
//	
//	for(int i:arr1) {
//		System.out.print(i + " ");
//	}
//	
	
	int[] arrrr = new int[] {2,3,5,6,3,4,56,2,6};
	
	reverse(arrrr);
	for(int i=0;i<arrrr.length;i++) {
		System.out.print(arrrr[i] + " ");
	}
	
	System.out.println();
	Stack<Integer> st = new Stack<Integer>();
	st.push(2);
	st.push(3);
	st.push(6);
	
	System.out.println(st);
	
	pushAtBottomOfStack(st, 5);
	//st.pop();
	System.out.println(st);
	
	LinkedList<Integer> ll = new LinkedList<Integer>();
	ll.push(1);
	ll.addFirst(3);
	ll.offer(7); //queue : sab kuch last se judta hai
	
	System.out.println(ll);
	
	
	reverseStack(st);
	System.out.println(st);
	
	
	
	
	}
	
	
	public static void reverseStack(Stack<Integer> stack) {
		
		if(stack.isEmpty()) {
			return;
		}
		
		int i = stack.pop();
		reverseStack(stack);
		pushAtBottomOfStack(stack,i);
	}
	
	public static void pushAtBottomOfStack(Stack<Integer> stack, int n) {
		
		if(stack.isEmpty()) {
			stack.push(n);
			return;
		}
		
		int i = stack.pop();
		pushAtBottomOfStack(stack, n);
		stack.push(i);
		
	}
	
	
	public static void reverse(int[] arr) {
		for(int i=0;i<arr.length/2;i++) {
			int other =  arr.length-i-1;
			int temp = arr[i];
			arr[other] = temp;
		}
	}
}
