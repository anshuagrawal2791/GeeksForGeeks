/**
 * Created by anshu on 16/01/17.
 */
public class LongestRouteWithoutHurdles {
    static int R=3,C=10;
    static int max_dist = Integer.MIN_VALUE;
    static final int [] row = new int[]{0,0,-1,1};
    static final int [] col = new int[]{-1,1,0,0};
    public static void main(String[] args) {

        int [][] mat = new int[][]{
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };
        int [][] visited = new int[R][C];


        findLongestPath(mat,0,0,1,7,0,visited);
        System.out.println(max_dist);

    }
    private static boolean isValid(int i, int j){
        return(i>=0&&i<R&&j>=0&&j<C);
    }
    private static boolean isSafe(int [][] mat,int i,int j, int [][] visited){
        if(isValid(i,j))
            return (mat[i][j]!=0&&visited[i][j]==0);
        return false;
    }

    private static void findLongestPath(int[][] mat, int i, int j, int x, int y,int dist,int [][] visited) {
        if(i==x&&j==y){
            max_dist=Math.max(dist,max_dist);
        }
        visited[i][j]=1;
        for(int k=0;k<4;k++){
           if(isSafe(mat,i+row[k],j+col[k],visited))
               findLongestPath(mat,i+row[k],j+col[k],x,y,dist+1,visited);
        }
        visited[i][j]=0;

    }
}
