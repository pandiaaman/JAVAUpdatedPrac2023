package DSALogics;

public class F_94_CorrectSudokuSolver {

	public static void sudokuSolverHelper(int[][] sudoku, int row, int column) {
		
		if(row < sudoku.length) {
			sudokuSolverHelper(sudoku, row+1, column);
		}
	}
	public static void main(String[] args) {
		
		int[][] sudoku = new int[9][9];
		
		sudokuSolverHelper(sudoku, 0, 0);

		//https://www.youtube.com/watch?v=tRj4VlVTat8&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=21
	}

}
