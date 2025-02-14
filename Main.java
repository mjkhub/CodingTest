import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int row, col;
    public static int[][] arr;
    public static boolean[][] visit;
    public static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        row = Integer.parseInt(s[1]); col = Integer.parseInt(s[0]);

        arr = new int[row][col];
        visit = new boolean[row][col];

        int tomatoCount = 0;
        boolean all = true;
        for(int i=0; i<row; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<col; j++){
                arr[i][j] = Integer.parseInt(line[j]);
                if(arr[i][j] == 0){
                    all = false;
                    tomatoCount++;
                }
                else if(arr[i][j] == 1)
                    queue.offer(new Tomato(new int[]{i,j},0));

            }
        }
        if(all){
            System.out.println(0);
            return;
        }

        int day= 0 ;
        while(!queue.isEmpty()){
            Tomato tm = queue.poll();
            visit[tm.pos[0]][tm.pos[1]] = true;
            for(int[] pos : getAdjacentUnMatureTomato(tm.pos)){
                if(!visit[pos[0]][pos[1]]){
                    Tomato temp = new Tomato(pos, tm.depth +1);
                    tomatoCount--;
                    day = Math.max(day, temp.depth);
                    arr[pos[0]][pos[1]] = 1;
                    queue.offer(temp);
                }
            }
        }
        System.out.println( tomatoCount == 0 ? day : -1);

    }


    public static List<int[]> getAdjacentUnMatureTomato(int[] pos){
        List<int[]> adjacent = new ArrayList<>();
        for(int[] dir : directions){
            int nr = pos[0]+ dir[0];
            int nc = pos[1] + dir[1];
            if(0<=nr && nr< row && 0<= nc && nc < col
                    && !visit[nr][nc] && arr[nr][nc] == 0){
                adjacent.add(new int[]{nr, nc});
            }
        }
        return adjacent;
    }

    static class Tomato{
        int[] pos;
        int depth;

        public Tomato(int[] pos, int depth){
            this.pos = pos;
            this.depth = depth;
        }
    }


}
