package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 03/04/17.
 */
public class BellmanFord {

    static class Edge{
        int u,v,weight;


        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class Graph{
        int v,e;
        Edge[] edges;
        static int index=0;
        int [] dist;
        int [] parent;


        public Graph(int v, int e) {
            this.v = v;
            this.e = e;
            edges = new Edge[e];
            dist = new int[v];
            parent = new int[v];
            Arrays.fill(dist,Integer.MAX_VALUE);
            Arrays.fill(parent,-1);
        }
        public void addEdge(int u,int v,int weight){
            edges[index]=new Edge(u,v,weight);
            index++;
        }

        public void bellman(int source) {
            dist[source]=0;
            for(int i=0;i<v-1;i++){
                for(int j=0;j<e;j++){
                    Edge curr = edges[j];
                    int u = curr.u;
                    int v = curr.v;
                    int weight = curr.weight;
                    if(dist[u]!=Integer.MAX_VALUE&&dist[u]+weight<dist[v]){
                        dist[v]=dist[u]+weight;
                        parent[v]=u;
                    }
                }
            }
            boolean flag=true;
            for(int i=0;i<e;i++){
                Edge curr = edges[i];
                int u = curr.u;
                int v = curr.v;
                int weight = curr.weight;
                if(dist[u]!=Integer.MAX_VALUE&&dist[u]+weight<dist[v]){
                    System.out.println("There is a negative weight cycle");
                    flag=false;
                }
            }
            if(flag) {
                System.out.println("There is no negative weight cycle");
                for(int i=0;i<v;i++){
                    System.out.println("distance from "+source+" to "+i+" is "+dist[i]);
                    System.out.println("path from "+source+" to "+i+" is ");
                    printPath(source,i);
                    System.out.println();
                }
            }

        }

        private void printPath(int source, int i) {
            if(i!=-1) {
                printPath(source, parent[i]);
                System.out.print(i + " ");
            }
        }


    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int v = scan.nextInt();
        int e = scan.nextInt();
        Graph graph = new Graph(v,e);
        for(int i=0;i<e;i++){
            graph.addEdge(scan.nextInt(),scan.nextInt(),scan.nextInt());
        }
        graph.bellman(0);
    }
}
