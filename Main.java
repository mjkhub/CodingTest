import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException { //boj 1357

        String[] s = br.readLine().split(" ");

        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        System.out.println( rev((rev(x) + rev(y))));
    }

    public static int rev(int n){

        int reverse = 0;
        while(n > 0){
            reverse = reverse * 10 + n % 10;
            n /=10;
        }
        return reverse;
    }

}