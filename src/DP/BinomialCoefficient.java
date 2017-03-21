package DP;

import java.util.Scanner;

/**
 * Created by anshu on 21/03/17.
 */
public class BinomialCoefficient {
    static int cache[][];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        cache = new int[n+1][k+1];
        for(int i=0;i<n+1;i++)
            for(int j=0;j<k+1;j++)
                cache[i][j]=-1;
        System.out.println("Binomial Coefficient by recursion: "+binomial(n,k));
        System.out.println("Binomial Coefficient by top-down dp: "+binomial2(n,k));
        System.out.println("Binomial Coefficient by bottom-up dp: "+binomial3(n,k));
        System.out.println("Binomial Coefficient by optimised bottom-up dp: "+binomial4(n,k));
    }

    private static int binomial3(int n, int k) {
        int a[][] = new int[n+1][k+1];


        for(int i=0;i<n+1;i++){
            for(int j=0;j<=Math.min(i,k);j++){
                if (j == 0 || j == i)
                    a[i][j] = 1;
                else
                    a[i][j] = a[i-1][j-1] + a[i-1][j];
            }
        }

        System.out.println("DP Matrix");
        for(int i=0;i<n+1;i++){
            for(int j=0;j<k+1;j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }

        return a[n][k];
    }

    private static int binomial4(int n,int k){
        int a[] = new int [k+1];
        a[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=Math.min(i,k);j>0;j--){
                a[j]+=a[j-1];
            }
        }

        return a[k];
    }

    private static int binomial2(int n, int k) {
        if(cache[n][k]!=-1)
            return cache[n][k];
        if(k==n||k==0){
            cache[n][k]=1;
        }else{
            cache[n][k]=binomial(n-1,k-1)+binomial(n-1,k);
        }
        return cache[n][k];
    }

    private static int binomial(int n, int k) {
        if(k==n)
            return 1;
        if(k==0)
            return 1;
        else return binomial(n-1,k-1)+binomial(n-1,k);
    }
}
