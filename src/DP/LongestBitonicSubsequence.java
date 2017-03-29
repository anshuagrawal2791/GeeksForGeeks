package DP;

import java.util.Scanner;

/**
 * Created by anshu on 28/03/17.
 */
public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i]=scan.nextInt();
        System.out.println("length of longest bitonic subsequence is :"+ lbs(a,n));
    }

    private static int lbs(int[] a, int n) {
        int lis[] = new int[n];
        int lds[] = new int[n];
        for(int i=0;i<n;i++){
            lis[i]=1;
            lds[i]=1;
        }
        for(int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                if(a[j]<a[i]&&lis[j]>max)
                    max=lis[j];
            }
            lis[i]=max+1;
        }
        for(int i=n-1;i>=0;i--){
            int max = Integer.MIN_VALUE;
            for(int j=n-1;j>i;j--){
                if(a[j]<a[i]&&lds[j]>max)
                    max=lds[j];
            }
            lds[i]=max+1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(lis[i]+lds[i]-1>max)
                max=lis[i]+lds[i]-1;
        }
        return max;
    }
}
