import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Set<String> s = new HashSet<>();
    public static void main(String[] args) throws IOException { // boj 14425;

        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        for(int i=0; i<n; i++) s.add(br.readLine());

        int count =0;
        for(int i=0; i<m; i++){
            if(s.contains(br.readLine()))
                count++;
        }

        System.out.println(count);
    }

}