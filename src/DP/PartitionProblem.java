package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 29/03/17.
 */
public class PartitionProblem {
    static int a[];
    static int cache[][];
    static double sum=0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        a = new int[n];
//        cache = new int[n+1][n+1];
//        for (int part[]: cache
//             ) {
//            Arrays.fill(part,-1);
//        }

        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();
            sum+=a[i];
        }
        if(sum%2!=0)
            System.out.println("Cant do partition");
        else {
            System.out.println("can part: "+canPart(n-1,0,new ArrayList<Integer>()));
        }

//        System.out.println(Arrays.deepToString(cache));
    }

    private static boolean canPart(int i, double subSum, ArrayList<Integer> list) {
//        if(cache)
        if(i<0){
            if(subSum==(sum/2)) {
                System.out.println(list.toString());
                return true;
            }
            else
                return false;
        }
        else if(subSum>(sum/2))
            return false;
        else {
            ArrayList<Integer>list2 = new ArrayList<>();
            list2.addAll(list);
            list.add(a[i]);
            return (canPart(i-1,subSum+a[i],list2)||canPart(i-1,subSum,list));
        }
    }
}
