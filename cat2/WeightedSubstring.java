/* This program counts the number of substrings in a given string
 * where the sum of character weights is strictly less than a threshold value `k`.
 *
 * Sample Input:
 * Line 1: cdabhg
 * Line 2: 761283425612
 * Line 3: {k}
 *
 * Sample Output:
 * Line 1: Count of valid substrings: 10
 *
 * cdabhg = input string whose substrings are evaluated
 * 761283425612 = weights assigned to characters from 'a' to 'z' (left to right) 
 * {k} = threshold (The maximum alphabet-weight sum that a subtring can have)
 * 
 * Approach:
 * 1. Build a weight map:
 *    - Assign weights to characters 'a' to 'z' using the input weight string.
 *    - Each character gets a weight based on its position in the alphabet.
 *
 * 2. Iterate through all possible substrings of the input string:
 *    - For each starting index `i`, initialize a running sum.
 *    - Extend the substring by adding one character at a time (`j` from `i` to end).
 *    - Add the weight of the current character to the running sum.
 *    - If the sum is less than `k`, count the substring as valid.
 *    - If the sum reaches or exceeds `k`, break out of the inner loop.
 *
 * 3. Return the total count of valid substrings.
 */

import java.util.*;

public class WeightedSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String weights = sc.nextLine();
        sc.close();
        int k = 7;

        Map<Character, Integer> weightMap = buildWeightMap(weights);

        int result = countValidSubstrings(text, weightMap, k);
        System.out.println("Count of valid substrings: " + result);
    }

    private static Map<Character, Integer> buildWeightMap(String weights) {
        Map<Character, Integer> weightMap = new HashMap<>();
        char ch = 'a';
        for (int i = 0; i < weights.length() && ch <= 'z'; i++, ch++) {
            weightMap.put(ch, weights.charAt(i) - '0');
        }
        return weightMap;
    }

    private static int countValidSubstrings(String text, Map<Character, Integer> weightMap, int k) {
        int n = text.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                char currentChar = text.charAt(j);
                sum += weightMap.getOrDefault(currentChar, 0);
                if (sum < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
