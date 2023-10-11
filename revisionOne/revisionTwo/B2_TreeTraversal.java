package revisionTwo;

import java.util.LinkedList;
import java.util.Queue;

public class B2_TreeTraversal {

	static class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
			this.left = this.right = null;
		}
	}
	
	static class BinaryTree{
		
		static int index = -1;
		
		public Node buildTree(int[] nodes) {
			index++;
			
			if(nodes[index] == -1) {
				return null;
			}
			
			Node node = new Node(nodes[index]);

			node.left = buildTree(nodes);
			node.right =  buildTree(nodes);
			
			return node;
		}
		
		public void preOrderTraversal(Node root) {
			if(root == null) {
				return;
			}
			
			System.out.print(root.value + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
		
		public void inOrderTraversal(Node root) {
			if(root == null) {
				return;
			}
			
			inOrderTraversal(root.left);
			System.out.print(root.value + " ");
			inOrderTraversal(root.right);
		}
		
		public void postOrderTraversal(Node root) {
			if(root == null) {
				return;
			}
			
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.value + " ");
		}
		
		public void levelOrderTraversal(Node root) {
			
			Queue<Node> queue = new LinkedList<Node>();
			
			queue.offer(root);
			queue.offer(null);
			
			while(!queue.isEmpty()) {
				Node polledNode = queue.poll();
				
				if(polledNode == null) {
					if(!queue.isEmpty()) {
						queue.offer(null);
					}else {
						break;
					}
				}
				else {
					System.out.print(polledNode.value + " ");
					if(polledNode.left!=null) {
						queue.offer(polledNode.left);
					}
					if(polledNode.right!=null) {
						queue.offer(polledNode.right);
					}
				}
			}
		}
		
		
		public int countNodes(Node root) {
			
			if(root == null) {
				return 0;
			}
			
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
		
		public int sumOfNodes(Node root) {
			if(root == null) {
				return 0;
			}
			
			return sumOfNodes(root.left) + sumOfNodes(root.right) + root.value;
		}
		
		public int heightOfTree(Node root) {
			if(root == null) {
				return 0;
			}
			
			return Math.max(heightOfTree(root.left),heightOfTree(root.right)) + 1;
		}
		
		public int diameterOfTree(Node root) {
			if(root == null) {
				return 0;
			}
			
			int diam1 = diameterOfTree(root.left);
			int diam2 = diameterOfTree(root.right);
			int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
			
			return Math.max(Math.max(diam1,diam2), diam3);
		}
		
	}
	
	
	public static void main(String... args) {
		System.out.println("tree traversals");
		
		int[] nodes = new int[] {9,2,3,-1,-1,5,-1,-1,7,6,-1,-1,-1};
		
		BinaryTree bt = new BinaryTree();
		Node root = bt.buildTree(nodes);
		System.out.println(root.value);
		
		bt.preOrderTraversal(root);
		System.out.println();
		bt.inOrderTraversal(root);
		System.out.println();
		bt.postOrderTraversal(root);
		System.out.println();
		bt.levelOrderTraversal(root);
		System.out.println();
		System.out.println(bt.countNodes(root));
		System.out.println(bt.sumOfNodes(root));
		System.out.println(bt.heightOfTree(root));
		System.out.println(bt.diameterOfTree(root));
	}
}
