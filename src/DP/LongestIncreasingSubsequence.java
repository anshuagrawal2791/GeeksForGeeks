package DP;

import java.io.IOException;

/**
 * Created by anshu on 09/03/17.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        System.out.println("enter size of array");
        int n = scan.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        System.out.println("enter the elements");
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();

        }
        b[n-1]=1;
        for(int i=n-2;i>=0;i--){
            b[i]=find(a,b,i,n)+1;     //find largest b[j] such that j>i and a[j]>a[i]
        }
        for(int i=0;i<n;i++)
            System.out.print(b[i]+" ");
        System.out.println();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<b.length;i++)
            if(b[i]>max)
                max=b[i];
        System.out.println("length of lis: "+max);

    }

    private static int find(int[] a, int[] b, int i,int n) {
        int max=Integer.MIN_VALUE;
        for(int j=i+1;j<n;j++){
            if(a[j]>a[i]&&b[j]>max)
                max=b[j];
        }
        if(max!=Integer.MIN_VALUE)
            return max;
        else
             return 1;
    }

}
