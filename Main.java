import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main { // boj 1051

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException { //boj 2869
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int minN_M = N < M ? N : M;
        int answerLength = 1;


        label: for(int k=2; k<=minN_M; k++){
            for(int i=0; i<=N-k; i++){
                for(int j=0; j<= M-k; j++){
                    if(arr[i][j] == arr[i][j+k-1] &&
                            arr[i][j+k-1] == arr[i+k-1][j+k-1] &&
                            arr[i+k-1][j+k-1] == arr[i+k-1][j]){
                        answerLength = k;
                        continue label;
                    }
                }
            }
        }
        System.out.println(answerLength*answerLength);



    }

}