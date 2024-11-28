import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] arr;
    public static int n;
    public static int m;
    public static int max = 0;
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);
        String[] inputs = br.readLine().split(" ");
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(inputs[i]);
            max = Math.max(max, arr[i]);
        }

        int low = 1;
        int high = max;
        int h = 0;

        while(low<=high){
            int mid = low + (high - low)/ 2; // h
            long treeSize = slice(mid);
            if(treeSize >= m) {
                low = mid +1;
                h = mid;
            }
            else high = mid -1;
        }
        System.out.println(h);
    }

    public static long slice(int h){
        long sum = 0;
        for(int i=0; i<n; i++){
            if(arr[i] >= h) sum += arr[i] - h;
        }
        return sum;
    }
}
