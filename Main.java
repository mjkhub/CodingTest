import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n, m, x, y, k;
    public static int[][] map;
    public static int[] dice;
    public static int top = 1;
    public static int bottom = 6;
    public static int[][] directions = { {0,1},{0,-1},{-1,0},{1,0}}; // 동 서 북 남
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]); m = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]); y = Integer.parseInt(input[3]);
        k = Integer.parseInt(input[4]);

        map = new int[n][m];
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 주사위 좌표 x y
        dice = new int[7]; // 1 ~ 6

        String[] s = br.readLine().split(" ");
        for(int i=0; i<k; i++){
            int command = Integer.parseInt(s[i])-1;
            int[] dir = directions[command];
            int row = x + dir[0];
            int col = y + dir[1];
            if(!isWithin(row, col)) continue;
            x = row; y = col;
            updateTop(command);
            updateBottom();
            if(map[x][y] == 0){
                map[x][y] = dice[bottom];
            }else{
                dice[bottom] = map[x][y];
                map[x][y] = 0;
            }
            System.out.println(dice[top]);
        }

    }
    public static void updateTop(int command) { //이 문제의 핵심 포인트
        int[] temp = dice.clone();
        switch (command) {
            case 0: // 동쪽
                dice[1] = temp[4];
                dice[4] = temp[6];
                dice[6] = temp[3];
                dice[3] = temp[1];
                break;
            case 1: // 서쪽
                dice[1] = temp[3];
                dice[3] = temp[6];
                dice[6] = temp[4];
                dice[4] = temp[1];
                break;
            case 2: // 북쪽
                dice[1] = temp[5];
                dice[5] = temp[6];
                dice[6] = temp[2];
                dice[2] = temp[1];
                break;
            case 3: // 남쪽
                dice[1] = temp[2];
                dice[2] = temp[6];
                dice[6] = temp[5];
                dice[5] = temp[1];
                break;
        }
    }
    public static void updateBottom(){
        if(top == 1) bottom = 6;
        else if( top == 2) bottom = 5;
        else if( top ==3) bottom = 4;
        else if( top == 4) bottom = 3;
        else if( top ==5) bottom = 2;
        else if( top ==6) bottom = 1;
    }

    public static boolean isWithin(int row, int col){
        return 0<= row && row<n && 0<=col && col <m;
    }


}
