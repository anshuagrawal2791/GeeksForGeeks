package DP;

import java.util.Scanner;

/**
 * Created by anshu on 20/03/17.
 */
public class LognestPalindromicSubsequence {
    static int cache[][];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int n = s.length();
        cache = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                cache[i][j]=-1;
        System.out.println("longest palindromic subesequence by recursion: "+lps(s,0,n-1));
        System.out.println("longest palindromic subesequence by top-down dp: "+lps2(s,0,n-1));
        System.out.println("longest palindromic subesequence by bottom-up dp: "+lps3(s,n));
    }

    private static int lps3(String s, int n) {
        int m[][] = new int[n][n];
        for(int i=0;i<n;i++)
            m[i][i]=1;
        for(int i=0;i<n-1;i++)
            if(s.charAt(i)==s.charAt(i+1))
                m[i][i+1]=2;

        for(int length =2;length<=n;length++){
            for(int from = 0;from<=n-length;from++){
                int to = from+length-1;
                if(s.charAt(from)==s.charAt(to))
                    m[from][to]=2+m[from+1][to-1];
                else {
                    m[from][to]= Math.max(m[from+1][to],m[from][to-1]);
                }
            }
        }



        return m[0][n-1];
    }

    private static int lps2(String s, int i, int j) {
        if(cache[i][j]!=-1)
            return cache[i][j];
        if(i==j){
            cache[i][j]=1;
            return 1;
        }
        if(s.charAt(i)==s.charAt(j)&&j==i+1){
            cache[i][j]=2;
            return 2;
        }
        if(s.charAt(i)==s.charAt(j)){
            cache[i][j]= 2+lps(s,i+1,j-1);
            return cache[i][j];
        }
        cache[i][j]= Math.max(lps(s,i+1,j),lps(s,i,j-1));
        return cache[i][j];

    }

    private static int lps(String s, int i, int j) {
        if(i==j){
            return 1;
        }
        if(s.charAt(i)==s.charAt(j)&&j==i+1){
            return 2;
        }
        if(s.charAt(i)==s.charAt(j)){
            return 2+lps(s,i+1,j-1);
        }
        return Math.max(lps(s,i+1,j),lps(s,i,j-1));
    }


}
