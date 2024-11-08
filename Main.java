import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static boolean[] visit;
    public static int[] buf;
    public static int N;
    public static int M;
    public static void main(String[] args) throws IOException { // boj 15649

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        buf = new int[M];
        visit = new boolean[N+1];
        dfs(0);
    }

    public static void dfs(int depth){

        if(depth == M ){
            StringBuilder sb = new StringBuilder();
            for(int value : buf)
                sb.append(value).append(' ');
            System.out.println(sb);
            return;
        }// base case

        for(int i=1; i<=N; i++){
            if(!visit[i]){
                visit[i] = true;
                buf[depth] = i;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }


}