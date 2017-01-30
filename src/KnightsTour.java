/**
 * Created by anshu on 18/01/17.
 */
public class KnightsTour {
    public static final int N = 8;
    static int xMove[] = new int[]{  2, 1, -1, -2, -2, -1,  1,  2 };
    static int yMove[] = new int[]{  1, 2,  2,  1, -1, -2, -2, -1 };
    public static void main(String[] args) {
        int [][] board  = new int[N][N];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                board[x][y] = -1;
        board[0][0]=0;
//        int [][] visited = new int[N][N];

        System.out.println(tour(board,0,0,1));

        for (int x = 0; x < N; x++){
            for (int y = 0; y < N; y++)
                System.out.print(board[x][y]+" ");
            System.out.println();
        }

    }

    private static boolean tour(int[][] board,int i, int j, int moves) {
        if(moves==(N*N))
            return true;

        for(int k=0;k<8;k++){
            if(isSafe(board,i+xMove[k],j+yMove[k]))
            {
                board[i+xMove[k]][j+yMove[k]]=moves;
                if(tour(board,i+xMove[k],j+yMove[k],moves+1))
                    return true;
                else
                    board[i+xMove[k]][j+yMove[k]]=-1;

            }
        }


        return false;
    }

    private static boolean isSafe(int[][] board, int i, int j) {
        if(i>=0&&i<N&&j>=0&&j<N)
        {
            if(board[i][j]==-1)
                return true;
            else
                return false;
        }
        return false;
    }
}
