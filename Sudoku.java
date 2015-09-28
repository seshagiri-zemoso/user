package kudosu;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class Sudoku {
	
	  public static void main(String[] args) throws FileNotFoundException {
	 
	   
	    // Create a Scanner
		  String file = "/home/seshagiri/zemoso/JAVA problem1/sudoku.txt";
	    Scanner sc = new Scanner(new FileReader(file));
	    int[][] grid = new int[9][9];
	    while(sc.hasNext()){
			sc.nextLine();      
		for (int i = 0; i < 9; i++) {
			String line = sc.nextLine();
	      for (int j = 0; j < 9; j++){
	        grid[i][j] = line.charAt(j)-'0';
	  }
	
	}
		 if (search(grid)) {
		      System.out.println("The solution is found:");
		      printGrid(grid);
		    }   
		    else
		      System.out.println("No solution");
		  }
	    sc.close();
 }
	  public static int[][] getFreeCellList(int[][] grid) {
	    int numberOfFreeCells = 0;   
	    for (int i = 0; i < 9; i++)
	      for (int j = 0; j < 9; j++) 
	        if (grid[i][j] == 0) 
	          numberOfFreeCells++;
	    int[][] freeCellList = new int[numberOfFreeCells][2];
	    int count = 0;
	    for (int i = 0; i < 9; i++)
	      for (int j = 0; j < 9; j++) 
	        if (grid[i][j] == 0) {
	          freeCellList[count][0] = i;
	          freeCellList[count++][1] = j;
	        }
	    
	    return freeCellList;
	  }

	  public static void printGrid(int[][] grid) {
	    for (int i = 0; i < 9; i++) {
	      for (int j = 0; j < 9; j++)
	        System.out.print(grid[i][j] + " ");
	      System.out.println();
	    }
	  }


	  public static boolean search(int[][] grid) {
	    int[][] freeCellList = getFreeCellList(grid); 
	    int k = 0;   
	    boolean found = false; 
	    
	    while (!found) {
	      int i = freeCellList[k][0];
	      int j = freeCellList[k][1];
	      if (grid[i][j] == 0) 
	        grid[i][j] = 1; // Start with 1

	      if (isValid(i, j, grid)) {
	        if (k + 1 == freeCellList.length) { 
	          found = true; 
	        }
	        else { // Move to the next free cell
	          k++;
	        }
	      }
	      else if (grid[i][j] < 9) {
	        grid[i][j] = grid[i][j] + 1; // Check the next possible value
	      }
	      else { // grid[i][j] is 9, backtrack
	        while (grid[i][j] == 9) {
	          grid[i][j] = 0; // Reset to free cell
	          if (k == 0) {
	            return false; // No possible value
	          }
	          k--; // Backtrack
	          i = freeCellList[k][0];
	          j = freeCellList[k][1];
	        }

	        grid[i][j] = grid[i][j] + 1; // Check the next possible value
	      }
	    }

	    return true; // A solution is found
	  }

	  /** Check whether grid[i][j] is valid in the grid */
	  public static boolean isValid(int i, int j, int[][] grid) {
	    // Check whether grid[i][j] is valid at the i's row
	    for (int column = 0; column < 9; column++)
	      if (column != j && grid[i][column] == grid[i][j])
	        return false;

	    // Check whether grid[i][j] is valid at the j's column
	    for (int row = 0; row < 9; row++)
	      if (row != i && grid[row][j] == grid[i][j])
	        return false;

	    // Check whether grid[i][j] is valid in the 3 by 3 box
	    for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
	      for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
	        if (row != i && col != j && grid[row][col] == grid[i][j])
	          return false;

	    return true; // The current value at grid[i][j] is valid
	  }

	  
	  public static boolean isValid(int[][] grid) {
	    for (int i = 0; i < 9; i++)
	      for (int j = 0; j < 9; j++)
	        if (grid[i][j] != 0 && !isValid(i, j, grid)) return false;

	    return true; // The fixed cells are valid
	  }
	}
