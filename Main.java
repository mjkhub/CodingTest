import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n;
    public static int m;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];

        for(int i=0; i<n; i++){
            String[] values = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(values[j]);
            }
        }

        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++){
            int[] indexList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = getSum(indexList);
            System.out.println(sum);
        }

    }

    public static int getSum(int[] indexList){
        int sum =0;
        for(int i=indexList[0]-1; i<=indexList[2]-1; i++){
            for(int j=indexList[1]-1; j<=indexList[3]-1; j++){
                sum +=arr[i][j];
            }
        }
        return sum;
    }

}
