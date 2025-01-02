import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n, m;
    public static char[][] map;
    public static String[][] boards = {{"WBWBWBWB","BWBWBWBW", "WBWBWBWB","BWBWBWBW", "WBWBWBWB","BWBWBWBW", "WBWBWBWB","BWBWBWBW"},
            {"BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB"}}; // 0: white 1: black
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);
        map = new char[n][m];
        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<m; j++)
                map[i][j] = input.charAt(j);
        }

        int min = Integer.MAX_VALUE;

        int maxRow = n-8;
        int maxCol = m-8;

        for(int i=0; i<=maxRow; i++){
            for(int j=0; j<=maxCol; j++){
                int white = countDiff(i,j,0);
                int black = countDiff(i,j,1);
                min = Math.min(Math.min(white, black),min);
            }
        }
        System.out.println(min);

    }

    public static int countDiff(int sR, int sC, int boardIndex){
        String[] board = boards[boardIndex];
        int count = 0;
        for(int i=sR; i<sR+8; i++){
            for(int j=sC; j<sC+8; j++){
                if(map[i][j] != board[i-sR].charAt(j-sC))count++;
            }
        }
        return count;
    }


}
