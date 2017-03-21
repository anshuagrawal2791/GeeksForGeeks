package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 21/03/17.
 */
public class MinimumJumps {
    static int cache[];
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i]=scan.nextInt();
        cache = new int[n];
        Arrays.fill(cache,-1);
        long startTime = System.nanoTime();
        System.out.println("Minimum jumps: "+minJumps(a,n,0,0));
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);

        long startTime2 = System.nanoTime();
        System.out.println("Minimum jumps by top-down dp: "+minJumps2(a,n,0,0));
        long stopTime2 = System.nanoTime();
        long elapsedTime2 = stopTime2 - startTime2;
        System.out.println(elapsedTime2);

        long startTime3 = System.nanoTime();

        System.out.println("Minimum jumps by bottom-up dp: "+minJumps3(a,n));
        long stopTime3 = System.nanoTime();
        long elapsedTime3 = stopTime3 - startTime3;
        System.out.println(elapsedTime3);
    }

    private static int minJumps3(int[] a, int n) {
        int jumps[] = new int[n];
        for(int i=n-2;i>=0;i--){
            int min = Integer.MAX_VALUE;
            for(int j=i+1;j<=i+a[i]&&j<n;j++){
//                System.out.println("entered");
                if(jumps[j]<min)
                    min=jumps[j];
            }
            if(min!=Integer.MAX_VALUE)
            jumps[i]=min+1;
            else jumps[i]=Integer.MAX_VALUE;
//            System.out.println(i+" "+ Arrays.toString(jumps));
        }
//        System.out.println(Arrays.toString(jumps));


        return jumps[0];
    }

    private static int minJumps2(int[] a, int n, int curr, int jumps) {
        if(cache[curr]!=-1)
            return cache[curr];
        if(curr>=n-1) {
            cache[curr] = jumps;
            return cache[curr];
        }
        if(a[curr]==0) {
            cache[curr]= Integer.MAX_VALUE;
            return cache[curr];
        }

        int min=Integer.MAX_VALUE;
        for(int i=1;i<=a[curr];i++){
            int res = minJumps(a,n,curr+i,jumps+1);
            if(res<min)
                min=res;
        }
        cache[curr]= min;
        return cache[curr];
    }

    private static int minJumps(int[] a, int n,int curr, int jumps) {
        if(curr>=n-1)
            return jumps;
        if(a[curr]==0)
            return Integer.MAX_VALUE;

        int min=Integer.MAX_VALUE;
        for(int i=1;i<=a[curr];i++){
            int res = minJumps(a,n,curr+i,jumps+1);
            if(res<min)
                min=res;
        }
        return min;
    }
}
