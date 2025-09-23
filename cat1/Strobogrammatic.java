import java.util.*;
class Strobogrammatic {
    public static ArrayList<String> Strobo(int n){
        ArrayList<String> result = numDef(n,n);
        return result;
    }
    public static ArrayList<String> numDef(int n, int length){
        if(n == 0) return new ArrayList<String> (Arrays.asList(new String [] {""}));
        if(n == 1) return new ArrayList<String> (Arrays.asList(new String [] {"1","0","8"}));

        ArrayList<String> middles = numDef(n-2,length);
        ArrayList<String> res = new ArrayList<String>();
        
        for(String middle : middles){
            if(n != length){
                res.add("0" + middle + "0");
            }
            res.add("1" + middle + "1");
            res.add("6" + middle + "9");
            res.add("9" + middle + "6");
            res.add("8" + middle + "8");
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(Strobo(2));
        System.out.println(Strobo(3));
    }
}
