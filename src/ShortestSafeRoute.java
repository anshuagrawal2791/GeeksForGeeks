/**
 * Created by anshu on 15/01/17.
 */
public class ShortestSafeRoute {
    static int min_dist;
    static int R = 12,C=10;
    static final int [] row = new int[]{0,0,-1,1};
    static final int [] col = new int[]{-1,1,0,0};
    public static void main(String[] args) {
        int mat[][] = new int[][]{
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
        };

        markUnsafe(mat);
        print(mat);
        // find shortest path
        findShortestPath(mat);
    }

    private static void print(int[][] mat) {
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++)
                System.out.print(mat[i][j]+" ");
            System.out.println();
        }
    }

    private static void markUnsafe(int[][] mat) {
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(mat[i][j]==0){
                    for(int k=0;k<4;k++){
                        if(isSafe(mat,i + row[k],j+col[k]))
                            mat[i + row[k]][j+col[k]]=-1;
                    }
                }

            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++)
                if(mat[i][j]==-1)
                    mat[i][j]=0;
        }
    }

    private static boolean isValid(int [][] mat, int i, int j){
        return((i>=0&&i<R)&&(j>=0&&j<C));
    }
    private static boolean isSafe(int [][] mat, int i, int j){
        if(isValid(mat,i,j)){
            if(mat[i][j]!=0)
                return true;
            else
                return false;
        }
        return false;

    }



    private static void findShortestPath(int[][] mat) {

        min_dist = Integer.MAX_VALUE;

        for(int i=0;i<R;i++){
            boolean [][] visited = new boolean[R][C];
            if(mat[i][0]!=0)
                findShortestPathUtil(mat,i,0,0,visited);
            System.out.println("--"+min_dist);

            if(min_dist==C-1)
                break;
        }
        if(min_dist==Integer.MAX_VALUE)
            System.out.println("No Path");
        else
            System.out.println("Length: "+ min_dist);





    }

    private static void findShortestPathUtil(int[][] mat, int i, int j,int dist, boolean[][] visited) {
        if(j==C-1){
            min_dist = Math.min(min_dist,dist);
//            System.out.println("dist"+dist+" "+min_dist);
            return;
        }
        if(dist>min_dist)
            return;
        visited[i][j]=true;

        for(int k=0;k<4;k++){
            if(isValid(mat,i+row[k],j+col[k])&&isSafe(mat,i+row[k],j+col[k])&&!visited[i+row[k]][j+col[k]]){
                findShortestPathUtil(mat,i+row[k],j+col[k],dist+1,visited);
            }
        }
        visited[i][j]=false;

    }
}
