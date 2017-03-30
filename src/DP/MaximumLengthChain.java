package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 30/03/17.
 */
public class MaximumLengthChain {
    static Pair a[];
    static int[] parent;
    static class Pair{
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "{" +
                    + start +
                    "," + end +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        a=new Pair[n];
        parent = new int[n];
        Arrays.fill(parent,-1);
        for(int i=0;i<n;i++){
            a[i]=new Pair(scan.nextInt(),scan.nextInt());
        }
        System.out.println("Maximum length of chain is: "+maxLengthChain(n));
    }

    private static int maxLengthChain(int n) {
        int b[] = new int [n];
        Arrays.fill(b,1);
        for(int i=n-2;i>=0;i--){
            int max=Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                if(a[j].start>a[i].end&&b[j]>max) {
                    max = b[j];
                    parent[i]=j;
                }
            }
            if(max!=Integer.MIN_VALUE)
                b[i]=max+1;
        }
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        for(int i=0;i<n;i++){
            if(b[i]>max) {
                max = b[i];
                max_index=i;
            }
        }
        printChain(max_index);
        return max;

    }

    private static void printChain(int i) {
        System.out.println("One of the longest chains: ");
        while(i!=-1){
            System.out.print(a[i].toString());
            i=parent[i];
        }
        System.out.println();

    }
}
