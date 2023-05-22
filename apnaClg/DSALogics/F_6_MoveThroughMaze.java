package DSALogics;

public class F_6_MoveThroughMaze {

	public static void main(String[] args) {

		
//		System.out.println(matrix.length);
//		System.out.println(matrix[0].length);
		
		/*
		 * given two points, we need to find all paths to reach those points
		 * we can only move right or down
		 * 
		 */
		
		int m = 3; //2nd row
		int n = 3; //3rd column
		
		System.out.println(countPaths(0,0,m,n));

		
	}
	

	//using backtracking  : this has a very high time complexity so we will solve this by dynamic programming too
	
	public static int countPaths(int i, int j, int m, int n) {

		//base case for when we are going to go out of the boundary
		if(i == m || j==n) { //target is m-1 so if we reach m then thats wrong
			return 0;
		}
		
		//base case for when we are where we want to be : target cell
		if(i == m-1 && j == n-1) {
			return 1; //sends back one path for the current traversal
		}
		
		//moving downwards
		int downpaths = countPaths(i+1, j, m, n);
		
		//moving rightwards
		int rightpaths = countPaths(i,j+1, m, n);
		
		return downpaths + rightpaths;
	}
	
	
}
