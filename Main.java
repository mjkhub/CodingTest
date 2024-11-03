import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // boj 1094

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException { //boj 1357

        int x = Integer.parseInt(br.readLine());
        if( x == 64){
            System.out.println(1);
            return;
        }

        int shortBar = 64;
        int barSum = 0;
        int count = 0;

        while(barSum < x){
            shortBar = shortBar / 2;
            if(barSum + shortBar > x){ // do nothing

            }else{
                barSum += shortBar;
                count++;
            }
        }

        System.out.println(count);

    }

}