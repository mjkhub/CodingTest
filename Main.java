import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] arr;
    public static void main(String[] args) throws IOException {

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];int m = arr[1];
        int M = arr[2];int T = arr[3];int R = arr[4];

        int workOut = 0;
        int totalTime = 0;
        int X = m;

        if(m + T > M){
            System.out.println(-1);
            return;
        }
        while(workOut < N){
            if( X + T <= M ){ //운동
                X +=T;
                workOut++;

            }else{ // 무조건 휴식
                X = Math.max(m, X-R);
            }
            totalTime++;
        }
        System.out.println(totalTime);

    }


}
