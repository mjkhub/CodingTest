import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n;
    public static int[] arr;
    public static boolean[] mistake;
    public static int[] sum;


    public static void main(String[] args) throws IOException { // ok 근데 이거 코딩 스타일이 너무 안좋은 것 같음

        n = Integer.parseInt(br.readLine());
        arr = new int[n+2];
        mistake = new boolean[n+2];
        sum = new int[n+2];
        arr[n+1] = Integer.MAX_VALUE;

        String[] input = br.readLine().split(" ");
        for(int i=n; i>=1; i--){
            int level = Integer.parseInt(input[i-1]);
            if(level > arr[i+1]){
                mistake[i] = true;
            }
            arr[i] = level;
        }
        for(int i=1; i<=n; i++){
            sum[i] = sum[i-1] + (mistake[i]?1:0);
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q; i++){
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            sb.append(getSum(start, end)).append('\n');
        }
        System.out.println(sb);
    }

    public static int getSum(int start, int end){
        int answer = sum[end] - sum[start-1];
        if(mistake[end]) answer -=1;
        return answer;
    }

}
