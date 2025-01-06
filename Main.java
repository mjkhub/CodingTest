import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n;
    public static String content;
    public static int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // 0 ~ 3
    public static int dir = 1;

    public static int row=0, col=0; // 초기 좌표
    public static List<Position> path = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        content = br.readLine();

        path.add(new Position(row,col));
        for(int i=0; i<n; i++){
            char c = content.charAt(i);
            if(c == 'F') move();
            else changeDir(c);
        }

        int min = 0;
        int maxRow = 0;
        int maxCol = 0;

        for(int i=1; i<path.size(); i++){
            Position p1 = path.get(min);
            Position temp = path.get(i);
            if(p1.row >= temp.row && p1.col >= temp.col)
                min = i;
        }

        for(int i=0; i<path.size(); i++){
            if( min == i ) continue;
            Position m= path.get(min);
            Position p = path.get(i);
            int rowAbs = Math.abs(p.row - m.row);
            int colAbs = Math.abs(p.col - m.col);
            if( rowAbs > maxRow) maxRow = rowAbs;
            if( colAbs > maxCol) maxCol = colAbs;
        }
        maxCol +=1;
        maxRow +=1;
        boolean[][] answer = new boolean[maxRow][maxCol];
        while(!path.isEmpty()){
            Position p = path.remove(0);
            answer[p.row+ maxRow-1][p.col] = true;
        }

        for(int i=0; i<maxRow; i++){
            for(int j=0; j<maxCol; j++){
                System.out.print(answer[i][j]?'.':'#');
            }
            System.out.println();
        }












    }

    public static void move(){
        row = row + directions[dir][0];
        col = col + directions[dir][1];
        path.add(new Position(row,col));
    }

    public static void changeDir(char c){
        if(c == 'R') dir = (dir + 1) % 4;
        else dir = (dir + 3) % 4;
    }

    static class Position{
        int row;
        int col;
        public Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

}
