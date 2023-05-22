package DSALogics;

import java.util.Stack;

public class G_23_QueueUsingTwoStacks {

	static class QueueUsingStacks{
		public static Stack<Integer> stack1 = new Stack<Integer>();
		public static Stack<Integer> stack2 = new Stack<Integer>();
		
		//offer
		public void add(int n) {
			if(stack1.isEmpty()) {
				stack1.push(n);
			}
			else {
				//moving all elements from stack 1 to stack 2 before entering new element in stack1 
				while(!stack1.isEmpty()) {
					int temp = stack1.pop();
					stack2.push(temp);
				}
				//entering element in stack1
				stack1.push(n);
				//putting all the elements back from stack 2 to stack 1
				while(!stack2.isEmpty()) {
					int temp = stack2.pop();
					stack1.push(temp);
				}
			}
			
		}
		
		//poll
		public int remove() {
			
			if(stack1.isEmpty()) {
				System.out.println("empty stack");
				return -1;
			}
			return stack1.pop();
		}
		
		public void print() {
			System.out.println(stack1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueUsingStacks q = new G_23_QueueUsingTwoStacks.QueueUsingStacks();
		q.add(2);
		q.add(3);
		q.add(5);
		q.add(7);
		q.add(9);
		
		q.print();
		q.remove();
		
		q.print();
	}

}
