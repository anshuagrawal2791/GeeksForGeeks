package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 07/04/17.
 */
public class MinimumCoinChange {
    static int a[];
    static int m;
    static int cache[];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=scan.nextInt();
        m = scan.nextInt();
        cache = new int[m+1];
       Arrays.fill(cache,-1);
        System.out.println("minimum coins needed are: "+ minCoins2(n-1,m,0));
        System.out.println(Arrays.toString(cache));
    }

    private static int minCoins(int i,int curSum,int coins) {
        if(curSum==0&&i>=0)
            return coins;
        if(i<0||curSum<0)
            return Integer.MAX_VALUE;

        return Math.min(minCoins(i,curSum-a[i],coins+1),minCoins(i-1,curSum,coins));


    }
    private static int minCoins2(int i,int curSum,int coins) {
//        if(i<0||curSum<0)
//            return Integer.MAX_VALUE;
//        if(curSum==0)
//            return coins;
//        if(cache[curSum]!=-1)
//            return cache[curSum];
//        return cache[curSum]=Math.min(minCoins2(i,curSum-a[i],coins+1),minCoins2(i-1,curSum,coins));
        if(curSum==0)
            return 0;
        if(cache[curSum]!=-1)
            return cache[curSum];
        int min = Integer.MAX_VALUE;
        for(int k=0;k<=i;k++){
            if(curSum>=a[k]){
                int val = minCoins2(i,curSum-a[k],coins);
                if(val<min)
                    min=val;
            }
        }
        if(min!=Integer.MAX_VALUE)
            min+=1;
        cache[curSum]=min;
        return cache[curSum];
    }
}
