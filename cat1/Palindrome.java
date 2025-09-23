// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Palindrome {
    public static boolean binaryPalindrome (int n){
        String val = Integer.toBinaryString(n);
        int i = 0;
        int j = val.length() -1;
        while(i<j){
            if(val.charAt(i) != val.charAt(j) ) return false;
        }
        return true;
        
    }
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n  = sc.nextInt();
        System.out.println(binaryPalindrome(n));
    }
}