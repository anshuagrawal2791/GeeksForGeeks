package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 29/03/17.
 */
public class WordWrap {
    static int a[];
    static int limit;
    static int wraps[][];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();

        }
        wraps = new int[n+1][n+1];
        for (int part[]: wraps
             ) {
            Arrays.fill(part,-1);
        }
        limit = scan.nextInt();
        System.out.println("total cost: "+wordWrap(0,n-1));
//        System.out.println(Arrays.deepToString(wraps));
        System.out.println("Wraps: ");
        printWords(0,n-1);
    }

    private static void printWords(int i, int j) {
        if(wraps[i][j]==-1){
            for(int x=i;x<=j;x++)
                System.out.print(a[x]+" ");
        }else {
            for (int x = i; x <= wraps[i][j]; x++)
                System.out.print(a[x] + " ");
            System.out.println();
            printWords(wraps[i][j] + 1, j);
        }
    }

    private static double wordWrap(int i,int j) {
        if(i==j){
            return Math.pow(limit-a[i],2);
        }
        if(j==i+1){
            if(a[i]+a[j]+1<=limit)
                return Math.pow(limit-a[i]-a[j]-1,2);
            else
                return Math.pow(limit-a[i],2)+Math.pow(limit-a[j],2);

        }
        int sum=0;
        double min = Double.MAX_VALUE;
        for(int k=i;k<j;k++){
            if(k==i)
                sum+=a[k];
            else
                sum+=a[k]+1;
            if(sum<=limit){
                double res = Math.pow((limit-sum),2)+wordWrap(k+1,j);
                if(res<min) {
                    min = res;
                    wraps[i][j]=k;
                }
            }
            else break;
        }
        return min;
    }
}
