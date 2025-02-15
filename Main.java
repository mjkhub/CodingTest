import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int n, m;

    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());
        visit = new boolean[n+1];

        for(int i=0; i<m; i++){
            String[] input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        int count = 0;

        for(int i=1; i<=n; i++){
            if(!visit[i]){
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int v){
        visit[v] = true;
        for(int adjacent : graph.get(v)){
            if(!visit[adjacent])
                dfs(adjacent);
        }
    }


}
