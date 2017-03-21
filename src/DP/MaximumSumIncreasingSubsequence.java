package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 21/03/17.
 */
public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        System.out.println("enter the size of the array:");
        int n = scan.nextInt();
//        System.out.println("Enter the elements:");
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i]=scan.nextInt();
        
        findMaxSum(a,n);

    }

    private static void findMaxSum(int[] a, int n) {
        int lis[] = new int[n];
        for(int i=0;i<n;i++)
            lis[i]=a[i];

        for(int i=1;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                if(a[j]<a[i]&& lis[j]>max)
                    max=lis[j];
            }
            if(max!=Integer.MIN_VALUE)
                lis[i]+=max;
        }
        int max= Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            if(lis[i]>max)
                max=lis[i];

        System.out.println(max);

    }
}
