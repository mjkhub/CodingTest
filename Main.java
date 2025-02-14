import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static int[][] arr;
    public static boolean[][] visit;

    public static int w, h;

    public static int[][] directions = {{-1,-1}, {-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            if(w==0 && h==0) break;

            arr = new int[h][w];
            visit = new boolean[h][w];
            for(int i=0; i<h; i++){
                String[] s = br.readLine().split(" ");
                for(int j=0; j<w; j++){
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }

            int count =0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visit[i][j] && arr[i][j] == 1){
                        count++;
                        dfs(i,j);
                    }
                }
            }
            System.out.println(count);

        }
    }

    public static void dfs(int row, int col){
        visit[row][col] = true;

        for(int[] dir: directions){
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(0<=nr && nr <h && 0<=nc && nc < w && !visit[nr][nc] && arr[nr][nc] == 1){
                dfs(nr,nc);
            }
        }
    }



}
