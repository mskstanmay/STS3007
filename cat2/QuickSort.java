/* This program implements the Quick Sort algorithm.
 * Quick Sort is an efficient, comparison-based, divide-and-conquer sorting algorithm.
 *
 * Approach:
 * 1. Choose a 'pivot' element from the array.
 * 2. Partition the array into two subarrays:
 *    - The first subarray contains elements smaller than the pivot.
 *    - The second subarray contains elements greater than the pivot.
 * 3. Recursively apply the same process to the two subarrays.
 *    - This continues until the base case is reached (subarrays of size 1 or empty).
 *
 * Quick Sort Characteristics:
 * - Time Complexity:
 *   - Best and Average Case: O(n log n), when the pivot splits the array into roughly equal halves.
 *   - Worst Case: O(n^2), when the pivot consistently divides the array into the worst possible splits (e.g., when the array is already sorted).
 * - Space Complexity: O(log n) due to the recursive stack space.
 * - Stable: Not stable, as equal elements might change their relative order after sorting.
 *
 * Sample Input:
 * Line 1: {n}            -> The number of elements in the array.
 * Line 2: {arr[0], arr[1], ..., arr[n-1]} -> The array of integers to be sorted.
 *
 * Sample Output:
 * Line 1: "Original array: {arr}" -> The original unsorted array.
 * Line 2: "Sorted array: {arr}"   -> The array after sorting using Quick Sort.
 *
 * {arr}    = array of integers (length n) to be sorted.
 *
 * Detailed Steps in the Code:
 * 1. The user is prompted to enter the number of elements for the array.
 * 2. The user is then asked to input the array elements.
 * 3. The `quickSort()` method is called to sort the array.
 *    - This method recursively divides the array into smaller subarrays based on the pivot.
 * 4. The `partition()` method is used to partition the array around the pivot:
 *    - It moves elements smaller than the pivot to the left and greater to the right.
 *    - It returns the index of the pivot after partitioning.
 * 5. The sorted array is printed after the sorting process.
 *
 * Utility Methods:
 * - `quickSort(int[] arr, int low, int high)`: Main method that recursively sorts the array using Quick Sort.
 * - `partition(int[] arr, int low, int high)`: Helper method to partition the array around the pivot.
 * - `swap(int[] arr, int i, int j)`: Helper method to swap two elements in the array.
 * - `printArray(int[] arr)`: Helper method to print the elements of the array.
 *
 * The program uses recursion and the partitioning method to sort the array efficiently.
 * It makes use of basic I/O for input and output, and utilizes loops and conditionals to implement the sorting logic.
 */
import java.util.Scanner;

public class QuickSort {
    // Method to perform quick sort on an array
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);

        return i + 1;
    }

    // Utility method to swap two elements in an array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        sc.close();
        System.out.print("Original array: ");
        printArray(arr);

        quickSort(arr, 0, n - 1);

        System.out.print("Sorted array: ");
        printArray(arr);
    }
}
