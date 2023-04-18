package i_DataStructures;

public class K_Graphs {

	public static void main(String[] args) {
		// graph is a non linear aggregation of nodes(vertex) and edges
		/*
		 * graphs can be of two types : undirected and directed
		 * 		undirected : social network like fb : each user can be a node and their friendship can be denoted by an edge
		 * 		directed : one way connections of links between two nodes :  eg. street map 
		 */
		
		/*
		 * popular ways to represent a graph :
		 * 		adjacency matrix : 2d array : one row and one column for each node : 1 if connected, else 0
		 * 			PRO : time complexity : O(1) |  CON : space complexity : O(n^2)
		 * 		adjacency list : array list of linked list, each header within the linked list will contain the header of the node
		 * 			and then each header will contain the nodes that are adjacent to that node
		 * 			Better for directed Graphs
		 * 			CON : time complexity : O(n)  | PRO : space complexity : O(n+E) : n is nodes and E is edges
		 */

	}

}
