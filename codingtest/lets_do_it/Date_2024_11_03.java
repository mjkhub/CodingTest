package codingtest.lets_do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Date_2024_11_03 { //boj 1110

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int original;
    public static int count = 0;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        if(n < 10) n *= 10;
        original = n;
        checkNewNumber(n);
        System.out.println(count);
    }

    public static void checkNewNumber(int n){
        count++;
        int step1 = n / 10 + n % 10;
        int step2 = n % 10;
        int newNumber = step2 * 10 + step1 % 10 ;

        if( newNumber == original) return;
        else checkNewNumber(newNumber);
    }

}
