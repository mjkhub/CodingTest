import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[][] map;
    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); int m = Integer.parseInt(s[1]);

        map = new int[100][100];

        for(int i=0; i<n; i++){
            String[] coords = br.readLine().split(" ");
            int x1 = Integer.parseInt(coords[0])-1; int y1 = Integer.parseInt(coords[1])-1;
            int x2 = Integer.parseInt(coords[2])-1; int y2 = Integer.parseInt(coords[3])-1;
            mark(x1, y1, x2, y2);
        }

        int sum = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if( map[i][j] > m)
                    sum++;
            }
        }
        System.out.println(sum);

    }

    public static void mark(int x1, int y1, int x2, int y2){
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                map[i][j] += 1;
            }
        }
    }




}
