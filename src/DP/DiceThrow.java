package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 05/04/17.
 */
public class DiceThrow {
    static int cache[][];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int x = scan.nextInt();
        cache = new int[n+1][x+1];
        for (int part[]: cache
             ) {
            Arrays.fill(part,-1);
        }
        double t = System.nanoTime();
        System.out.println("number of ways to get x: "+throwDice(n-1,m,x,0)+" time taken: "+ (System.nanoTime()-t));
        t=System.nanoTime();
        System.out.println("number of ways to get x: "+throwDice2(n-1,m,x,0)+" time taken: "+(System.nanoTime()-t));
    }

    private static int throwDice(int i, int m, int x, int curSum) {
        if(curSum==x&&i<0)
            return 1;
        if(i<0)
            return 0;
        int ans=0;
        for(int j=1;j<=m;j++){
            ans+=throwDice(i-1,m,x,curSum+j);
        }
        return ans;

    }
    private static int throwDice2(int i, int m, int x, int curSum) {

        if(curSum==x&&i<0)
            return 1;
        if(i<0)
            return 0;
        if(cache[i][curSum]!=-1)
            return cache[i][curSum];
        int ans=0;
        for(int j=1;j<=m;j++){
            if(curSum+j<=x)
            ans+=throwDice2(i-1,m,x,curSum+j);
        }
        return cache[i][curSum]=ans;

    }
}
