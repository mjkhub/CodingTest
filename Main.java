import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int M;

    public static boolean[] arr;

    public static void main(String[] args) throws IOException {
        M = Integer.parseInt(br.readLine());
        arr = new boolean[4];
        arr[1] = true;

        for(int i=0; i<M; i++){
            String[] s = br.readLine().split(" ");
            int cup1 = Integer.parseInt(s[0]);
            int cup2 = Integer.parseInt(s[1]);
            swap(cup1, cup2);
        }
        for(int i=1; i<=3; i++){
            if(arr[i]) System.out.println(i);
        }
    }
    public static void swap(int cup1, int cup2){

        boolean temp = arr[cup1];
        arr[cup1] = arr[cup2];
        arr[cup2] = temp;
    }




}