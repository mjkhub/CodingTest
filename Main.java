import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n, q;

    public static List<Integer> arr = new ArrayList<>();
    public static int[] sum;

    public static void main(String[] args) throws IOException { // ok 근데 이거 코딩 스타일이 너무 안좋은 것 같음

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); q = Integer.parseInt(s[1]);
        sum = new int[n+1];

        String[] s1 = br.readLine().split(" ");
        for(int i=0; i<n; i++)
            arr.add(Integer.parseInt(s1[i]));

        Collections.sort(arr);
        for(int i=1; i<=n; i++)
            sum[i] = sum[i-1] + arr.get(i-1);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<q; i++){
            String[] s2 = br.readLine().split(" ");
            int start = Integer.parseInt(s2[0]);
            int end = Integer.parseInt(s2[1]);
            int result = getSum(start,end);
            sb.append(result).append('\n');
        }
        System.out.println(sb);

    }

    public static int getSum(int start, int end){
        return sum[end] - sum[start-1];
    }

}
