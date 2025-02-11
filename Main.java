import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n, m;
    public static int[] arr;
    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int low = 1;
        int high =  arr[n-1] - arr[0];
        int answer = 0;

        while(low <= high){
            int mid = (high + low) / 2;
            if(isAvailable(mid)){
                answer = mid;
                low = mid + 1;
            }else
                high = mid-1;
        }
        System.out.println(answer);

    }

    public static boolean isAvailable(int size) {
        int count = 1;
        int prev = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - prev >= size) {
                count++;
                prev = arr[i];
            }
        }

        return count >= m;
    }
}
