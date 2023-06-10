package DSALogics;

public class G_25_BinarySearchTree {
/*
 * binary search tree because of its search quality
 * in normal binary tree, we have search in O(n) where n is the nodes in the tree
 * but in the binary search tree, we can go for O(H) where h is the height of the tree
 * in general the height of the tree is (log n) hence the search time complexity is O(log n)
 * 
 * binary search tree is used for fast lookup
 * 
 * ==> properties of binary search tree
 * 		it is a binary tree : atmost only two children for each node
 * 		left subtree node < root
 * 		root < right subtree node
 * 		BST contains NO duplicates and respective left and right subtree of each node is also a BST
 * 
 * 		it is similar to binary search, we compare the value of the key to be searched with the root
 * 		if the key is less than the root value, we search in the left subtree, else in the right subtree
 * 		if the key matches the root, we return the root
 * 
 * complexity to search is O(height) :
 * 	in skewed trees, the search time complexity in worst case scenarios can be O(n)
 * 
 * Binary search tree : solved using recursion
 * 
 * time complexity of insertion is similar to the time complexity of search ie log(height)
 * 	each value entering is compared with the root and the direction is decided accordingly
 */
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static class BST{
	
		public Node buildTree(int[] nodes) {
			
			Node root = null;
			for(int i=0; i< nodes.length; i++) {
				root = insert(root, nodes[i]);
			}
			System.out.println("root is " + root.data);
			return root;
		}
		
		public Node insert(Node root, int value) {
			if(root == null) {
				root = new Node(value);
				return root;
			}
			
			else if(value < root.data) {
				//insert in left subtree
				root.left = insert(root.left, value);
			}
			else {
				root.right = insert(root.right, value);
			}
			
			return root;
			
		}
		
		//in order traversal
		public void inOrderTraversal(Node root) {
			if(root == null) {
				return;
			}
			
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
			
		}
		
		public boolean search(Node root, int key) {
			if(root == null) {
				return false;
			}
						
			if(root.data > key) {
				//go to lst
				return search(root.left, key);
			}
			else if(root.data < key) {
				//go to right
				return search(root.right, key);
			}
			else {
				return true;
			}
			
		}
		
		/*
		 * deletion says to delete the given node and replace it with the inorder successor
		 * to search for the inorder successor : we keep tracking the right child until we find the left most node
		 * we can also say we look for the left most node in the right subtree of the node that we wish to delete
		 * until the left node of the left child is null
		 */
		public Node delete(Node root, int key) {
			
			if(key<root.data) {
				root.left = delete(root.left, key);
			}
			else if(key > root.data) {
				root.right = delete(root.right, key);
			}
			else {//root.data == key
				//case 1  : we are on a leaf node
				if(root.left == null && root.right == null) {
					return null; //node's actual value will be permanently lost
				}
				
				//case 2 : contains the right child
				if(root.left == null) {
					return root.right;
				}else if(root.right ==null) {
					return root.left;
				}
				
				//case 3 : need to find the inorder successor : left most node in the right sub	tree
				Node inordSucc = inorderSuccessor(root.right); 
				root.data = inordSucc.data;
				root.right = delete(root.right, inordSucc.data);
			}
			return root;
		}
		

		public Node inorderSuccessor(Node root) {
			while(root.left!=null) {
				root = root.left;
			}
			
			return root;
		}
	}
	
	
	public static void main(String[] args) {
		int values[] = {5,1,3,4,2,7};

		BST bst = new BST();
		Node root = bst.buildTree(values);
		
		bst.inOrderTraversal(root);
		System.out.println(bst.search(root, 3));
		System.out.println(bst.search(root, 9));
	}

}
