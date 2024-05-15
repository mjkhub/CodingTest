package codingtest.graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Date_2024_05_15 { //boj 2178

    public static int[][] graph;
    public static Queue<Node> bfsQueue = new LinkedList<>();
    public static boolean[][] bfsVisited;

    public static Node lastNode = null;

    public static int n;
    public static int m;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]); m = Integer.parseInt(input[1]);

        bfsVisited = new boolean[n+2][m+2];
        graph = new int[n+2][m+2];

        for(int i=1; i<=n; i++){
            String[] s = br.readLine().split("");
            for(int j=1; j<=m; j++){
                graph[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        bfs(1,1);
        System.out.println(lastNode.depth);
    }

    public static void bfs(int startRow, int startCol){
        bfsQueue.offer(new Node(startRow,startCol,1));
        while (!bfsQueue.isEmpty()){
            Node v = bfsQueue.poll();
            bfsVisited[v.row][v.col] = true;
            if(v.row==n && v.col == m){
                lastNode = v;
                break;
            }

            ArrayList<Node> adjacent = getAdjacent(v.row,v.col,v.depth);
            for (Node n : adjacent) {
                if (!bfsVisited[n.row][n.col] && !bfsQueue.contains(n) && graph[n.row][n.col] == 1) //문제가 될만한 요소를 제거
                    bfsQueue.offer(n);
            }
        }
    }

    public static ArrayList<Node> getAdjacent(int row, int col, int depth){
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node(row-1,col,depth+1));
        nodes.add(new Node(row,col-1,depth+1));

        nodes.add(new Node(row,col+1,depth+1));
        nodes.add(new Node(row+1,col,depth+1));
        return nodes;
    }

    static class Node{
        int row;
        int col;
        int depth;

        public Node(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }


        @Override
        public boolean equals(Object o) {
            if(o instanceof Node){
                Node node = (Node) o;
                return row == node.row && col == node.col;
            }else return false;

        }

    }

}