
/* Finds maximum number of consecutives ones
 * 
 * Sample input
 * Line1 : {n} 
 * Line2 : {Elements of the array}
 * Line3 : {K} 
 * 
 * Sample output
 * Line1 : Max length is {maxLength}
 * 
 * {n} = number of elements in array
 * {K} = no. of bits that can be flipped
 * {maxLength} = Maximum no. of consecutive 1s
 * 
 * Approach
 * 1. Take a maxlength (default as 0), start pointer as 0
 * 2. Do a for loop over the elements in the array
 * 3. Have a flip bit that increase whenever 0 is encountered
 * 4. Use a while loop when flip crosses k value i.e too many zeros used as flippable bits
 * 5. Increase start pointer, flip-- at every zero deducted until loop codition fails.
 * 6. Return Math.max(0, end_pointer - start_pointer + 1);
 * 
 * Note:
 * Takes values from start indiscriminately until k is exhuasted 
 * It then optimises by unflipping zeros to get new max length 
 */
import java.util.Scanner;

class maxConsecutive1s {
    public static int max(int n, int k, int[] arr) {
        int maxLen = 0;
        int flip = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            if (arr[j] == 0)
                flip++;

            while (flip > k) {
                if (arr[i] == 0)
                    flip--;
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        int res = max(n, k, arr);

        System.out.println("Max length is " + res);
    }

}
