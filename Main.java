import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] bulbs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while(m --> 0){
            String[] input= br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if(a == 1){
                bulbs[b-1] = c;
            }else if(a == 2){
                for(int i=b-1; i<=c-1; i++)
                    bulbs[i] = bulbs[i] == 1 ? 0 : 1;

            }else if (a == 3){
                for(int i=b-1; i<=c-1; i++)
                    bulbs[i] = 0;
            }else{ //4
                for(int i=b-1; i<=c-1; i++)
                    bulbs[i] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(bulbs[i]).append(' ');
        }
        System.out.println(sb);



    }






}
