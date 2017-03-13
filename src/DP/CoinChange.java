package DP;

import java.io.IOException;

/**
 * Created by anshu on 09/03/17.
 */
public class CoinChange {
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
//        System.out.println("Enter the amount to change: ");
        int n = scan.nextInt();
//        System.out.println("Enter the number of types of coins: ");
        int m = scan.nextInt();
//        System.out.println("Enter the value of coins");
        int a[] = new int[m];
        for(int i=0;i<m;i++)
            a[i]=scan.nextInt();
        System.out.println("No. of ways to split by recursion: "+split(n,a,m-1));
        System.out.println("No. of ways to split by DP: "+split2(n,a,m));
        System.out.println("No. of ways to split by optimised DP: "+split3(n,a,m));
    }

    private static int split3(int n, int[] a, int m) {
        int arr[]= new int[n+1];
        arr[0]=1;
        for(int i=0;i<m;i++){
            for(int j=a[i];j<=n;j++){
                arr[j] += arr[j-a[i]];
            }
        }
        System.out.println("Optimised dp array:");
        for(int i=0;i<n+1;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        return arr[n];
    }

    private static int split2(int n, int[] a, int m) {
        int arr[][] = new int[n+1][m];
        for(int j=0;j<m;j++)
            arr[0][j]=1;
        for(int i=1;i<n+1;i++){
            for(int j=0;j<m;j++){
                int x=0;
                if(i-a[j]>=0){
                    x=arr[i-a[j]][j];
                }
                int y=0;
                if(j>0)
                    y=arr[i][j-1];
                arr[i][j]=x+y;
            }
        }
        System.out.println("DP Matrix");
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        return arr[n][m-1];
    }

    private static int split(int n, int[] a, int m) {
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        if(m<0&&n>0)
            return 0;

        return split(n-a[m],a,m)+split(n,a,m-1);
    }
}
