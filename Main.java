import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n;
    public static int m;
    public static int[][] graph;
    public static boolean[][] bfsVisited;
    public static int[][] minDepth;

    public static Queue<Vertex> queue = new LinkedList<>();

    public static int[][] DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1} };

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        graph = new int[n][m];
        bfsVisited = new boolean[n][m];
        minDepth = new int[n][m];
        init();
        bfs();
        System.out.println(minDepth[n-1][m-1]);

    }

    public static void bfs(){
        minDepth[0][0] = 1;
        queue.offer(new Vertex(0,0));
        while(!queue.isEmpty()){
            Vertex v = queue.poll();
            if(bfsVisited[v.row][v.col]) continue;
            bfsVisited[v.row][v.col] = true;
            for(Vertex adj : getAdjacent(v)){
                if(!bfsVisited[adj.row][adj.col]){
                    minDepth[adj.row][adj.col] = minDepth[v.row][v.col] +1;
                    queue.offer(adj);
                }
            }
        }
    }

    public static List<Vertex> getAdjacent(Vertex v){
        List<Vertex> arr = new ArrayList<>();
        for(int[] dir : DIRECTIONS){
            int newRow = v.row + dir[0];
            int newCol = v.col + dir[1];
            if(0<=newRow && newRow <=n-1 && 0<=newCol && newCol<=m-1 &&graph[newRow][newCol]==1){
                arr.add(new Vertex(newRow, newCol));
            }
        }
        return arr;

    }

    public static void init() throws IOException{
        for(int i=0; i<n; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
    }

    static class Vertex{
        int row;
        int col;

        public Vertex(int row, int col){
            this.row = row;
            this.col = col;
        }
    }


}