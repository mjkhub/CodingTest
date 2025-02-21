import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int n, m, k;
    public static int[][] arr;
    public static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public static int max = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        arr = new int[n][m];

        for(int i=0; i<k; i++){
            String[] line = br.readLine().split(" ");
            int row = Integer.parseInt(line[0])-1;
            int col = Integer.parseInt(line[1])-1;
            arr[row][col] = 1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1)
                    max = Math.max(bfs(new int[]{i,j}),max);
            }
        }

        System.out.println(max);

    }

    public static int bfs(int[] start){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        arr[start[0]][start[1]] = 0;

        int count = 0;
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            count++;
            for(int[] dir : directions){
                int newRow = v[0] + dir[0];
                int newCol = v[1] + dir[1];
                if(0<= newRow && newRow < n && 0<=newCol && newCol < m && arr[newRow][newCol]==1 ){
                    queue.add(new int[]{newRow, newCol});
                    arr[newRow][newCol] = 0; // 큐에 중복으로 넣지 않도록 -> 이게 안지켜지면 메모리초과가 발생함
                }
            }

        }

        return count;
    }


}
