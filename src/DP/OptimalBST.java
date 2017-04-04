package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 04/04/17.
 */
public class OptimalBST {
    static int[] keys;
    static int[] freq;
    static int[][] cache;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        keys = new int[n];
        freq = new int[n];
        cache = new int[n+1][n+1];
        for (int [] part:cache
             ) {
            Arrays.fill(part,-1);
        }
        for(int i=0;i<n;i++){
            keys[i]= scan.nextInt();
            freq[i]=scan.nextInt();
        }
        System.out.println("minimum search cost is : "+ optBST(0,n-1));
    }

    private static int optBST(int i, int j) {
        if(i>j)
            return 0;
        else if(cache[i][j]!=-1)
            return cache[i][j];

        else if(i==j){
            return cache[i][j]=freq[i];
        }
        else {
            int fsum = getSum(i, j);
            int min = Integer.MAX_VALUE;
            for (int k = i; k <= j; k++) {
                int res = optBST(i, k - 1) + optBST(k + 1, j);
                if (res < min)
                    min = res;
            }
            cache[i][j]= min + fsum;
        }
        return cache[i][j];

    }

    private static int getSum(int i, int j) {
        int sum=0;
        for(int k=i;k<=j;k++){
            sum+=freq[k];
        }
        return sum;
    }
}
