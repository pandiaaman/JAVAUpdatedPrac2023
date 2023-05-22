package DSALogics;

import java.util.LinkedList;
import java.util.Queue;

public class G_24_BinaryTree {

	static class Node<T>{
		private T data;
		private Node<T> leftChild;
		private Node<T> rightChild;
		
		Node(T data){
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(Node<T> leftChild) {
			this.leftChild = leftChild;
		}

		public Node<T> getRightChild() {
			return rightChild;
		}

		public void setRightChild(Node<T> rightChild) {
			this.rightChild = rightChild;
		}
		
		
	}
	
	static class BinaryTree<T>{
			
		static int index = -1;
		
		public Node<T> buildTree(T[] nodes){
			index++;
			
			if(Integer.parseInt(nodes[index].toString()) == -1) {
				return null; // no nodes in right or left child
 			}
			
			Node<T> node = new G_24_BinaryTree.Node<T>(nodes[index]);
			node.leftChild = buildTree(nodes);
			node.rightChild = buildTree(nodes);
			
			
			return node;
		}
		
		public void printTreePreOrder(Node<T> root) {
			//depth first traversal
			if(root == null) {
				System.out.print("-1 ");
				return;
			}
			
			System.out.print(root.getData() + " ");
			printTreePreOrder(root.getLeftChild());
			printTreePreOrder(root.getRightChild());
		}
		
		public void printTreeInOrder(Node<T> root) {
			if(root == null) {
				System.out.print("-1 ");
				return;
			}
			
			printTreeInOrder(root.getLeftChild());
			System.out.print(root.getData() + " ");
			printTreeInOrder(root.getRightChild());
			
		}
		
		public void printTreePostOrder(Node<T> root) {
			if(root == null) {
				System.out.print("-1 ");
				return;
			}
			
			printTreePostOrder(root.getLeftChild());
			printTreePostOrder(root.getRightChild());
			System.out.print(root.getData() + " ");
			
		}
		
		
		
		public void levelOrderTraversal(Node<T> root) {
			if(root == null) {
				return;
			}
			//Breadth first traversal
			
			//create a queue : offer nodes one by one : on polling we offer left and right child of that node
			//to see where the level changes, we will store null right after we store the root
			//and whenever we poll null value, we put it back in again in the queue
			
			Queue<Node<T>> queue = new LinkedList<Node<T>>();
			
			queue.offer(root);
			queue.offer(null);
			
			while(!queue.isEmpty()) {
				Node<T> polledNode = queue.poll();
				
				if(polledNode == null) {
					System.out.println();
					if(queue.isEmpty()) {
						break;
					}else {
						queue.offer(null);
					}
				}else {
					System.out.print(polledNode.getData() + " ");
					if(polledNode.getLeftChild()!= null)
						queue.offer(polledNode.getLeftChild());
					if(polledNode.getRightChild()!=null)
						queue.offer(polledNode.getRightChild());	
				}	
			}
	
		}
		
		

		public int countNodes(Node<T> root) {
			if(root == null) {
				return 0;
			}
	
			return countNodes(root.getRightChild()) +  countNodes(root.getLeftChild()) + 1;
			
		}
		
		//left subtree ka sum nikal lo aur right sub tree ka sum nikal lo aur fir dono ko add kardo aur usme
		//root ki value ko add karo kyuki root ki value apne ko node ki value batayegi
		public int sumOfNodes(Node<T> root) {
			if(root == null) {
				return 0;
			}
			
			return sumOfNodes(root.getLeftChild()) + sumOfNodes(root.getRightChild()) +(int) root.getData(); 
		}
		
		//left subtree aur right subtree ki height nikalo aur unme se jo max hai vo result hai
		public int heightOfTree(Node<T> root) {
			
			if(root == null) {
				return 0;
			}
			int leftHeight = heightOfTree(root.getLeftChild());
			int rightHeight = heightOfTree(root.getRightChild());
			
			int myHeight = Math.max(leftHeight, rightHeight) + 1; //adding one for the root
			
			return myHeight;
		}
		
		//diameter of tree : no of nodes in the longest path between any two nodes
		//solution : either diameter goes through the root or it doesnt go through the root
		//this way we get O(n^2)
		public int diameter(Node<T> root) {
			if(root == null) {
				return 0;
			}
			
			int diam1 = diameter(root.getLeftChild());
			int diam2 = diameter(root.getRightChild());
			int diam3 = heightOfTree(root.leftChild) + heightOfTree(root.rightChild) + 1;
			
			return Math.max(diam3, Math.max(diam1, diam2));
			
		}
		
		//diameter using O(N) : in the above method we calculated height separately
		//motive is to calculate the height while calculating the diameter	 
		static class TreeDiamInfo{
			//contains details about the height and diameter
			int height;
			int diameter;
			
			TreeDiamInfo(int ht, int diam){
				this.height = ht;
				this.diameter = diam;
			}
		}
		
		public TreeDiamInfo diameter2(Node<T> root) {
			
			if(root == null) {
				return new TreeDiamInfo(0,0);
			}
			
			TreeDiamInfo leftInfo = diameter2(root.getLeftChild());
			TreeDiamInfo rightInfo = diameter2(root.getRightChild());
			
			int myHeight = Math.max(leftInfo.height, rightInfo.height) + 1;
			
			int diam1 = leftInfo.diameter;
			int diam2 = rightInfo.diameter;
			int diam3 = leftInfo.height + rightInfo.height + 1;
			
			int myDiam = Math.max(diam1, Math.max(diam2, diam3));
			
			TreeDiamInfo myInfo = new TreeDiamInfo(myHeight, myDiam);
			return myInfo;
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] nodes = new Integer[] {9,2,3,-1,-1,5,-1,-1,7,6,-1,-1,-1};
		
		BinaryTree<Integer> bt = new G_24_BinaryTree.BinaryTree<Integer>();
		
		Node<Integer> root = bt.buildTree(nodes);
		
		System.out.println(root.getData());
		
		bt.printTreePreOrder(root);
		System.out.println();
		bt.printTreeInOrder(root);
		System.out.println();
		bt.printTreePostOrder(root);
		System.out.println();
		bt.levelOrderTraversal(root);
		
		System.out.println(bt.countNodes(root));
		System.out.println(bt.sumOfNodes(root));
	}

}
