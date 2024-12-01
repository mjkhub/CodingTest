import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n;
    public static int m;
    public static int[] arr;
    public static int max = 0;
    public static int answer =0;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(s[i]);
            max = Math.max(max, arr[i]);
        }
        m = Integer.parseInt(br.readLine());

        int low = 1;
        int high = max;

        while(low<= high){
            int mid = low + (high -low) / 2;
            if(isAssignable(mid)) {
                low = mid +1;
                answer = mid;
            }
            else high = mid-1;
        }
        System.out.println(answer);
    }

    public static boolean isAssignable(int money){
        int sum = 0;
        for(int i=0; i<n; i++)
            sum += Math.min(money, arr[i]);
        return m >= sum;
    }


}
