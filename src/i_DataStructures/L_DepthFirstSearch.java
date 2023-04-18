package i_DataStructures;

import java.util.ArrayList;
import java.util.Stack;

class NodeDFS{
	char data;
	NodeDFS(char data){
		this.data = data;	}
}

class GraphDFS{ //making a adjacency matrix graph
	int[][]matrix;
	
	ArrayList<NodeDFS> nodesList = new ArrayList<NodeDFS>();
	
	GraphDFS(int noOfNodes){
		matrix = new int[noOfNodes][noOfNodes];
	}
	
	//addNode
	public void addNode(char c) {
		NodeDFS newNode = new NodeDFS(c);
		nodesList.add(newNode);
	}
	//addEdge
	public void addEdge(int src, int des) {
		matrix[src][des] = 1;
	}
	//checkEdge
	public boolean checkEdge(int src, int des) {
		return (matrix[src][des] == 1);
	}
	//print
	public void print() {
		System.out.print("  ");
		//printing headers
		for(NodeDFS node : nodesList) {
			System.out.print(node.data + " ");
		}
		System.out.println();
		for(int i = 0 ; i < matrix.length ; i++) {
			System.out.print(nodesList.get(i).data + " ");
			for(int j = 0; j < matrix[i].length ; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	//depthfirst search
	public void depthFirstSearch(int src) {
		boolean[] visited  = new boolean[matrix.length]; //used only to verify if we have come here or not, if we visit a node, mark it 1
		dfsHelperRecursion(src, visited);
	}
	

	private void dfsHelperRecursion(int src, boolean[] visited) {
		
		//checking if the src node is visited or not
		if(visited[src]) {
			return; //base case
		}else {
			visited[src] = true;
			System.out.print(nodesList.get(src).data + " ");
		}
		
		for(int i = 0; i<matrix[src].length ; i++) {
			if(matrix[src][i] == 1) {
				dfsHelperRecursion(i, visited); //recursive call 
			}
		}
		return;
	}
	
}

public class L_DepthFirstSearch {

	public static void main(String[] args) {
		// DFS : used for traversing a tree or graph data structure
		/*'
		 * STEPS
		 * pick a route
		 * keep on going until we reached a dead end or a previously visited node
		 * backtrack to the last node that has unvisited adjacent neighbors
		 */

		/*
		 * https://www.youtube.com/watch?v=by93qH4ACxo&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=120
		 * we will implement this using the stack
		 * to traverse a graph, we keep moving to the next node until we find an already visited node or dead end
		 * we keep track of this by adding the nodes to a stack
		 */
		
		GraphDFS graph = new GraphDFS(5);
		
		graph.addNode('a');
		graph.addNode('b');
		graph.addNode('c');
		graph.addNode('d');
		graph.addNode('e');
		
//		graph.addEdge(1, 0);
//		graph.addEdge(3, 4);
//		graph.addEdge(2, 0);
//		graph.addEdge(3, 1);
//		graph.addEdge(2, 4);
//		graph.addEdge(4, 1);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);

		graph.print();
		
		graph.depthFirstSearch(0);
	}

}
