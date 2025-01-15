import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int x = getInt(br.readLine().split(" "));
            int y =  getInt(br.readLine().split(" "));

            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int count =0;
            for(int i=0; i<n; i++){ // start index
                int z = 0 ;
                for(int j=0; j<m; j++) {   // m 번
                    z = z * 10 + arr[(i+j)%arr.length];
                }
                if(x<= z && z <=y)
                    count++;
            }
            System.out.println(count);
        }

    }

    public static int getInt(String[] input){
       int number = 0;
       for(int i=0; i<input.length; i++)
           number = number * 10 + Integer.parseInt(input[i]);
        return number;
    }


}
