import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int r, c;

    public static int[][] map;


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        r =  Integer.parseInt(s[0]);
        c =  Integer.parseInt(s[1]);
        map = new int[r][c];

        for(int i=0; i<r; i++){
            String line = br.readLine();
            for(int j=0; j<c; j++){
                char c = line.charAt(j);
                if( c == '.') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }

        after50Year();

        int minRow = Integer.MAX_VALUE, maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE, maxCol = Integer.MIN_VALUE;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                sb.append(map[i][j] == 1 ? 'X' : '.');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }




    public static void after50Year(){
        int[][] newMap = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int count = getSeaCount(i,j);
                if( count >=3) newMap[i][j] = 0; //바다
                else newMap[i][j] = map[i][j]; // 그대로
            }
        }
        map = newMap;
    }

    public static int getSeaCount(int i, int j){

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        int seaCount = 0;
        for(int[] dir : directions){
            int row = i + dir[0];
            int col = j + dir[1];

            if(!(0<=row && row<r && 0<=col && col<c)) {
                seaCount++;
            }else{
                if(map[row][col]==0)
                    seaCount++;
            }
        }
        return seaCount;
    }



}
