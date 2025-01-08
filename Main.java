import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n,m;
    public static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public static boolean[][] visit;
    public static int row = 0;
    public static int col =0;
    public static int dir = 0;
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        visit = new boolean[n][m];
        visit[0][0] = true;
        int count =0;

        while(true){
            int nextRow = row + directions[dir][0];
            int nextCol = col + directions[dir][1];
            if(isGoodToGo(nextRow, nextCol)){
                visit[nextRow][nextCol] = true;
                row = nextRow;
                col = nextCol;
            }else{ //change direction
                dir = (dir + 1) % 4 ;
                count++;
                nextRow = row + directions[dir][0]; // end case
                nextCol = col + directions[dir][1];
                if(!isGoodToGo(nextRow,nextCol))
                    break;
            }


        }
        System.out.println(count-1);

    }

    public static boolean isGoodToGo(int row , int col){
        return 0<=row && row < n && 0<=col && col < m && !visit[row][col];
    }


}
