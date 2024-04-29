package codingtest.brute_force;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Date2024_04_30 { // boj 2231

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int digit = getDigit(N);
        for(int i=N-digit*10; i<=N; i++){
            if(getSum(i) == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);

    }

    public static int getDigit(int n){
        int count =0;
        boolean flag = true;
        while(flag){
            n = n/ 10;
            count++;
            if(n==0) flag = false;

        }
        return count;
    }

    public static int getSum(int n){
        int sum = n;
        boolean flag = true;
        while(flag){
            sum += n % 10;
            n = n/10;
            if(n==0) flag = false;

        }
        return sum;
    }
}
