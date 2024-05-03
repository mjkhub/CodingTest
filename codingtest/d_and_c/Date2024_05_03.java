package codingtest.d_and_c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  Date2024_05_03 { // boj 1780


    public static int[][] paper;
    public static int zero =0;
    public static int positiveone =0;
    public static int negativeone =0;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        int N = Integer.parseInt(br.readLine());
        int row = 0;
        int col = 0; // row & col 은 탐색의 시작 인덱스
        paper = init(N);

        partition(row, col, N);


        System.out.println(negativeone);
        System.out.println(zero);
        System.out.println(positiveone);

    }

    public static void partition(int row, int col, int N) {

        if(checkPaper(row, col, N) == true) { //basecase
            if(paper[row][col] == 0) zero +=1;
            if(paper[row][col] == 1) positiveone +=1;
            if(paper[row][col] == -1) negativeone +=1;
            return; //명시적으로 걸어두는게 좋을듯
        }else {
            N = N/3;
            //1
            partition(row, col, N);
            //2
            partition(row, col+N, N);
            //3
            partition(row, col+2*N, N);
            //4
            partition(row+N, col, N);
            //5
            partition(row+N, col+N, N);
            //6
            partition(row+N, col+2*N, N);
            //7
            partition(row+2*N, col, N);
            //8
            partition(row+2*N, col+N, N);
            //9
            partition(row+2*N, col+2*N, N);
        }

    }

    public static boolean checkPaper(int row, int col , int N) {
        int std = paper[row][col]; //비교의 기준 standard를 첫번째 원소으로 설정
        for(int i=row; i<row+N; i++) {
            for(int j=col; j<col+N; j++) {
                if(std != paper[i][j]) {
                    return false; //다른것이 존재한다. -> 분할을 더 해야한다
                }
            }
        }
        return true; // 같은것만 존재한다. -> basecase
    }


    public static int[][] init(int N) throws IOException {
        int [][]  paper = new int[N][N];
        StringTokenizer st;
        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j =0; j<N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return paper;
    }

}