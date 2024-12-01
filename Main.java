import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n;
    public static int m;
    public static int[] arr;

    public static int max =0;
    public static int totalSum = 0;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
            max = Math.max(max, arr[i]);
            totalSum += arr[i];
        }

        int low = max;
        int high = totalSum;

        while(low <= high){
            int mid = (low + high) / 2;
            if(canDivide(mid)) {
                high = mid -1;
                answer = mid;
            }else{
                low = mid +1;
            }
        }
        System.out.println(answer);
    }

    public static boolean canDivide(int size){
        int count = 1;
        int sum =0;
        for(int i=0; i<n; i++){
            if( sum + arr[i] > size){
                count++;
                sum = arr[i];
                if(count > m) return false;
            }else{
                sum += arr[i];
            }

        }
        return true;
    }

}
