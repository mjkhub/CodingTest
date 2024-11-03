package codingtest.lets_do_it;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Date2024_11_03 { //boj 1110

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        if(n < 10) n *= 10;

        int original = n;

        int count = 0;
        do{
            int step1 = n / 10 + n % 10;
            int step2 = n % 10;
            n = step2 * 10 + step1 % 10 ;
            count++;
        }while(n != original);

        System.out.println(count);
    }

}
