/* This program finds all the leaders in an array.
 *
 * Leader criteria:
 * A leader is an element arr[i] such that it is greater than all elements to its right
 * i.e., arr[i] > arr[i+1], arr[i+2], ..., arr[n-1]
 *
 * Sample Input:
 * Line 1: {n}
 * Line 2: {Elements of the array}
 *
 * Sample Output:
 * Line 1: {list of leaders}
 *
 * {n}      = number of elements in the array
 * {leaders} = elements that satisfy the leader condition
 *
 * Approach:
 * 1. Traverse the array from right to left
 *
 * 2. Initialize max with the rightmost element (last element of the array)
 *    - This element is always a leader
 *
 * 3. For each element from index n-2 to 0:
 *    - If the current element is greater than or equal to max,
 *      it is a leader and becomes the new max
 *
 * 4. Add each leader to a result list as they are found
 *    - Since we traverse from right to left, leaders are added in reverse order
 *
 * 5. Reverse the result list before returning to maintain original left-to-right order
 *
 * 6. Print the final list of leaders
 */

import java.util.*;

public class LeadersInArray {
    static void printArrayList(ArrayList<Integer> arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    static ArrayList<Integer> leaders(int[] arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = arr[n - 1];
        res.add(m);

        for (int i = n - 2; i >= 0; i--)
            if (arr[i] >= m) {
                res.add(arr[i]);
                m = arr[i];
            }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        
        System.out.print("Enter the elements of the array: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        ArrayList<Integer> res = leaders(arr, n);
        printArrayList(res);

        sc.close();
    }
}
