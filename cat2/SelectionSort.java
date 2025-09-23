/* This program implements the Selection Sort algorithm.
 * Selection Sort is an in-place comparison-based sorting algorithm.
 *
 * Approach:
 * 1. Start from the first element of the array.
 * 2. Find the smallest element in the unsorted part of the array.
 *    - This is done by iterating through the remaining elements and comparing each element.
 * 3. Once the smallest element is found, swap it with the first unsorted element.
 * 4. Repeat steps 2 and 3 for each subsequent unsorted section of the array.
 *    - After each iteration, the boundary of the unsorted section shrinks.
 *
 * Selection Sort Characteristics:
 * - Time Complexity: O(n^2) in all cases (best, worst, average).
 * - Space Complexity: O(1) because it sorts in-place.
 * - Not stable: Equal elements may not retain their original order.
 *
 * Sample Input:
 * Line 1: {n}            -> The number of elements in the array.
 * Line 2: {arr[0], arr[1], ..., arr[n-1]} -> The array of integers to be sorted.
 *
 * Sample Output:
 * Line 1: "Original array: {arr}" -> The original unsorted array.
 * Line 2: "Sorted array: {arr}"   -> The array after sorting using Selection Sort.
 *
 * {arr}    = array of integers (length n) to be sorted.
 *
 * Detailed Steps in the Code:
 * 1. The user is prompted to enter the number of elements for the array.
 * 2. The user is then asked to input the array elements.
 * 3. The `selectionSort()` method is called to sort the array.
 * 4. Within `selectionSort()`, a loop iterates through the array to find the smallest element
 *    in the unsorted portion and swaps it with the first unsorted element.
 * 5. The sorted array is printed after the sorting process.
 *
 * Utility Methods:
 * - `selectionSort(int[] arr)`: Main method that sorts the array using the Selection Sort algorithm.
 * - `swap(int[] arr, int i, int j)`: Helper method to swap two elements in the array.
 * - `printArray(int[] arr)`: Helper method to print the elements of the array.
 *
 * The program makes use of basic I/O for input and output, and uses loops and conditional statements
 * to implement the sorting logic.
 */
import java.util.Scanner;

public class SelectionSort {
    // Method to perform selection sort on an array
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the min element in the unsorted part
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // Swap the found min element with the first element of the unsorted part
            swap(arr, i, min);
        }
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

        selectionSort(arr);

        System.out.print("Sorted array: ");
        printArray(arr);
    }
}