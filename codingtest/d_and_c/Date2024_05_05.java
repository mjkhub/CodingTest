package codingtest.d_and_c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Date2024_05_05 { //boj 2447

    public static char[][] star;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().split(" ")[0]);
        star = new char[N][N];
        partition(0,0,N);

        printStar();

    }

    public static void partition(int row, int col, int n){
        if(n==3){
            for(int i=row; i<row+n; i++){
                for(int j=col; j<col+n; j++){
                    if(i%3 == 1 && j%3 ==1 ) star[i][j]=0;
                    else star[i][j]=1;
                }
            }
        }else{
            n = n/3;
            partition(row,col,n);
            partition(row, col+n, n);
            partition(row, col+2*n, n);

            partition(row+n, col,n);
            for(int i=row+n; i<row+2*n; i++){
                for(int j=col+n; j<col+2*n; j++){
                    star[i][j]=0;
                }
            }
            partition(row+n, col+2*n,n);

            partition(row+2*n, col,n);
            partition(row+2*n, col+n,n);
            partition(row+2*n, col+2*n,n);

        }
    }

    public static void printStar(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(star[i][j] == 1) sb.append('*'); //star
                else sb.append(' '); //star
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
