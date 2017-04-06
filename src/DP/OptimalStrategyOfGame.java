package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 05/04/17.
 */

/*
If the first player has to only win without caring about achieving max amount of coins:
First, we count the amount of the coins in even and odd positions. And then the strategy
is to always choose the coin in even/odd position. Let's say even sum > odd sum. Then, the player
1 has to start by selecting rightmost coin (which is in even position).
Now, the second player can only pickup the coin in odd position. It only works if number of coins is even.
 */

public class OptimalStrategyOfGame {
    static int a[];
    static int cache[][];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        a = new int[n];
        cache = new int[n][n];
        for (int part[]:cache
             ) {
            Arrays.fill(part,-1);
        }
        for(int i=0;i<n;i++)
            a[i]=scan.nextInt();
        System.out.println("Maximum sum: "+play(0,n-1));
    }

    private static int play(int i, int j) {
//        System.out.println(i+" "+j);
        if(cache[i][j]!=-1)
            return cache[i][j];
        if (i == j)
            return cache[i][j]=a[i];
        else if(j==i+1)
            return cache[i][j]=Math.max(a[i],a[j]);
            else return cache[i][j]=Math.max(a[i] + Math.min(play(i + 2, j),play(i+1,j-1)), a[j] + Math.min(play(i, j - 2),play(i+1,j-1)));

    }
}
