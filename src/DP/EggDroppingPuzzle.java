package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 19/03/17.
 */
public class EggDroppingPuzzle {
    static int cache[][];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter number of eggs:");
        int n = scan.nextInt();
//        System.out.println("Enter the number of floors:");
        int k = scan.nextInt();
        cache = new int[n+1][k+1];
        for(int i=0;i<n+1;i++)
            for(int j=0;j<k+1;j++)
                cache[i][j]=-1;

        System.out.println("The minimum number of attempts in the worst case by top-down dp: "+ eggDrop2(n,k));
        System.out.println("The minimum number of attempts in the worst case by bottom-up dp: "+ eggDrop3(n,k));
        System.out.println("The minimum number of attempts in the worst case by recursion: "+ eggDrop(n,k));
    }

    private static int eggDrop3(int n, int k) {
        int a[][] = new int[n+1][k+1];

        for(int j=0;j<k+1;j++)
            a[1][j]=j;
        for(int i=1;i<n+1;i++){
            a[i][0]=0;
            a[i][1]=1;
        }
        for(int i=2;i<n+1;i++){
            for(int j=2;j<k+1;j++){
                int min = Integer.MAX_VALUE;
                for(int x=1;x<=j;x++){
                    int res = Math.max(a[i-1][x-1],a[i][j-x]);
                    if(res<min)
                        min=res;
                }
                a[i][j]=min+1;
            }
        }

        return a[n][k];
    }

    private static int eggDrop(int n, int k) {
//        System.out.println(n+" "+k);
        if(n==1)
            return k;
        if(k==1||k==0)
            return k;
        int min=Integer.MAX_VALUE;
        for(int x=1;x<=k;x++){
            int res = Math.max(eggDrop(n-1,x-1),eggDrop(n,k-x));
            if(res<min)
                min = res;
        }
        return min+1;

    }
    private static int eggDrop2(int n, int k) {
        if(cache[n][k]!=-1)
            return cache[n][k];
//        System.out.println(n+" "+k);
        if(n==1)
            return k;
        if(k==1||k==0)
            return k;
        int min=Integer.MAX_VALUE;
        for(int x=1;x<=k;x++){
            int res = Math.max(eggDrop2(n-1,x-1),eggDrop2(n,k-x));
            if(res<min)
                min = res;
        }
        cache[n][k]= min+1;
        return cache[n][k];

    }
}
