import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int n;
    public static int rootNode;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<>());
        visit = new boolean[n];

        int[] parents = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int node = 0; node < n; node++) {
            int parent = parents[node];
            if (parent == -1) {
                rootNode = node;
            } else {
                graph.get(parent).add(node);
            }
        }


        int K = Integer.parseInt(br.readLine());

        if (K == rootNode) {
            System.out.println(0);
            return;
        }

        visit[K] = true;
        int leafCount = bfs(rootNode);

        System.out.println(leafCount);

    }
    public static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = true;

        int leafCount = 0;
        while(!queue.isEmpty()){
            int v = queue.poll();

            boolean isLeaf = true;
            for(int adjacent : graph.get(v)){
                if(!visit[adjacent]){
                    queue.offer(adjacent);
                    visit[adjacent] = true;
                    isLeaf = false;
                }
            }
            if(isLeaf)
                leafCount++;
        }

        return leafCount;
    }


}
