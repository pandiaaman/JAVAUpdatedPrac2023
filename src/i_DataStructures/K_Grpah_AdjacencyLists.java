package i_DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;

class NodeLs{
	char data;
	NodeLs(char data){
		this.data = data;
	}
}

class GraphLs{
	ArrayList<LinkedList<NodeLs>> adjList;
	
	GraphLs(){
		adjList = new ArrayList<>();
	}
	
	public void addNode(NodeLs n) {
		LinkedList<NodeLs> currentList = new LinkedList<NodeLs>();
		currentList.add(n);
		adjList.add(currentList);
	}
	
	public void addEdge(int src, int des) {
		LinkedList<NodeLs> currentList = adjList.get(src);
		NodeLs destNode = adjList.get(des).get(0); //header of the linked list
		currentList.add(destNode);
	}
	
	public boolean checkEdge(int src, int des) {
		LinkedList<NodeLs> currentList = adjList.get(src);
		NodeLs desNode = adjList.get(des).get(0);
		
		return currentList.contains(desNode);
	}
	
	public void print() {
		for(LinkedList<NodeLs> currentList : adjList) {
			for(NodeLs node : currentList) {
				System.out.print( node.data + " => ");
			}
			System.out.println();
		}
	}
}

public class K_Grpah_AdjacencyLists {

	public static void main(String[] args) {
		/*
		 * its a array/ arraylist made up of linked list
		 * each linked list has a unique node at the head
		 * all adjacent neighbors to that node are added to that node's linked list
		 * 
		 * runtime complexity: O(n) space complexity : O(n+e)
		 */

		GraphLs graph = new GraphLs();
		
		graph.addNode(new NodeLs('a'));
		graph.addNode(new NodeLs('b'));
		graph.addNode(new NodeLs('c'));
		graph.addNode(new NodeLs('d'));
		graph.addNode(new NodeLs('e'));
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);
		
		graph.print();
	}

}
