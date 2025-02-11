import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int answer = 0 ;
        int count =0;
        for(int i=n-1; i>=0; i--){
            count++;
            answer = Math.max(count*arr[i], answer);
        }
        System.out.println(answer);

    }

}
