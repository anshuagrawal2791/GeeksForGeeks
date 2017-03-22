package DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by anshu on 22/03/17.
 */
public class LongestSubstringWIthoutRepetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char a[] = scan.next().toCharArray();
        int n = a.length;
        int global = Integer.MIN_VALUE;
        int i=0,j=1;
        HashSet<Character> set = new HashSet<>();
        set.add(a[i]);
        int p=i,q=j;
        while(i<n&&j<n){
            if(!set.contains(a[j])){
                set.add(a[j++]);
                global = Math.max(global,j-i);
                if(global==j-i)
                {
                    p=i;q=j;
                }
            }else{
                set.remove(a[i++]);
            }
        }

        System.out.println("The length of the longest non-repeating character substring is: "+global);
        System.out.print("One of the longest non-repeating character substrings is: ");
        for(int l=p;l<q;l++)
            System.out.print(a[l]);


    }
}
