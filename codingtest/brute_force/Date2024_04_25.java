package codingtest.brute_force;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Date2024_04_25 { // boj 2839

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=N; i=i+5){
            for(int j=0; j+i<=N; j=j+3){
                if(i+j==N){
                    int num = i/5 + j/3;
                    if(min > num) min = num;
                }
            }
        }
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }


}
