package DP;

import java.io.IOException;

/**
 * Created by anshu on 13/03/17.
 */
//testcase
//        50
//        3
//        10 20 30
//        60 100 120
public class Knapsack {
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        System.out.println("Enter the limit of weight");
        int W = scan.nextInt();
        System.out.println("Enter the size of weights array");
        int n = scan.nextInt();
        System.out.println("Enter the weights");
        int weights[] = new int[n];
        for(int i=0;i<n;i++)
            weights[i]=scan.nextInt();
        System.out.println("Enter the values");
        int values[] = new int[n];

        for(int i=0;i<n;i++)
            values[i]=scan.nextInt();
        System.out.println("maximum value by recursion :"+knapsack(weights,values,n-1,W));
        System.out.println("maximum value by dp :"+knapsack2(weights,values,n,W));
        System.out.println("maximum value by optimised dp :"+knapsack3(weights,values,n,W));


        System.out.println("maximum value by recursion with repetition :"+knapsack4(weights,values,n-1,W));
        System.out.println("maximum value by dp with repetition:"+knapsack5(weights,values,n,W));
        System.out.println("maximum value by optimised dp with repetition :"+knapsack6(weights,values,n,W));
    }

    private static int knapsack3(int[] weights, int[] values, int n, int w) {
        int a[] = new int [w+1];
        for(int i=0;i<n;i++){
            for(int j=w;j>=weights[i];j--){          /////// we traverse this array from right to left since each value can be picked only once///if we could use each value more than once, traverse this from left to right
                a[j] = Math.max(a[j],values[i]+a[j-weights[i]]);
            }
        }
        return a[w];

    }
 private static int knapsack6(int[] weights, int[] values, int n, int w) {
        int a[] = new int [w+1];
        for(int i=0;i<n;i++){
            for(int j=weights[i];j<=w;j++){          /////// we traverse this array from right to left since each value can be picked only once///if we could use each value more than once, traverse this from left to right
                a[j] = Math.max(a[j],values[i]+a[j-weights[i]]);
            }
        }
        return a[w];

    }

    private static int knapsack2(int[] weights, int[] values, int n, int w) {
        int a[][] = new int[w+1][n+1];
        for(int i=0;i<w+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0)
                    a[i][j]=0;
                else if(j==0)
                    a[i][j]=0;
                else if(i>=weights[j-1]){
                    a[i][j]=Math.max(values[j-1]+a[i-weights[j-1]][j-1],a[i][j-1]); /// if we could pick each value more than once, a[i][j] = Math.max(values[j-1]+a[i-weights[j-1][j],a[i][j-1])
                }
                else{
                    a[i][j]=a[i][j-1];
                }

            }
        }

        System.out.println("DP Matrix");
        for(int i=0;i<w+1;i++){
            for(int j=0;j<n+1;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        return a[w][n];
    }
private static int knapsack5(int[] weights, int[] values, int n, int w) {
        int a[][] = new int[w+1][n+1];
        for(int i=0;i<w+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0)
                    a[i][j]=0;
                else if(j==0)
                    a[i][j]=0;
                else if(i>=weights[j-1]){
                    a[i][j]=Math.max(values[j-1]+a[i-weights[j-1]][j],a[i][j-1]); /// if we could pick each value more than once, a[i][j] = Math.max(values[j-1]+a[i-weights[j-1][j],a[i][j-1])
                }
                else{
                    a[i][j]=a[i][j-1];
                }

            }
        }

        System.out.println("DP Matrix");
        for(int i=0;i<w+1;i++){
            for(int j=0;j<n+1;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        return a[w][n];
    }

    private static int knapsack(int[] weights, int[] values, int i, int w) {
        if(w==0)
            return 0;
        if(i<0||w<0)
            return 0;

        return Math.max(values[i]+knapsack(weights,values,i-1,w-weights[i]),knapsack(weights,values,i-1,w)); ///if each value can be used more than once, return Math.max(values[i]+knapsack(weights,values,i,w-weights[i]),knapsack(weights,values,i-1,w));
    }
    private static int knapsack4(int[] weights, int[] values, int i, int w) {
//        System.out.println(i+" "+w);
        if(w==0)
            return 0;
        if(i<0||w<0)
            return 0;

        return Math.max(values[i]+knapsack4(weights,values,i,w-weights[i]),knapsack4(weights,values,i-1,w)); ///if each value can be used more than once, return Math.max(values[i]+knapsack(weights,values,i,w-weights[i]),knapsack(weights,values,i-1,w));
    }
}
