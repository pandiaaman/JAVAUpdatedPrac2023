package DSALogics;

public class F_92_NQueensProblem {

	//TIME COMPLEXITY : O(n^n) : since we are trying to place n queens at each n row
	
	/*
	 * given a chessboard of n*n and n queens
	 * we have to find the total possible combinations of those n queens on chessboard
	 * such that all queens are safe
	 	
	 	solution
	 *	we move column by column, checking if for a given column, in each row, is it safe to keep the queen
	 *if its safe then we put the queen there and move to next column
	 */
	
	//checking if for the current placement of queen at row,column, if there is any other queen present
	//in any of the 8 directions
	
	public static boolean checkChessBoard(int[][] chessboard, int n, int row, int column) {
		for(int i=0;i<n;i++) {
			if(chessboard[row][i] == 1) {
				return false;
			}
			if(chessboard[i][column] == 1) {
				return false;
			}
			
			if((row - i) >= 0 && (column - i) >= 0) {
				if(chessboard[row-i][column-i] == 1) {
					return false;
				}
			}
			if((row + i) < n && (column + i) < n) {
				if(chessboard[row+i][column+i] == 1) {
					return false;
				}
			}
			if((row - i) >= 0 && (column + i) < n) {
				if(chessboard[row-i][column+i] == 1) {
					return false;
				}
			}
			if((row + i) < n && (column - i) >= 0) {
				if(chessboard[row+i][column-i] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	//this is just a method to show us how the above method is working
	public static void fillChessBoard(int[][] chessboard, int n, int row, int column) {
		for(int i=0;i<n;i++) {
			chessboard[row][i] = 1;
			chessboard[i][column] = 1;
			
			if((row - i) >= 0 && (column - i) >= 0) {
				chessboard[row-i][column-i] = 1;
			}
			if((row + i) < n && (column + i) < n) {
				chessboard[row+i][column+i] = 1;
			}
			if((row - i) >= 0 && (column + i) < n) {
				chessboard[row-i][column+i] = 1;
			}
			if((row + i) < n && (column - i) >= 0) {
				chessboard[row+i][column-i] = 1;
			}
		}
	}
	
	public static void printchessboard(int[][] chessboard, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(chessboard[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int paths = 0;
	
	public static void nQueensPositions(int[][] chessboard, int n, int column) { //column decides which column we are in
		
		//column will only increase once i have placed a queen
		//row will increase until i place a queen and then once placed goes back to 0, 
		//if row goes beyond n, then return
		//i can only put the queen with cell containing zero
		//once placed, set the whole row and the whole column and the diagonal as 1
		
		//base case
		if(column >= n) {
			paths++;
			System.out.println("PATHS : ::::::::::: " + paths);
			return;
		}
		
		//put a queen in a column
		for(int i=0;i<n;i++) { //decides the row my queen is in
			if(chessboard[i][column] == 0) {
				System.out.println("for row :" + i + " column :" + column +" value is zero so placing the queen");
//				chessboard[i][column] = 1; //MISTAKE HERE : IF WE ADD 1 HERE THEN WE CAN NOT CHECK THE BOARD SINCE IT WILL FIND THE 1 VALUE HERE
				System.out.println("value from checkchessboard" + checkChessBoard(chessboard, n, i, column));
				System.out.println("checking if queen is safe");
				if(!checkChessBoard(chessboard, n, i, column)) {
					System.out.println("queen is NOT safe at row : " + i + "column : " + column);
//					chessboard[i][column] = 0;
					continue;
				}
				else {
					System.out.println("queen is SAFE at row : " + i + "column : " + column);
					chessboard[i][column] = 1;
					printchessboard(chessboard, n);
					nQueensPositions(chessboard, n, column+1);
					//I WAS MISSING THIS  : REMEMBER WHEN WE COME BACK FROM THE FAILED RECURSION CALL
					//WE NEED TO SET THE VALUE BACK TO 0
					chessboard[i][column] = 0;
				}
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		/*
		 * given a chessboard of n*n and n queens
		 * we have to find the total possible combinations of those n queens on chessboard
		 * such that all queens are safe
		 */

		int n = 4;
		
		int[][] matrix = new int[n][n];
		
//		int row = 0;
//		int column = 0;
//		
//		fillChessBoard(matrix, n, row, column);
//		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		
//		working correctly
//		matrix[1][5] = 1;
//		System.out.println(checkChessBoard(matrix, n, 0, 0));
		
		nQueensPositions(matrix, n, 0);
		System.out.println(paths);
		
	}

}
