/* Finds the subarray which has the maximum product 
 * Subarray = continous elements
 * Sample input
 * Line1 : {n} 
 * Line2 : {Elements of the array} 
 * 
 * Sample output
 * Line1 : Max sub-array product is {result} | FAULTY
 * Line2 : Max sub-array product is {result}
 * 
 * {n} = number of elements in array 
 * {result} = Maximum product of consecutive sub-array
 * 
 * Approach:
 * 1. Initialize three variables:
 *    - max: maximum product ending at the current index
 *    - min: minimum product ending at the current index
 *    - result: overall maximum product found so far
 *
 * 2. Iterate through the array starting from index 1
 *
 * 3. For each element, compute:
 *    - temp: maximum of (current element, current element × max, current element × min)
 *    - Update min using the minimum of (current element, current element × max, current element × min)
 *
 * 4. Assign temp to max (since max was used in both calculations)
 *
 * 5. Update result if the current max is greater than the previous result
 *
 * 6. After the loop ends, return result as the maximum product of any contiguous subarray.
 * 
 * Note:
 * The first line in output is used to showcase a common mistake made during this code.
 */
import java.util.*;

public class maxProductSubarray {
    public static int maxSub(int[] arr, int n) {
        if (n == 0)
            return 0;
        int min = arr[0];
        int max = arr[0];
        int result = max;

        for (int i = 1; i < n; i++) {

            int temp = Math.max(arr[i], Math.max(arr[i] * max, arr[i] * min));
            min = Math.min(arr[i], Math.min(arr[i] * max, arr[i] * min));
            max = temp;
            result = Math.max(result, max);
        }

        return result;
    }

    public static int faultymaxSub(int[] arr, int n) {
        if (n == 0)
            return 0;
        int min = arr[0];
        int max = arr[0];
        int result = max;

        for (int i = 1; i < n; i++) {

            max = Math.max(arr[i], Math.max(arr[i] * max, arr[i] * min));
            min = Math.min(arr[i], Math.min(arr[i] * max, arr[i] * min));

            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        System.out.println("Max sub-array product is " + faultymaxSub(arr, n) + " | FAULTY ");
        System.out.println("Max sub-array product is " + maxSub(arr, n));
    }
}
