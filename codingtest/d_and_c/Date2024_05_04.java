package codingtest.d_and_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Date2024_05_04 { // boj 2740

    public static int n;
    public static int m;
    public static int k;
    public static int[][] m1;
    public static int[][] m2;
    public static void main(String[] args) throws IOException {

        init();
        int[][] m3 = new int[n][k];

        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                m3[i][j] = getInt(i,j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                System.out.print(m3[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        m1 = new int[n][m];
        for(int i=0; i<n; i++){
            String[] s1 = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                m1[i][j] = Integer.parseInt(s1[j]);
            }
        }

        k = Integer.parseInt(br.readLine().split(" ")[1]);
        m2 = new int[m][k];
        for(int i=0; i<m; i++){
            String[] s1 = br.readLine().split(" ");
            for(int j=0; j<k; j++){
                m2[i][j] = Integer.parseInt(s1[j]);
            }
        }

    }

    public static int getInt(int i, int j){
        int[] ints = m1[i];
        int sum = 0;
        for(int t=0; t<m; t++){
            sum+= ints[t] *m2[t][j];
        }
        return sum;
    }
}
