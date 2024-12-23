import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n;
    public static int k;
    public static int[] sumArr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        sumArr = new int[n+1];
        for(int i=1; i<=n; i++) sumArr[i] += sumArr[i-1] + Integer.parseInt(s[i-1]);

        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            String[] s1 = br.readLine().split(" ");
            int start = Integer.parseInt(s1[0]);
            int end = Integer.parseInt(s1[1]);
            System.out.println(getSum(start, end));
        }
    }

    public static int getSum(int start, int end){
        return sumArr[end]-sumArr[start-1];
    }

}
