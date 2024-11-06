import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException { // boj 1929

        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        StringBuilder sb = new StringBuilder();
        for(int i=m; i<=n; i++){
            if(isPrimeNumber(i)) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }


    public static boolean isPrimeNumber(int n){
        if( n == 1) return false;

        int sqrt = (int)Math.sqrt(n);
        for(int i=2;i <=sqrt; i++){
            if( n % i ==0) return false;
        }
        return true;
    }

}