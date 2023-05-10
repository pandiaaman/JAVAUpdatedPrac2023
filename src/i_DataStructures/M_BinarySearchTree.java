package i_DataStructures;

class NodeBST{
	int data;
	NodeBST left; //for the left child
	NodeBST right; //for the right child (null in case of leaf nodes)
	
	public NodeBST(int data) {
		this.data = data;
	}
}

class BinarySearchTree{
	NodeBST root;
	
	public void insert(NodeBST node) {
		root = insertHelper(root,node);
	}
	
	//uses recursion
	private NodeBST insertHelper(NodeBST root, NodeBST node) {
		int data = node.data;
		
		if(root == null) {
			root = node;
			return root;
		}else if(data < root.data) {
			root.left = insertHelper(root.left,node); //checking root nodes of left sub trees
		}else {
			root.right = insertHelper(root.right, node);
		}
		
		return root;
	}

	public void display() {
		displayHelper(root);
	}
	
	private void displayHelper(NodeBST root) {
		//uses recursion
		if(root == null) { //base case	
			return;
		}
		//in order traversal
		displayHelper(root.left);
		System.out.print(root.data + " ");
		displayHelper(root.right);
	}

	public boolean search(int data) {
		return searchHelper(data, root);
	}
	
	private boolean searchHelper(int data, NodeBST root) {
		if(root == null) {
			return false;
		}
		else if(root.data == data) {
			return true;
		}
		else if(root.data > data) {
			return searchHelper(data,root.left);
		}
		else {
			return searchHelper(data,root.right);
		}
	}

	public void remove(int data) {
		//first lets check if the data exists
		if(search(data)) {
			removeHelper(data, root);
		}else {
			System.out.println("can not find : " + data);
		}
	}

	private NodeBST removeHelper(int data, NodeBST root2) {
		
		if(root == null) {
			return root;
		}
		else if(data < root.data) {
			root.left = removeHelper(data, root.left);
		}
		else if(data > root.data) {
			root.right = removeHelper(data, root.right);
		}
		else { // node found
			//checking if its a leaf node
			if(root.left == null && root.right == null) {
				root = null; //node removed
			}
			else if(root.right != null) {
				//need to find a successor to replace this node, need to move the nodes around
				root.data = successor();
				root.right = removeHelper(root.data, root.right);
			}
			else {//finds a predecessor to replace this node, need to move the nodes around
				root.data = predecessor();
				root.left = removeHelper(root.data,root.left);
			}
		}
		return root;
	}

	private int predecessor() {
		//find the greatest value below the left child of this node
				root = root.left;
				while(root.right != null) {
					root = root.right;
				}
				return root.data;
	}

	private int successor() {
		//find the least value below the right child of this node
		root = root.right;
		while(root.left != null) {
			root = root.left;
		}
		return root.data;
	}
}

public class M_BinarySearchTree {

	public static void main(String[] args) {

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(new NodeBST(5));
		binarySearchTree.insert(new NodeBST(7));
		binarySearchTree.insert(new NodeBST(2));
		binarySearchTree.insert(new NodeBST(3));
		binarySearchTree.insert(new NodeBST(6));
		binarySearchTree.insert(new NodeBST(9));
		binarySearchTree.insert(new NodeBST(4));
		binarySearchTree.insert(new NodeBST(8));
		
		binarySearchTree.display();
		
		System.out.println();
		System.out.println(binarySearchTree.search(8));
		System.out.println(binarySearchTree.search(0));
		
		binarySearchTree.remove(9);
		binarySearchTree.display();
	}

}
