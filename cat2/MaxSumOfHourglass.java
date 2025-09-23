/* Calculates the maximum sum of an hourglass pattern in a 2D matrix
 * Hourglass = r1 three elements, r2 one element, r3 three elements  => total 7 elements
 * 
 * Sample input 
 * Line1 : Number of rows in the matrix {rows}
 * Line2 : Number of columns in the matrix {columns}
 * Line3 : Matrix elements entered row-wise
 * 
 * Sample output
 * Line1 : The maximum hourglass sum is: {result} 
 * 
 * Approach:
 * 1. Check if the matrix has at least 3 rows and 3 columns to form an hourglass.
 * 2. Traverse the matrix using nested loops, stopping 2 rows and 2 columns before the end.
 * 3. For each valid top-left position of an hourglass, calculate the sum of its 7 elements:
 *    - Top row: 3 consecutive elements
 *    - Middle row: 1 centered element
 *    - Bottom row: 3 consecutive elements
 * 4. Track the maximum sum encountered during traversal.
 * 5. Return the highest hourglass sum found.
 * 
 * Note:
 * The first line in output highlights a common mistake often made while implementing this logic.
 */

import java.util.*;

public class MaxSumOfHourglass {
    public static int maxSum(int[][] arr, int rows, int columns) {
        if (rows < 3 || columns < 3)
            return -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < columns - 2; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1]
                        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = sc.nextInt();
        sc.close();
        int result = maxSum(matrix, rows, columns);
        System.out.println("The maximum hourglass sum is: " + result);

    }
}
