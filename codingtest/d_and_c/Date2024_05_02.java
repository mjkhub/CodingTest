package codingtest.d_and_c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Date2024_05_02  { //boj 1992

    public static StringBuilder sb = new StringBuilder();
    public static int[][] square;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        square = new int[n][n];
        for(int i=0; i<n; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<n; j++){
                square[i][j] = Integer.parseInt(s[j]);
            }
        }


        System.out.println(partition(0, 0, n));


    }

    public static String partition(int row, int col, int size){
        if(!check(row,col,size)){
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(partition(row, col, size/2));
            sb.append(partition(row, col+size/2, size/2));
            sb.append(partition(row+size/2, col, size/2));
            sb.append(partition(row+size/2, col+size/2, size/2));
            sb.append(')');
            return sb.toString();
        }else{
            return ""+square[row][col];
        }
    }

    public static boolean check(int row, int col, int size){
        int start = square[row][col];
        for(int i=row; i<row+size; i++){
            for(int j =col; j<col+size; j++){
                if(start!=square[i][j]) return false;
            }
        }
        return true;
    }


}
