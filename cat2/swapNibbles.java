/* This program swaps the nibbles of an 8-bit number.
 * Nibble = 4 bits
 * An 8-bit number consists of two nibbles:
 *    - Left nibble: higher 4 bits (bits 4–7)
 *    - Right nibble: lower 4 bits (bits 0–3)
 *
 * Sample Input:
 * Line 1: {n}
 *
 * Sample Output:
 * Line 1: {n} -> {result}
 *
 * {n}      = input number (assumed to be within 0–255)
 * {result} = number after swapping its left and right nibbles
 *
 * Approach:
 * 1. Extract the right nibble using bitwise AND with 0x0F
 *    - This isolates the lower 4 bits
 *
 * 2. Extract the left nibble using bitwise AND with 0xF0
 *    - This isolates the upper 4 bits
 *
 * 3. Shift the right nibble to the left by 4 bits
 *    - This moves it into the upper nibble position
 *
 * 4. Shift the left nibble to the right by 4 bits
 *    - This moves it into the lower nibble position
 *
 * 5. Combine the shifted nibbles using bitwise OR
 *    - This produces the final swapped result
 *
 * 6. Return the result and print it in the format: {original} -> {swapped}
 */

import java.util.Scanner;

class swapNibbles {

    static int swap(int n) {
        int l = (n & 0x0F) << 4;
        int r = (n & 0xF0) >> 4;

        return l | r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n + " -> " + swap(n));
        sc.close();
    }
}
