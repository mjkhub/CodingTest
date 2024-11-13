import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] arr = new int[100][100];
    public static void main(String[] args) throws IOException { // boj 2563
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            markBlack(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        int blackCellCount = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(arr[i][j] == 1)
                    blackCellCount++;
            }
        }

        System.out.println(blackCellCount);
    }

    public static void markBlack(int leftDistance, int downDistance){

        int row = 99-downDistance; // index 니까..
        int col = leftDistance;
        for(int i=row; i>row-10; i--) {
            for (int j = col; j < col + 10; j++) {
                arr[i][j] = 1;
            }
        }
    }

}