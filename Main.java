import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int n, w;

    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visit;
    public static int leafCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); w = Integer.parseInt(s[1]);
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());
        visit = new boolean[n+1];

        for(int i=0; i<n-1; i++){
            String[] line = br.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        bfs(1);

        System.out.println( (double) w / leafCount);


    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int v = queue.poll();
            visit[v] = true;

            boolean isLeaf = true;
            for(int adj : graph.get(v)){
                if(!visit[adj]){ //
                    isLeaf = false;
                    queue.offer(adj);
                }
            }
            if(isLeaf)
                leafCount++;
        }

    }



}
