package codingtest.graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Date_2024_05_09 { //boj 1260

    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] dfsVisited;
    public static Queue<Integer> bfsQueue = new LinkedList<>();
    public static boolean[] bfsVisited;

    public static StringBuilder dfsSb = new StringBuilder();
    public static StringBuilder bfsSb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); int m = Integer.parseInt(input[1]);  int startVertex = Integer.parseInt(input[2]);

        dfsVisited = new boolean[n+1];
        bfsVisited = new boolean[n+1];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        while(m-->0){
            String[] s = br.readLine().split(" ");
            int vertexOne = Integer.parseInt(s[0]);
            int vertexTwo = Integer.parseInt(s[1]);
            graph.get(vertexOne).add(vertexTwo);
            graph.get(vertexTwo).add(vertexOne);
        }

        dfs(startVertex);
        bfsQueue.offer(startVertex);
        bfs(startVertex);
        System.out.println(dfsSb);
        System.out.println(bfsSb);


    }

    public static void dfs(int vertex){
        if(!dfsVisited[vertex]){
            dfsVisited[vertex] = true;
            dfsSb.append(vertex).append(' ');
            for (Integer adjacent : getAdjacent(vertex)){
                dfs(adjacent);
            }
        }
    }

    public static void bfs(int vertex){
        while (!bfsQueue.isEmpty()){
            Integer v = bfsQueue.poll();
            bfsVisited[v] = true;
            bfsSb.append(v).append(' ');
            ArrayList<Integer> adjacent = getAdjacent(v);
            for (Integer integer : adjacent) {
                if (!bfsVisited[integer] && !bfsQueue.contains(integer))
                    bfsQueue.offer(integer);
            }
        }
    }

    public static ArrayList<Integer> getAdjacent(int vertex){
        ArrayList<Integer> temp = graph.get(vertex);
        Collections.sort(temp);
        return temp;
    }

}