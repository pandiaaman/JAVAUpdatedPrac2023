package i_DataStructures;


import java.util.ArrayList;

class Node{
	char data;
	
	Node(char data){
		this.data = data;
	}
}

class Graph{
	int[][] matrix;
	
	//just to get the headers of the matrix we can use array list
	ArrayList<Node> nodeHeaders;
	
	 Graph(int size) {
		//size is equal to the no of nodes
		matrix = new int[size][size];
		
		nodeHeaders = new ArrayList<>(); 
	}
	
	public void addNode(char c) {
		Node node = new Node(c);
		nodeHeaders.add(node);
	}
	
	public void addEdge(int src, int des) {
		matrix[src][des] = 1;
	}
	
	public boolean checkEdge(int src, int des) {
		return matrix[src][des]==1;
	}
	
	public void print() {
		System.out.print("  ");
		//printing header
		for(Node n : nodeHeaders) {
			System.out.print(n.data + " ");
		}
		System.out.println();
		//printing matrix
		for(int i = 0; i< this.matrix.length; i++) {
			//header
			System.out.print(nodeHeaders.get(i).data + " ");
			for(int j= 0; j< this.matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}

public class K_Graph_AdjacencyMatrix {

	public static void main(String[] args) {
		//time complexity : O(1) space complexity : O(n^2)
		/*
		 * adjacency matrix is a 2D array to store 1s and 0s to represent edges between two given nodes in graph
		 */
		Graph graph = new Graph(5); //we have 5 nodes
		
		graph.addNode('a');
		graph.addNode('b');
		graph.addNode('c');
		graph.addNode('d');
		graph.addNode('e');
		
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);
		
		graph.print();
		
		System.out.println(graph.checkEdge(0, 1));
		
	}

}
