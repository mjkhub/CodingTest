import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static int N, M;
    public static int[] arr, res;
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr); //정렬

        M = Integer.parseInt(br.readLine());
        res = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0; i<M; i++) {
            if(binarySearch(0, N-1, res[i]) != null)
                sb.append('1').append('\n');
            else
                sb.append('0').append('\n');
        }
        System.out.println(sb);
    }

    public static Integer binarySearch(int low, int high, int k) {
        while(low<=high){
            int mid = (low + high)/2;
            if(arr[mid] > k) high = mid-1;
            else if(arr[mid] < k) low = mid +1 ;
            else return k;
        }
        return null; // 못 찾았다는 의미
    }

}