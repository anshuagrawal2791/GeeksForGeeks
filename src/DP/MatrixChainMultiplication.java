package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 20/03/17.
 */
public class MatrixChainMultiplication {
    static int cache[][];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the size of array:");
        int n = scan.nextInt();
        int matrices[] = new int[n];
//        System.out.println("Enter the dimensions");

        for(int i=0;i<n;i++)
            matrices[i]=scan.nextInt();
        cache= new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                cache[i][j]=-1;

        System.out.println("Minimum number of operations by top-down dp: "+MatrixChainOrder2(matrices,1,n-1));
        System.out.println("Minimum number of operations by bottom-up dp: "+MatrixChainOrder3(matrices,n));
        System.out.println("Minimum number of operations by recursion: "+MatrixChainOrder(matrices,1,n-1));

    }

    private static int MatrixChainOrder3(int[] matrices, int n) {
        int m[][] = new int[n][n];
        for(int i=0;i<n;i++)
            m[i][i]=0;
        for(int length=2;length<=n-1;length++){
            for(int from=1;from<=n-length;from++){
                int to = from+length-1;
                int min = Integer.MAX_VALUE;
                for(int k=from;k<to;k++){
                    int res = m[from][k]+m[k+1][to]+matrices[from-1]*matrices[k]*matrices[to];
                    if(res<min)
                        min=res;
                }
                m[from][to]=min;
            }
        }

        return m[1][n-1];
    }

    private static int MatrixChainOrder2(int[] matrices, int i, int j) {
        if(cache[i][j]!=-1)
            return cache[i][j];
        if(i==j){
            cache[i][j]=0;
            return cache[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int res = MatrixChainOrder(matrices,i,k)+MatrixChainOrder(matrices,k+1,j)+matrices[i-1]*matrices[k]*matrices[j];
            if(res<min)
                min=res;
        }
        cache[i][j]= min;
        return min;
    }

    private static int MatrixChainOrder(int[] matrices, int i, int j) {
        if(i==j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int res = MatrixChainOrder(matrices,i,k)+MatrixChainOrder(matrices,k+1,j)+matrices[i-1]*matrices[k]*matrices[j];
            if(res<min)
                min=res;
        }
        return min;

    }
}
