import java.util.HashMap;

/**
 * Created by anshu on 18/01/17.
 */
public class PatternMatching {
    public static void main(String[] args) {
        String str = "GeeksforGeeks", pattern = "GFG";
        HashMap<String, String> map = new HashMap<>();

        boolean y = find(str,pattern,0,0,map);
//        System.out.println(find(str,pattern,0,0,map));
        if(y){
            for(String x : map.keySet()){
                System.out.println(x+" -> " + map.get(x));
            }
        }
        else{
            System.out.println("no solution");
        }


    }

    private static boolean find(String str, String pattern, int i, int x, HashMap<String, String> map) {
        System.out.println(map);
        if(i==str.length()&&x==pattern.length())
            return true;
        if(i==str.length()||x==pattern.length())
            return false;

        char ch = pattern.charAt(x);
        if(map.keySet().contains(String.valueOf(ch))){
            System.out.println("here");
            String a = map.get(String.valueOf(ch));
            try{
                if(!str.substring(i,i+a.length()).equals(a)){
                    System.out.println("++"+str.substring(i,i+a.length()));
                    return false;
                }
            }catch (Exception e)
            {
                return false;
            }
            return find(str,pattern,i+a.length(),x+1,map);
        }
        for(int k = i+1;k<=str.length();k++){
            String b = str.substring(i,k);
            System.out.println(b);
            map.put(String.valueOf(ch),b);
            if(find(str,pattern,i+b.length(),x+1,map))
                return true;
            else map.remove(String.valueOf(ch));

        }
        return false;
    }
}
