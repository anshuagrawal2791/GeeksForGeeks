package DP;

import java.io.IOException;

/**
 * Created by anshu on 09/03/17.
 */
public class LCS {
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        System.out.println("enter string a: ");
        String str1 = scan.readLine();
        System.out.println("enter string b: ");
        String str2 = scan.readLine();
        System.out.println("length of lcs by recursion: "+lcs1(str1,str2,str1.length()-1,str2.length()-1));
        System.out.println("length of lcs by DP: "+lcs2(str1,str2,str1.length(),str2.length()));

    }

    private static int lcs2(String str1, String str2, int m, int n) {
        int a[][] = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0||j==0)
                    a[i][j]=0;
                else if(str2.charAt(j-1)==str1.charAt(i-1))
                    a[i][j]=a[i-1][j-1]+1;
                else{
                    a[i][j]=Math.max(a[i-1][j],a[i][j-1]);
                }
            }
        }
        return a[m][n];


    }

    private static int lcs1(String str1, String str2, int m, int n) {
        if(m<0||n<0)
            return 0;
        if(str1.charAt(m)==str2.charAt(n))
            return 1+lcs1(str1,str2,m-1,n-1);
        else
            return Math.max(lcs1(str1,str2,m,n-1),lcs1(str1,str2,m-1,n));
    }
}
