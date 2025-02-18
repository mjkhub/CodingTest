import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] arr;
    public static int[] buf;
    public static int min = Integer.MAX_VALUE;

    public static boolean[] visit;

    public static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1]; // 1 ~ n 명의 정보
        buf = new int[n/2];
        visit = new boolean[n+1];

        for(int i=1; i<=n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(str[j-1]);
            }
            numbers.add(i);
        }


        dfs(1, 0);

        System.out.println(min);

    }

    public static void dfs(int idx, int depth){
        if(depth == n / 2){ // basecase
            List<Integer> group1 = new ArrayList<>();
            List<Integer> group2 = new ArrayList<>();

            for(int i=1; i<=n; i++){
                if(existInBuf(i)) group1.add(i);
                else group2.add(i);
            } //split
            int s1 = getScore(group1);
            int s2 = getScore(group2);

            min = Math.min(min, Math.abs(s1-s2));
            return;
        }

        buf[depth] = idx; //visit
        for(int i=idx+1; i<=n+1; i++){
            dfs(i,depth+1);
        }


    }

    public static boolean existInBuf(int integer){
        for(int i=0; i<n/2; i++){
            if(integer == buf[i])
                return true;
        }
        return false;
    }

    public static int getScore(List<Integer> group){
        int sum = 0;
        for(int i=0; i<n/2; i++){
            for(int j=0; j<n/2; j++){
                if(i == j) continue;
                sum += arr[group.get(i)][group.get(j)];
            }
        }
        return sum;
    }


}
