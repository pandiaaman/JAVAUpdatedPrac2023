package DSALogics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class F_93_SudokuSolver {

	
	public static List<Integer> getPossibleValues(int[][] sudoku, int row, int column){
		List<Integer> rowValues = getRowValues(sudoku, row);
		List<Integer> columnValues = getColumnValues(sudoku, column);
		List<Integer> gridValues = getGridValues(sudoku, row, column);
		
		System.out.println("row values :");
		for(Integer a: rowValues) {
			System.out.print(a + " ");
		}
		
		System.out.println("column values :");
		for(Integer a: columnValues) {
			System.out.print(a + " ");
		}
		
		System.out.println("grid values :");
		for(Integer a : gridValues) {
			System.out.print(a + " ");
		}
		
		rowValues.retainAll(columnValues);
		rowValues.retainAll(gridValues);
		
		System.out.println("final intersected values :");
		for(Integer a: rowValues) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		return rowValues;
	}
	public static List<Integer> getRowValues(int[][] sudoku, int row) {
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 1; i<=9;i++) {
			res.add(i);
		}
		for(int i=0;i<9;i++) {
			if(sudoku[row][i] != 0) {
				System.out.print("i value " + i);
				res.remove(sudoku[row][i]);
			}
		}
		return res;
	}
	
	public static List<Integer> getColumnValues(int[][] sudoku, int column) {
		
		List<Integer> res = new ArrayList<Integer>();
		
		for(int i = 1; i<=9;i++) {
			res.add(i);
		}
		
		for(int i=0;i<9;i++) {
			if(sudoku[i][column] != 0) {
				res.remove(sudoku[i][column]);
			}
		}
		return res;
	}
	
	public static List<Integer> getGridValues(int[][] sudoku, int row, int column) {
		
		
		int rowGrid = row/3; //if 0 then in 1st if 1 then 2nd if 2 then 3rd
		int columnGrid = column/3;
		
		List<Integer> res = new ArrayList<Integer>();

		for(int i = 1; i<=9;i++) {
			res.add(i);
		}
		
		for(int i=rowGrid*3;i<rowGrid*3+3;i++) {
			for(int j=columnGrid*3;j<columnGrid*3+3;j++) {
				if(sudoku[i][j] != 0) {
					res.remove(sudoku[i][j]);
				}	
			}
			
		}
		return res;
	}
	
	public static void printSudoku(int[][] sudoku) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}
	
	//backtracking
	public static void solveSudoku(int[][]sudoku, int row, int column) {
		
		//check for values in row
		//check for values in column
		//check for values in grid
		
		//base case
		if(row >= 9 && column >= 9) {
			System.out.println("sudoku solved");
			printSudoku(sudoku);
			return;
		}
		
			System.out.println("currently at row : "  + row + " and column : " + column);
			List<Integer> possibleValues = getPossibleValues(sudoku, row, column);
			for(Integer a: possibleValues) {
				System.out.print(a + " ");
			}
			System.out.println();
			
			for(Integer val : possibleValues) {
				sudoku[row][column] = val;
				printSudoku(sudoku);
				if(row<8) {
				if(column<8) {
					solveSudoku(sudoku, row, column+1);
				}
				solveSudoku(sudoku, row+1, 0);
				}
				sudoku[row][column] = 0; //coming back during backtracking, correcting the value back to 0
			}
			
		
		
	}
	
	public static void main(String[] args) {
		int[][] sudoku = new int[9][9];
		solveSudoku(sudoku, 0,0);
		

	}

}
