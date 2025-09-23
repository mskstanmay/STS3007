/* This program rotates an array to the left by 'd' positions using the Block Swap Algorithm.
 *
 * Block Swap Algorithm:
 * A space-efficient method that divides the array into two blocks and recursively swaps them
 * to achieve the desired rotation without using extra memory.
 *
 * Sample Input:
 * Line 1: {n} — size of the array
 * Line 2: {array elements}
 * Line 3: {d} — number of positions to rotate
 *
 * Sample Output:
 * Line 1: Rotated array: {result}
 *
 * {result} = array rotated left by 'd' positions
 *
 * Approach:
 * 1. Normalize 'd' to ensure it's within bounds (d = d % n)
 *
 * 2. Divide the array into two blocks:
 *    - Block A: first 'd' elements
 *    - Block B: remaining 'n - d' elements
 *
 * 3. Use a recursive strategy:
 *    - If sizes of A and B are equal, swap them directly
 *    - If A is smaller, swap A with the last part of B and recurse on the remaining B
 *    - If B is smaller, swap B with the first part of A and recurse on the remaining A
 *
 * 4. Swapping is done in-place using a helper function to avoid extra space
 *
 * 5. After recursion completes, the array is rotated as required
 *
 * 6. Print the final rotated array
 */

import java.util.Scanner;

public class BlockSwapRotation {

    // Function to swap blocks of the array
    static void swap(int[] arr, int fi, int si, int d) {
        for (int i = 0; i < d; i++) {
            int temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
    }

    // Recursive function to rotate array left by d positions
    static void rotate(int[] arr, int d, int n) {
        if (d == 0 || d == n) return;

        if (d == n - d) {
            swap(arr, 0, n - d, d);
            return;
        }

        if (d < n - d) {
            swap(arr, 0, n - d, d);
            rotate(arr, d, n - d);
        } else {
            swap(arr, 0, d, n - d);
            rotate(arr, n - d, d);
        }
    }

    // Helper to print array
    static void printArray(int[] arr) {
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter elements of array: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter number of positions to rotate: ");
        int d = sc.nextInt();
        d = d % n; // Normalize rotation

        rotate(arr, d, n);
        System.out.print("Rotated array: ");
        printArray(arr);

        sc.close();
    }
}
