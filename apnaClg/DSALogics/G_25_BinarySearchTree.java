package DSALogics;

public class G_25_BinarySearchTree {

	
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
		
	}
	
	
	public static void main(String[] args) {
		int values[] = {5,1,3,4,2,7};

		BST bst = new BST();
		Node root = bst.buildTree(values);
		
		bst.inOrderTraversal(root);
	}

}
