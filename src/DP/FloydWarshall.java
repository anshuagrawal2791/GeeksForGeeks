package DP;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by anshu on 29/03/17.
 */
public class FloydWarshall {
    static class Graph{
        int a[][];
        int v;
        int dist[][];
        int path[][];
//        int parent[];

        public Graph(int v) {
            this.v=v;
            a= new int[v][v];
            for(int i=0;i<v;i++)
                for(int j=0;j<v;j++) {
                    if (i != j)
                        a[i][j] = Integer.MAX_VALUE;
                    else
                        a[i][j]=0;
                }
        }
        private void addEdge(int source,int destination,int weight){
            a[source][destination]=weight;
        }
        private void allPairShortestPaths(){
            dist = new int[v][v];
            path = new int[v][v];
//            parent = new int[v];
//            Arrays.fill(parent,-1);
            for(int i=0;i<v;i++)
                for(int j=0;j<v;j++)
                    dist[i][j]=a[i][j];

            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    if(dist[i][j]!=Integer.MAX_VALUE&&dist[i][j]!=0) {
                        path[i][j] = i;
//                        parent[j]=i;
                    }
                    else
                        path[i][j]=Integer.MAX_VALUE;
                }
            }
            for(int k=0;k<v;k++){
                for(int i=0;i<v;i++){
                    for(int j=0;j<v;j++){
                        if(dist[i][k]!=Integer.MAX_VALUE&&dist[k][j]!=Integer.MAX_VALUE&&dist[i][k]+dist[k][j]<dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            path[i][j]=path[k][j];
//                            parent[j]=k;
                        }
                    }
                }
            }
            printArray(dist,v,v);
            printArray(path,v,v);

        }

        private void printArray(int[][] dist, int rows, int cols) {
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    System.out.printf("%14d",dist[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }

        public boolean hasNegativeWeightCycle() {
//            allPairShortestPaths();
            for(int i=0;i<v;i++){
                if(dist[i][i]<0)
                    return true;
            }

            return false;
        }

        public void printPath(int i, int j) {
//            allPairShortestPaths();
            Stack<Integer> stack = new Stack<>();
            stack.add(j);
            while(true){
                int next = path[i][stack.peek()];
                if(next==Integer.MAX_VALUE){
                    System.out.println("No path from "+i+" to "+j);
                    return;
                }
                stack.push(next);
                if(next==i)
                    break;
            }
            System.out.println("Path from "+i+" to "+j);
            while(!stack.isEmpty())
                System.out.print(stack.pop()+" ");
            System.out.println();
        }


    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int v = scan.nextInt();
        Graph graph = new Graph(v);
        int edges = scan.nextInt();
        for(int i=0;i<edges;i++){
            graph.addEdge(scan.nextInt(),scan.nextInt(),scan.nextInt());
        }
        graph.allPairShortestPaths();
        if(graph.hasNegativeWeightCycle())
            System.out.println("graph has negative weight cycle");
        else
            System.out.println("graph doesn't have negative weight cycle");

        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                graph.printPath(i,j);
            }
        }
    }
}
