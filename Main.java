import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n;
    public static long sum = 0;
    public static long answer = 0 ;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        for(int i=0; i<n; i++) {
            long value = Long.parseLong(s[i]);
            answer += (sum * value);
            sum += value;
        }
        System.out.println(answer);
    }

}
