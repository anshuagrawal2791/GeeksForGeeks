package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 29/03/17.
 */
public class PalidromicPartition {
    static int cache[][];
    static int partitions[][];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        char[] a = s.toCharArray();
        int n = a.length;
        cache = new int[n+1][n+1];
        partitions = new int[n+1][n+1];
        for (int [] part: cache) {
            Arrays.fill(part,-1);
        }for (int [] part: partitions) {
            Arrays.fill(part,-1);
        }
        double t = System.nanoTime();
        System.out.println("Number of palindromic partitions by recursion: "+pp(a,0,n-1)+" time taken "+(System.nanoTime()-t));
        t = System.nanoTime();
        System.out.println("Number of palindromic partitions by top - down dp: "+pp2(a,0,n-1)+" time taken "+(System.nanoTime()-t));
        System.out.println("parted string:");
//        System.out.println(Arrays.deepToString(partitions));
        printParted(a,0,n-1);
    }

    private static void printParted(char[] a, int i, int j) {
//        System.out.println(i+" "+j);
        if(partitions[i][j]==-1)
        {
            for(int x=i;x<=j;x++)
                System.out.print(a[x]);
        }else{
        for(int x=i;x<=partitions[i][j];x++)
            System.out.print(a[x]);
        System.out.print("|");
        printParted(a,partitions[i][j]+1,j);}
    }

    private static int pp2(char[] a, int i, int j) {
        if(cache[i][j]!=-1)
            return cache[i][j];
        else if(i==j)
            cache[i][j]=0;
        else if(isPal(a,i,j))
            cache[i][j]=0;
        else{
            int min = Integer.MAX_VALUE;
            for(int k=i;k<j;k++){
                int res = pp(a,i,k)+pp(a,k+1,j);
                if(res<min){
                    min=res;
//                    partitions[i][j]=k;
                }
            }
            cache[i][j]=min+1;
        }
        return cache[i][j];
    }

    private static int pp(char[] a,int i, int j) {
        if(i==j)
            return 0;
        if(isPal(a,i,j))
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int res = pp(a,i,k)+pp(a,k+1,j);
            if(res<min){
                min=res;
                partitions[i][j]=k;
            }
        }
        return min+1;
    }

    private static boolean isPal(char[] a, int begin, int end) {
        int middle = (begin + end)/2;

        int i;
        for (i = begin; i <= middle; i++) {
            if (a[begin] == a[end]) {
                begin++;
                end--;
            }
            else {
                break;
            }
        }
        if (i == middle + 1) {
            return true;
        }
        else {
            return false;
        }

    }
}
