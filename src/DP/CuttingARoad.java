package DP;

import java.util.Scanner;

/**
 * Created by anshu on 20/03/17.
 */

/// same as knapsack (when each weight can be used more than once)
public class CuttingARoad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        System.out.println("enter the length of rod:");
        int n = scan.nextInt();
        int weights[] = new int[n];
        int values[] = new int[n];
        System.out.println("enter the values");
        for(int i=0;i<n;i++){
            weights[i]=i+1;
            values[i]=scan.nextInt();
        }
        System.out.println("maximum value by recursion is: "+cutRod(weights,values,n-1,n));
        System.out.println("maximum value by dp is: "+cutRod2(weights,values,n-1,n));
    }

    private static int cutRod2(int[] weights, int[] values, int k, int w) {
        int a[] = new int[w+1];
        for(int i=0;i<weights.length;i++){
            for(int j=weights[i];j<=w;j++){
                a[j] = Math.max(a[j],values[i]+a[j-weights[i]]);
            }
        }
        return a[w];
    }

    private static int cutRod(int[] weights, int[] values, int i, int w) {
        if(i<0)
            return 0;
        if(w==0)
            return 0;
        if(weights[i]>w)
            return cutRod(weights,values,i-1,w);
        return Math.max(values[i]+cutRod(weights,values,i,w-weights[i]),cutRod(weights,values,i-1,w));

    }
}
