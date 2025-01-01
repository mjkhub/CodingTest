import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[][] directions = {{-1,0}, {0,1}, {1,0},{0,-1}}; // 북 동 남 서

    public static int n, m;

    public static int[][] map;
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);

        String[] robot = br.readLine().split(" ");
        Robot rb =
                new Robot(Integer.parseInt(robot[0]), Integer.parseInt(robot[1]), Integer.parseInt(robot[2]));

        map = new int[n][m];
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        while(true){
            rb.clean();
            boolean isThereCleanedUp = rb.isThereCleanedUp();
            if(!isThereCleanedUp){
                boolean success = rb.moveBack();
                if(!success)
                    break;
            }else{
                rb.changeDirectionAndMoveForward();
            }

        }

        System.out.println(rb.getCount());

    }


    static class Robot{
        int row;
        int col;
        int dir;
        int count = 0;

        public Robot(int row, int col, int dir){
            this.row = row;
            this.col = col;
            this.dir = dir;
        }

        public void clean(){
            if(map[row][col] == 0 ){ //clean
                map[row][col] = -1;
                count++;
            }
        }

        public boolean isThereCleanedUp(){
            for(int[] direction: directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if(0<=newRow && newRow < n && 0<=newCol && newCol < m && map[newRow][newCol] == 0)
                    return true;
            }
            return false;

        }

        public boolean moveBack(){
            int[] backDir = directions[( dir + 2 ) % 4];
            int newRow = row + backDir[0];
            int newCol = col + backDir[1];
            if(0<=newRow && newRow < n && 0<=newCol && newCol < m && map[newRow][newCol] != 1){
                row = newRow;
                col = newCol;
                return true;
            }
            return false;
        }

        public void changeDirectionAndMoveForward(){
            dir = ( dir + 3 ) % 4;
            int newRow = row + directions[dir][0];
            int newCol = col + directions[dir][1];

            if(0<=newRow && newRow < n && 0<=newCol && newCol < m && map[newRow][newCol] == 0 ){
                row = newRow;
                col = newCol;
            }

        }






        public int getCount(){
            return this.count;
        }


    }

}
