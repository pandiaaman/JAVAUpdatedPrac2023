package DSALogics;

import java.util.ArrayList;

public class G_251_BinarySearchTree {

	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}	
	}
	
	public static Node insertNode(Node root, int i) {
		
		if(root == null) {
			root = new Node(i);
			return root;
		}
		else {
			if(i < root.data) { //I FORGOT TO USE root.left = and root.right = HERE
				root.left =  insertNode(root.left, i);
			}else{
				root.right =  insertNode(root.right, i);
			}
		}
		return root;
	}
	
	public void inOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
	}
	
	public Node buildTree(int[] nodes) {
		Node root = null;
		for(int i : nodes) {
			root = insertNode(root, i);
		}
		return root;
	}
	
	public boolean search(Node root, int key) {
		
		if(root == null) {
			return false;
		}
		if(root.data == key) {
			return true;
		}
		if(key<root.data) { // I FORGOT TO PUT RETURN HERE
			return search(root.left, key);
		}else {
			return search(root.right, key);
		}
	}
	
	public Node delete(Node root, int key) {
		
	
		
		if(key < root.data) { // I DID NOT WRITE root.left = PART AND DIRECTLY CALLED THE dELETE method
			root.left = delete(root.left, key);
		}
		else if(key > root.data) {
			root.right = delete(root.right, key);
		}else {//root.data == key
			//when the node has no children
			if(root.left == null && root.right == null) {
				return null;
			}
			//when node has either left or right child
			else if(root.left == null) {
				return root.right;
			}
			else if(root.right == null) {
				return root.left;
			}
			//when node has both left and right child  
			else { //we try to find the left most node in the right subtree : the value that is just higher then the node to be deleted
				Node inOrdSucc = inOrderSuccessor(root.right);
				root.data = inOrdSucc.data;
				root.right = delete(root.right, inOrdSucc.data); //VERY IMP
			}
		}
		return root;
	}
	
	private static Node inOrderSuccessor(Node root) {
		if(root.left == null) {
			return root;
		}
		return inOrderSuccessor(root.left);
	}
	
	public void printInRange(Node root, int x, int y) {
		//both inclusive
		if(root == null) {
			return;
		}
		
		printInRange(root.left,x,y);
		if(root.data>=x && root.data<=y) {
			System.out.println(root.data);
		}
		printInRange(root.right,x,y);
		
	}
	
	public void printInRangeOptimized(Node root, int x, int y) {
		
		if(root == null) {
			return;
		}
		if(root.data >= x && root.data <= y) {
			printInRangeOptimized(root.left, x, y);
			System.out.println(root.data + " ");
			printInRangeOptimized(root.right, x, y);
		}
		else if(root.data >= y) {
			printInRangeOptimized(root.left, x, y);
		}
		else {
			printInRangeOptimized(root.right, x, y);
		}
	}
	
	static int paths = 0;
	public void rootToLeafPathsCount(Node root) {
		if(root == null) {
			return; 
		}
		if(root.left == null && root.right ==null) {
			paths++;
			return;
		}
		
		rootToLeafPathsCount(root.left);
		rootToLeafPathsCount(root.right);
		
	}
	
	
	public void printRootToLeafPaths(Node root, ArrayList<Integer> path) {
		
		if(root == null) {
			return;
		}
		
		
		//we do a preorder traversal and check
		path.add(root.data);
		
		if(root.left == null && root.right == null) { //leaf node
			for(Integer i : path) {
				System.out.print(i + " ");
			}
			System.out.println();
			
			return;
		}
		else { ///non leaf node
			printRootToLeafPaths(root.left, path);
			printRootToLeafPaths(root.right, path);
		}
		path.remove(path.size()-1); //understand this
	}
	
	public static void main(String[] args) {
		int[] nodes = new int[] {8,5,11,9,15,13,19,21,20};
		
		G_251_BinarySearchTree BST = new G_251_BinarySearchTree();
		
		Node root = BST.buildTree(nodes);
		
		BST.inOrderTraversal(root);
		
		System.out.println(BST.search(root,11));
		System.out.println(BST.search(root,17));
		
		insertNode(root, 17);
		System.out.println(BST.search(root,17));
		BST.inOrderTraversal(root);
		System.out.println();
		
		BST.delete(root, 19);
		BST.inOrderTraversal(root);
		
		BST.printInRange(root, 9, 19);
		BST.printInRangeOptimized(root, 9, 19);
		
		BST.rootToLeafPathsCount(root);
		System.out.println(paths);
		
		BST.printRootToLeafPaths(root, new ArrayList<Integer>());
	}

}
