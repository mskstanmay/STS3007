
/*
 * Problem: Count the number of unique paths in an n x m grid from the top-left corner (0,0)
 * to the bottom-right corner (n-1, m-1), moving only right or down at each step.
 *
 * Approach:
 * - This is a classic dynamic programming problem.
 * - The number of ways to reach cell (i, j) is the sum of ways to reach (i-1, j) and (i, j-1).
 * - We use a 1D array to optimize space, updating the number of ways for each column as we iterate through rows.
 *
 * Steps:
 * 1. Initialize a 1D array of size m with all elements as 1 (since there's only one way to reach any cell in the first row).
 * 2. For each subsequent row, update arr[j] = arr[j] + arr[j-1] for all columns j > 0.
 * 3. The last element of the array gives the total number of unique paths.
 *
 * Sample Input/Output:
 *
 * Input:
 *   Enter n value: 3
 *   Enter m value: 4
 *
 * Output:
 *   The no. of manuvering paths possible is : 10
 *
 * Explanation:
 *   For a 3x4 grid, there are 10 unique paths from (0,0) to (2,3) moving only right or down.
 *
 * Constraints:
 *   - n, m >= 1
 *   - Only right and down moves are allowed
 *
 * Note:
 *   - If n > m, the program throws an IllegalArgumentException.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

class Manuvering {
    static int manuvering(int n, int m) {
        int[] arr = new int[m];
        for (int j = 0; j < m; j++)
            arr[j] = 1;

        for (int i = 0; i < n; i++)
            for (int j = 1; j < m; j++)
                arr[j] += arr[j - 1];

        return arr[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n value: ");
        int n = sc.nextInt();
        System.out.print("Enter m value: ");
        int m = sc.nextInt();

        if (n > m)
            throw new IllegalArgumentException("N must be greater than M");
        System.out.println("The no. of manuvering paths possible is : " + manuvering(n, m));
        sc.close();
    }
}