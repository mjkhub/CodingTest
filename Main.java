import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int count = 0;
    public static void main(String[] args) throws IOException { // boj 10157
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int c = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);
        int k = Integer.parseInt(br.readLine());

        int x = 1; int y = 0; // current pos
        boolean found = false;

        label: while(r >=2){

            for(int i=1; i<=r; i++){ // up
                count++;
                y++;
                if(k == count) {
                    found = true;
                    break label;
                }
            }

            for(int i=1; i<=c-1; i++){ // right
                count++;
                x++;
                if(k == count) {
                    found = true;
                    break label;
                }
            }
            for(int i=1; i<=r-1; i++){ // down
                count++;
                y--;
                if(k == count) {
                    found = true;
                    break label;
                }
            }
            for(int i=1; i<=c-2; i++){ // left
                count++;
                x--;
                if(k == count) {
                    found = true;
                    break label;
                }
            }
            r -=2;
            c -=2;
        }

        if(found) System.out.println(x+ " "+ y);
        else System.out.println(0);
    }






}