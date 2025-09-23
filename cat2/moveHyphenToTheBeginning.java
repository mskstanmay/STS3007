/* This program moves all hyphens ('-') in a string to the beginning,
 * while preserving the relative order of all other characters.
 *
 * Sample Input:
 * Line 1: {input}
 *
 * Sample Output:
 * Line 1: {rearranged_string}
 *
 * {input}             = original string containing hyphens and other characters
 * {rearranged_string} = string with all hyphens moved to the front
 *
 * Approach:
 * 1. Convert the input string into a character array for in-place manipulation
 *
 * 2. Initialize two pointers:
 *    - i: tracks the position from the end where the next non-hyphen should be placed
 *    - j: iterates from the end of the array to the beginning
 *
 * 3. Use a for loop to traverse the array in reverse:
 *    - If the current character is not a hyphen, swap it with the character at index i
 *    - Decrement i to move the placement boundary leftward
 *
 * 4. The swap ensures that non-hyphen characters are pushed to the end,
 *    effectively shifting hyphens toward the front
 *
 * 5. Return the modified character array and print the result
 */

import java.util.Scanner;

public class moveHyphenToTheBeginning {

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static char[] move(String input) {
        char[] arr = input.toCharArray();
        int i = arr.length - 1;

        for (int j = i; j >= 0; j--) {
            if (arr[j] != '-') {
                swap(arr, i, j);
                i--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] output = move(input);
        System.out.println(String.valueOf(output));
        sc.close();
    }
}
