package i_DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class NodeBFS{
	char data;
	NodeBFS(char data){
		this.data = data;
		}
}

class GraphBFS{
	int[][] graphMatrix;
	
	ArrayList<NodeBFS> nodeList = new ArrayList<NodeBFS>();
	
	public GraphBFS(int noOfNodes) {
		graphMatrix = new int[noOfNodes][noOfNodes];
	}
	
	public void addNode(char data) {
		NodeBFS newNode = new NodeBFS(data);
		nodeList.add(newNode);
	}
	
	public void addEdge(int src, int des) {
		graphMatrix[src][des] = 1;
	}
	
	public boolean checkEdge(int src, int des) {
		return (graphMatrix[src][des] == 1);
	}
	
	public void print() {
		
		System.out.print("  ");
		nodeList.stream().forEach(x-> System.out.print(x.data + " "));
		System.out.println();
		for(int i=0;i<graphMatrix.length;i++) {
			System.out.print(nodeList.get(i).data + " ");
			for(int j= 0; j<graphMatrix[i].length;j++) {
				System.out.print(graphMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void breadhFirstSearchUsingQueue(int src) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[graphMatrix.length];
		
		queue.offer(src);
		visited[src] = true;
		
		while(queue.size() != 0) {
			src = queue.poll();
			System.out.println(nodeList.get(src).data + " = visited");
			
			for(int i=0; i<graphMatrix[src].length;i++) {
				if(graphMatrix[src][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}
	
}

public class L_BreadthFirstSearch {

	public static void main(String[] args) {
		/*
		 * algo for traversing a tree or a graph data structure
		 * this is done one LEVEL at a time, NOT one branch at a time like depth first search
		 * 
		 * this uses queue
		 * 	we add all the unvisited nodes to the queue
		 */
		GraphBFS graph = new GraphBFS(5);
		
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
		
		graph.breadhFirstSearchUsingQueue(3);
	}

}
