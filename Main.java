import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int M;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int k = Integer.parseInt(s[1]);

        int[] array =
                Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<k; i++) genArray(array);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<array.length-k; i++){
            sb.append(array[i]);
            if(i!= array.length-k-1)
                sb.append(',');
        }
        System.out.println(sb);
    }

    public static void genArray(int[] array){
        for(int i=0; i<array.length-1; i++){
            array[i] = array[i+1] - array[i];
        }
    }





}