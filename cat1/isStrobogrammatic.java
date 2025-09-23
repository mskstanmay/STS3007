import java.util.*;

public class isStrobogrammatic {
    public static boolean isStro(String num){
        Map<Character,Character> store = new HashMap<>();
        store.put('0','0');
        store.put('1','1');
        store.put('8','8');
        store.put('6','9');
        store.put('9','6');

        int n = num.length();
        for(int i = 0,j=(n-1) ; i<=j;i++,j--){
            char left = num.charAt(i);
            char right = num.charAt(j);
            char mapp = store.getOrDefault(left,null);
            if(mapp == null || mapp != right) return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isStro("69"));      // true
        System.out.println(isStro("88"));      // true
        System.out.println(isStro("962"));     // false
    }
}
