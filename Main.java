import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int maxExpect = -1; int expectIndex = 0;

        int[] cake = new int[n+1];
        int[] count = new int[k+1];
        for(int i=1; i<=k; i++){
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            if(maxExpect < end-start+1){
                expectIndex = i;
                maxExpect = end-start +1;
            }

            for(int j=start; j<=end; j++){
                if(cake[j] == 0){
                    cake[j] = i;
                    count[i] +=1;
                }
            }
        }
        int actualMax = count[1]; int actualIndex = 1;

        for(int i = 1; i < count.length; i++){
            if(actualMax < count[i]){
                actualMax = count[i];
                actualIndex = i;
            }
        }
        System.out.println(expectIndex);
        System.out.println(actualIndex);

    }

}
