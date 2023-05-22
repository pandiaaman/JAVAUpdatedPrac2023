package DSALogics;

public class F_7_TilePlacement { //we can solve this better by dynamic programming
	/*
	 * given an area of n*m, n is the rows and m is the columns
	 * we have a tile of 1*m size
	 * find the no of ways to arrange the tiles on the grid such that it covers complete area
	 * 
	 * soln : we can place a tile in two ways either horizontal or vertical
	 * if we place it horizontal, then remaining area is (n-1)*m
	 * if we place it vertical then : (n-m)*m
	 * 
	 * now further we want to arrange a tile on the remaining area and we can do it in two ways
	 * 
	 * base case :  if(n==m) lets say : 2 * 2 then we can place two tiles horizontally or two tiles vertiacally
	 * 		so in total we have 2 ways
	 * if m>n : ie columns are greater then rows : only way is to place all the tiles horizontally so 1 way
	 */
	public static int placeTiles(int n, int m) {
		//in beginning i and j are total size of row and column
		
		//base case
			//if n==m
		if(n==m) {
			return 2;
		}
		
		if(m>n) {
			return 1; //placing each tile horizontally is now the only way
		}
		
		int horizontalCounts = placeTiles(n-1, m);
		
		int verticalCounts = placeTiles(n-m , m);
		
		return horizontalCounts + verticalCounts;
		
	}
	
	
	public static void main(String[] args) {
		
		int n=4, m=2;
		System.out.println(placeTiles(n,m));

	}

}
