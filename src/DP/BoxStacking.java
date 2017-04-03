package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 30/03/17.
 */
public class BoxStacking {
    static box a[];
    static box totalBoxes[];
    static int parent[];
    static int maxIndex;
    static class box implements Comparable{
        int w,d,h,area;

        public box(int h, int d, int w) {
            this.w = w;
            this.d = d;
            this.h = h;
            area=w*d;
        }

        @Override
        public int compareTo(Object o) {
            return area-((box) o).area;
        }

        @Override
        public String toString() {
            return "box{" +
                    "w=" + w +
                    ", d=" + d +
                    ", h=" + h +
                    ", area=" + area +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        a = new box[n];
        parent = new int[3*n];
        Arrays.fill(parent,-1);
        totalBoxes = new box[3*n];
        for(int i=0;i<n;i++){
            a[i]=new box(scan.nextInt(),scan.nextInt(),scan.nextInt());
        }
        System.out.println("the maximum height is: ");
        stackBoxes(n);
    }

    private static void stackBoxes(int n) {
        int heights[] = new int[3*n];

        int index=0;
        for(int i=0;i<n;i++){
            totalBoxes[index]= a[i];
//            heights[index] = totalBoxes[index].h;
            index++;
            totalBoxes[index]= new box(a[i].d,Math.min(a[i].h,a[i].w),Math.max(a[i].h,a[i].w));
//            heights[index] = totalBoxes[index].h;
            index++;
            totalBoxes[index]=new box(a[i].w,Math.min(a[i].h,a[i].d),Math.max(a[i].h,a[i].d));
//            heights[index] = totalBoxes[index].h;
            index++;
        }

        n*=3;
        Arrays.sort(totalBoxes);
        for(int i=0;i<n;i++){
            heights[i]=totalBoxes[i].h;
        }
//        System.out.println(Arrays.toString(heights));
//        System.out.println(Arrays.toString(totalBoxes));
        for(int i=n-1;i>=0;i--){
            int max = Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                if(totalBoxes[j].d>totalBoxes[i].d && totalBoxes[j].w>totalBoxes[i].w&&heights[j]>max){
                    max=heights[j];
                    parent[i]=j;
                }

            }
            if(max!=Integer.MIN_VALUE)
                heights[i]+=max;
        }
//        System.out.println(Arrays.toString(heights));
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            if(heights[i]>max){
                max=heights[i];
                maxIndex=i;
            }

        System.out.println(max);
        printBoxes(maxIndex);
//



    }

    private static void printBoxes(int maxIndex) {
        while(maxIndex!=-1){
            System.out.println(totalBoxes[maxIndex].toString());
            maxIndex=parent[maxIndex];
        }
    }
}
