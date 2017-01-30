/**
 * Created by anshu on 18/01/17.
 */
public class MaximumNumberKSwaps {
    static int output = Integer.MIN_VALUE;
    public static void main(String[] args) {
        String str = "129814999";

        int k = 4;

        find(str,k,Integer.parseInt(str));
        System.out.println(output);

    }

    private static void find(String str, int k, int curr) {
        if(k==0){
            output = Math.max(output,curr);
            return;
        }
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                str = swap(str,i,j);
                find(str,k-1,Integer.parseInt(str));
                str = swap(str,i,j);
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char temp = str.charAt(i);
        char [] str2 = str.toCharArray();
        str2[i]=str2[j];
        str2[j]=temp;
        return new String(str2);
    }
}
