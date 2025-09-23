/*
 * 📌 Program: Maximum Equilibrium Sum Finder
 *
 * 🧠 Description:
 * This program finds the maximum value of the sum of elements on the left side of an index
 * where the sum of elements to the left equals the sum of elements to the right.
 * It's a variation of the "equilibrium index" problem, but instead of returning the index,
 * it returns the maximum such sum.
 *
 * 🔍 How It Works:
 * 1. Read the array size and elements.
 * 2. Calculate the total sum of the array (initial right sum).
 * 3. Traverse the array:
 *    - Add current element to left sum.
 *    - Subtract current element from right sum.
 *    - If left and right sums are equal, update the maximum equilibrium sum.
 * 4. Print the result.
 *
 * 📥 Input Format:
 * Line 1: An integer n (number of elements in the array)
 * Line 2: n space-separated integers (the array elements)
 *
 * 📤 Output Format:
 * Line 1: "Answer is : {maxEquilibriumSum}"
 *
 * 🧪 Example:
 * Input:
 * 5
 * 1 2 3 3 2
 * Output:
 * Answer is : 0
 */

import java.util.Scanner;

public class MaxEquilibriumSum {

    public static int findMaxEquilibriumSum(int[] arr, int n) {
        int leftSum = 0;
        int rightSum = 0;
        int maxEquilibrium = 0;

        for (int i = 0; i < n; i++) {
            rightSum += arr[i];
        }

        for (int i = 0; i < n; i++) {
            leftSum += arr[i];       
            if (leftSum == rightSum) {
                maxEquilibrium = Math.max(maxEquilibrium, leftSum);
            }
            rightSum -= arr[i];      
           
        }

        return maxEquilibrium;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();
        int result = findMaxEquilibriumSum(arr, n);
        System.out.println("Answer is : " + result);
    }
}
