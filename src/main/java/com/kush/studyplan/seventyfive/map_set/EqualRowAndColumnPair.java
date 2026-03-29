package com.kush.studyplan.seventyfive.map_set;
import java.util.Arrays;

public class EqualRowAndColumnPair {

    /**Intuition: The approach involves iterating through each cell in the grid, 
     *comparing the corresponding row and column. If a row is equal to the corresponding column, 
     *it is considered as an equal pair. The count of such equal pairs is returned as the final result.
    */
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        // Iterate through each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check if the row i and column j are equal
                if (Arrays.equals(grid[i], getColumn(grid, j, n))) {
                    count++;
                }
            }
        }

        return count;
    }
    
    private int[] getColumn(int[][] grid, int colIndex, int n) {
        int[] column = new int[n];
        for (int i = 0; i < n; i++) {
            column[i] = grid[i][colIndex];
        }
        return column;
    }

    public static void main(String[] args) {
        EqualRowAndColumnPair solution = new EqualRowAndColumnPair();

        // Example usage:
        int[][] exampleGrid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int result = solution.equalPairs(exampleGrid);

        System.out.println("Number of equal pairs: " + result);
    }
}
