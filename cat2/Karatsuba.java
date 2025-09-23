/* This program multiplies two large numbers using the Karatsuba algorithm.
 *
 * Karatsuba is a divide-and-conquer algorithm that reduces the number of
 * single-digit multiplications compared to the traditional method.
 *
 * Sample Input:
 * Hardcoded in main: num1 = 12345678, num2 = 87654321
 *
 * Sample Output:
 * Line 1: Product: {result}
 *
 * {result} = product of num1 and num2 using Karatsuba multiplication
 *
 * Approach:
 * 1. Get the number of digits in both input numbers
 *    - Use the larger size to determine the splitting point
 *
 * 2. If the number of digits is small (less than 10), use direct multiplication
 *    - This serves as the base case for recursion
 *
 * 3. Split both numbers into two halves:
 *    - high1 and low1 for the first number
 *    - high2 and low2 for the second number
 *    - Use powers of 10 to split based on digit count
 *
 * 4. Make three recursive calls:
 *    - z0 = multiply(low1, low2)
 *    - z1 = multiply(low1 + high1, low2 + high2)
 *    - z2 = multiply(high1, high2)
 *
 * 5. Combine the results using the Karatsuba formula:
 *    - result = z2 × 10^(2N) + (z1 − z2 − z0) × 10^N + z0
 *
 * 6. Return the final result and print it in the main method
 */

public class Karatsuba {

    // Function to multiply two numbers using Karatsuba algorithm
    public long multiply(long x, long y) {
        int size1 = getSize(x);
        int size2 = getSize(y);
        int N = Math.max(size1, size2);

        // Base case for recursion
        if (N < 10)
            return x * y;

        // Calculate the size of the numbers
        N = (N / 2) + (N % 2);
        long m = (long) Math.pow(10, N);

        // Split the digit sequences in the middle
        long high1 = x / m;
        long low1 = x % m;
        long high2 = y / m;
        long low2 = y % m;

        // 3 recursive calls
        long z0 = multiply(low1, low2);
        long z1 = multiply((low1 + high1), (low2 + high2));
        long z2 = multiply(high1, high2);

        return z2 * (long) Math.pow(10, 2 * N) + ((z1 - z2 - z0) * m) + z0;
    }

    // Helper function to get number of digits
    public int getSize(long num) {
        int count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        Karatsuba k = new Karatsuba();
        long num1 = 12345678;
        long num2 = 87654321;
        long result = k.multiply(num1, num2);
        System.out.println("Product: " + result);
    }
}
