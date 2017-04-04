package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 04/04/17.
 */
public class SubsetSum {
    static int a[];
    static int k;
    static int cache[][];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=scan.nextInt();
        k = scan.nextInt();
        cache = new int [n][k+1];
        for (int[] part:cache
             ) {
            Arrays.fill(part,-1);
        }
        System.out.println("by recursion "+isSubsetSumPossible(n-1,k)+"");
        System.out.println("by top-down dp "+isSubsetSumPossible2(n-1,k)+""); //1 is true: 0 is false
        System.out.println("by optimised bottom-up dp "+isSubsetSumPossible3(n-1,k)+"");
    }


    private static boolean isSubsetSumPossible3(int i, int k) {
        boolean aux[] = new boolean[k+1];
        aux[0]=true;
        for(int l=0;l<=i;l++){
            for(int m=k;m>=a[l];m--){
                aux[m]=aux[m]||aux[m-a[l]];
            }
//            System.out.println(Arrays.toString(aux));
        }
        ///##### if each element can be used multiple times#####////


//        for(int l=0;l<=i;l++){
//            for(int m=a[l];m<=k;m++){
//                aux[m]=aux[m]||aux[m-a[l]];
//            }
//            System.out.println(Arrays.toString(aux));
//        }

        // ######################################### //
        return aux[k];


    }

    private static int isSubsetSumPossible2(int i, int curSum) {

        if(curSum==0&&i<0)
            return 1;
        if(i<0)
            return 0;
        else if(cache[i][curSum]!=-1)
            return cache[i][curSum];
        if(curSum==0)
            return cache[i][curSum]=1;
        if(curSum<a[i])
            return cache[i][curSum]=isSubsetSumPossible2(i-1,curSum);
        else {
            if(isSubsetSumPossible2(i-1,curSum-a[i])==1||isSubsetSumPossible2(i-1,curSum)==1)
                return cache[i][curSum]=1;
            else
                return cache[i][curSum]=0;
//            return cache[i][curSum] = (isSubsetSumPossible2(i - 1, curSum - a[i]) || isSubsetSumPossible2(i - 1, curSum));
        }
    }

    private static boolean isSubsetSumPossible(int i, int curSum) {
//        System.out.println(i+" "+curSum);
        if(curSum==0)
            return true;
        if(i<0)
            return false;
        if(curSum<a[i])
            return isSubsetSumPossible(i-1,curSum);
        else
            return (isSubsetSumPossible(i-1,curSum-a[i])||isSubsetSumPossible(i-1,curSum));
    }
}
