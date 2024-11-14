import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException { //boj 8320

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=1; i*i<=n; i++){

            for(int j=i*i; j<=n; j+=i){
                count++;
            }
        }
        System.out.println(count);




    }




}