package codingtest.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Date_2024_11_03 { //boj 10872

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        System.out.println(factorial(n));

    }

    public static int factorial(int n){
        if(n == 0) return 1;
        else return n * factorial(n-1);
    }

}
