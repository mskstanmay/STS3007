/* This program computes the Greatest Common Divisor (GCD) of two integers using Euclid's algorithm.
 *
 * Euclid's Algorithm:
 * A classic and efficient method to find the GCD by recursively replacing the
 * pair (a, b)
 * with (b, a % b) until b becomes zero. The GCD is then the value of a.
 *
 * Sample Input:
 * Line 1: Enter first integer (a): {a}
 * Line 2: Enter second integer (b): {b}
 *
 * Sample Output:
 * Line 1: GCD of a and b
 *
 * Approach:
 * 1. Read two integers from the user.
 * 2. Use recursion to compute gcd(a, b):
 * - If b == 0, gcd is a.
 * - Else, gcd is gcd(b, a % b).
 * 3. Print the result.
 */
import java.util.Scanner;
public class Euclid {

    // Function to return gcd of a and b using Euclid's algorithm
    static int gcd(int a, int b) {
    if (b == 0)
    return a;
    return gcd(b, a % b);
    }

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter first integer (a): ");
    int a = scanner.nextInt();

    System.out.print("Enter second integer (b): ");
    int b = scanner.nextInt();

    int result = gcd(a, b);

    System.out.println("GCD of " + a + " and " + b + " is " + result);

    scanner.close();
    }
}
