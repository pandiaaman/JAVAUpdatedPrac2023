package c_DataStrucutures;

import java.util.Deque;
import java.util.LinkedList;

//
		//https://www.youtube.com/watch?v=-DzowlcaUmE&t=2833s
//
public class Qa_CreateBinartyTree<T> {

	static class Node<T>{
		private T data;
		private Node<T> left;
		private Node<T> right;
		
		public Node(T data) {
			System.out.println("node created with data "+ data);
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}
		
	}
	
	
	//building tree
	static int index = -1;
	
	public Node<T> buildTree(T[] nodes){ //mistake : we were ealier using the while loop along with recursion :/
		index++; //value of index becomes 0

		if(nodes[index] == null) {
			return null;
		}
		Node<T> newNode = new Node<T>(nodes[index]);
//		System.out.println("added " + newNode.getData());
		newNode.setLeft(this.buildTree(nodes));
		newNode.setRight(this.buildTree(nodes));

		return newNode;
	}
	
	//traversals
	
	//pre order traversal
	public void preOrderTraversal(Node<T> root) {
		//root left right
		if(root == null) {
			System.out.print(" ");
			return;
		}
		
		System.out.print(root.getData() + " ");
		this.preOrderTraversal(root.getLeft());	
		this.preOrderTraversal(root.getRight());
	}
	
	
	//inorder traversal
	public void inOrderTraversal(Node<T> root) {
		//left root right
		if(root == null) {
			System.out.print(" ");
			return;
		}
		
		this.inOrderTraversal(root.getLeft());
		System.out.print(root.getData() + " ");
		this.inOrderTraversal(root.getRight());
	}
	
	//post order traversal
	public void postOrderTraversal(Node<T> root) {
		//left root right
		if(root == null) {
			System.out.print(" ");
			return;
		}
		
		this.postOrderTraversal(root.getLeft());
		this.postOrderTraversal(root.getRight());
		System.out.print(root.getData() + " ");
	}
	
	//level order traversal
	public void levelOrderTraversal(Node<T> root) {
		//this requires us to traverse through the tree in a breadth first manner
		//for breadth first traversal, we need queue implementation, we can implement queue using linkedLIst or Deque
		//since we know deque is faster, we will go with deque
		//queue is FIFO
		Deque<Node<T>> queue = new LinkedList<Node<T>>();
		//queue offers us methods like offer, poll and element 
		queue.offer(root);
		queue.offer(null);
		
		while(!queue.isEmpty()) {
			Node<T> node = queue.poll();
		
			if(node == null) {
				System.out.println();
				if(queue.isEmpty()) {
					break;
				}
				queue.offer(null);
			}else {
				System.out.print(node.getData() + " ");
				if(node.getLeft() != null) {
					queue.offer(node.getLeft());
				}
				if(node.getRight() != null) {
					queue.offer(node.getRight());
				}
			}
	
		}
	}
	
	//count using recursion
	public int countNodes(Node<T> root) {
		if(root == null) {
			return 0;
		}
		
		return countNodes(root.getLeft()) + countNodes(root.getRight()) + 1 ;
	}
	
	//sum of all nodes
	public int sumAllNodes(Node<T> root) {
		if(root == null) {
			return 0;
		}
		return sumAllNodes(root.getLeft()) + sumAllNodes(root.getRight()) + (int)root.getData();
	}
	
	//height of tree
	public void heightTreeUsingQueue(Node<T> root) {
		Deque<Node<T>> queue = new LinkedList<Node<T>>();
		
		queue.offer(root);
		queue.offer(null);
		
		int count = 0;
		
		while(!queue.isEmpty()) {
			Node<T> node = queue.poll();
			
			if(node == null) {
				
				count++;
				if(queue.isEmpty()) {
					break;
				}
				queue.offer(null);
			}
			else {
				if(node.getLeft()!= null) {
					queue.offer(node.getLeft());
				}
				if(node.getRight()!= null) {
					queue.offer(node.getRight());
				}
			}
		}
		
		System.out.println("height of tree :" + count);
	}
	
	//tree height using recursion
	public int heightTreeUsingRecursion(Node<T> root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = heightTreeUsingRecursion(root.getLeft());
		int rightHeight = heightTreeUsingRecursion(root.getRight());
		
		return Math.max(leftHeight, rightHeight) + 1 ; //adding one for the root node
	}
	
	
	//diameter of tree
		//we will calculate the diameter of the left sub tree and right sub tree and then the sum of them 
		//we then select the max value out of them
	//the time complexity is O(n^2)
	public int diameter(Node<T> root) {
		if(root == null) {
			return 0;
		}
		
		int leftDiameter = diameter(root.getLeft()); //in case the diameter exists in the left subtree
		int rightDiameter = diameter(root.getRight());// in case the diameter exists in the right subtree
		//case where the diameter passes through the node, so height of left + height of right + root node
		int diameter3 = heightTreeUsingRecursion(root.getLeft()) + heightTreeUsingRecursion(root.getRight()) + 1;
		return Math.max(Math.max(leftDiameter, rightDiameter), diameter3);
	}
	
	//finding the diameter in the linear time complexity : O(N)
		//this can be done if we do not need to call the height method for every call of diameter
		//we can store the height and diameter info for every node when creating the tree itself
	//below treeinfo and diameter2 are the class and methods to implement this
	static class TreeInfo {
		int ht;
		int diam;
		
		public TreeInfo(int ht, int diam) {
			this.ht = ht;
			this.diam = diam;
		}
	}
	
	public TreeInfo diameter2(Node<T> root) {
		
		//basecase
		if(root == null) {
			return new TreeInfo(0,0);
		}
		
		TreeInfo leftInfo = diameter2(root.getLeft());
		TreeInfo rightInfo = diameter2(root.getRight());
		
		int myHeight = Math.max(leftInfo.ht , rightInfo.ht) + 1;
		
		int diamLeft = leftInfo.diam;
		int diamRight = rightInfo.diam;
		int diam3 = leftInfo.ht + rightInfo.ht + 1;
		
		int myDiam = Math.max(Math.max(diamRight, diamLeft), diam3);
		
		TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
		return myInfo;
	}
	
	//subtree of another tree
		//there will be two trees : we can pass roots of each into this method
		//we will have two static index : to traverse through each
		//we increment the latter index if there is a match of nodes

	public boolean isSubtree(Node<T> root1, Node<T> subRoot) {
		//basecase
		if(subRoot == null) { //if subroot is null then means the root of subtree is null which will give us a match
			return true;
		}
		if(root1 == null) { //if root of main tree is null then we can return false
			return false;
		}
		
		//comparison
		if(root1.getData().equals(subRoot.getData())) {
			if(this.isIdentical(root1, subRoot)) {
				return true;
			}
		}
			return isSubtree(root1.getLeft(),subRoot) || isSubtree(root1.getRight(),subRoot);
		
	}
	
	//if the roots match, then to check if the further tree matches or not
	public boolean isIdentical (Node<T> root1, Node<T> subRoot) {
		if(root1 == null && subRoot == null) { //leaf condition and null tree condition
			return true;
		}
		if(root1 == null ||  subRoot == null) {
			return false;
		}
		if(root1.getData().equals(subRoot.getData())) {
			return isIdentical(root1.getLeft(),subRoot.getLeft()) && isIdentical(root1.getRight(), subRoot.getRight());
		}
		return false;
	}
	
	
	
	
	public static void main(String[] args) {
		
//		Integer[] nodes = new Integer[] {3, 2, 4, 9, null, null, null, 1, 7, null, 	5, null, null};
		Integer[] nodes = new Integer[] {1, 2, 4, null, null, 5, null, null, 3, null, 6, null, null};
//		Integer[] nodes = new Integer[] {1, 2, 4, 7, null, 8, null, null, null, 5, null, null, 3, null, 6, null, null};
		Qa_CreateBinartyTree<Integer> binarySearchTree = new Qa_CreateBinartyTree<Integer>();
		
		Qa_CreateBinartyTree.Node<Integer> root = binarySearchTree.buildTree(nodes);
		
		System.out.println("root : " + root.getData());
		//traversal
		System.out.printf("inorder traversal : ");
		binarySearchTree.inOrderTraversal(root);
		System.out.printf("%npreorder traversal : ");
		binarySearchTree.preOrderTraversal(root);
		System.out.printf("%npost order traversal : ");
		binarySearchTree.postOrderTraversal(root);
		System.out.printf("%nlevelorder traversal : %n");
		binarySearchTree.levelOrderTraversal(root);
		
		//counting the no of nodes
		System.out.println("count the no of nodes : " + binarySearchTree.countNodes(root));
		
		//sum of all nodes
		System.out.println("sum of all nodes : " + binarySearchTree.sumAllNodes(root));
		
		//height of tree
		binarySearchTree.heightTreeUsingQueue(root);
		
		//height of tree using recursion
		System.out.println("height of tree using recursion : " + binarySearchTree.heightTreeUsingRecursion(root));
		
		//diameter of a tree : no of nodes in the longest path between any two nodes
		System.out.println("maximum diameter of the tree : " + binarySearchTree.diameter(root));
		
		//diameter of a tree : O(N)
		System.out.println("diameter : " + binarySearchTree.diameter2(root).diam);
		
		
		//checking subtree
		Integer[] subnodes = new Integer[] {1, 2, 4, null, null, 5, null, null, 3, null, 6, null, null};
		
		Qa_CreateBinartyTree<Integer> binarySearchSubTree = new Qa_CreateBinartyTree<Integer>();
		
		Qa_CreateBinartyTree.Node<Integer> subRoot = binarySearchSubTree.buildTree(subnodes);
		
		binarySearchTree.isSubtree(root, subRoot);
	}

}
