/**
 * Created by anshu on 18/01/17.
 */
public class RatInAMaze {
    public static final int N = 4;
    static int [] row = new int[]{0,1};
    static int [] col = new int[]{1,0};
    public static void main(String[] args) {
        int maze[][]  =  new int [][]{ {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        int [][] visited = new int[N][N];
        visited[0][0]=1;
        boolean z = run(maze,visited,0,0);
        if(z){
            for(int x=0;x<N;x++){
                for(int y=0;y<N;y++)
                    System.out.print(visited[x][y]);
                System.out.println();
            }
        }
        else
            System.out.println("No Solution");
    }

    private static boolean run(int[][] maze, int[][] visited, int i, int j) {
        if(i==N-1&&j==N-1)
            return true;

//        for(int x=0;x<N;x++){
//            for(int y=0;y<N;y++)
//                System.out.print(visited[x][y]);
//            System.out.println();
//        }

        for(int k=0;k<2;k++){
            if(isSafe(visited,i+row[k],j+col[k],maze))
            {
                visited[i+row[k]][j+col[k]]=1;
                if(run(maze,visited,i+row[k],j+col[k]))
                    return true;
                else
                    visited[i+row[k]][j+col[k]]=0;

            }
        }
        return false;
    }

    private static boolean isSafe(int[][] visited, int i, int j,int [][] maze) {
        if(i>=0&&i<N&&j>=0&&j<N){
            if(visited[i][j]==0&&maze[i][j]==1)
                return true;
            else
                 return false;
        }
        return false;
    }


}
