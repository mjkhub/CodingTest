import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Position king,rock;

    public static int[][] directions = { {0,1},{0,-1},{1,0},{-1,0},
            {-1,1},{-1,-1},{1,1},{1,-1}};


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[2]);

        king = getPos(s[0]);
        rock = getPos(s[1]);

        //init
        while(n-->0){
            String m = br.readLine();
            move(m);
        }
        System.out.println(getStr(king));
        System.out.println(getStr(rock));

    }
    public static Position getPos(String s){
        return new Position('8' - s.charAt(1), s.charAt(0)-'A');
    }

    public static String getStr(Position pos){

        StringBuilder sb = new StringBuilder(2);
        sb.append((char) ('A'+pos.col));
        sb.append( 8 - pos.row);
        return sb.toString();
    }


    public static void move(String  m){
        // 돌이 먼저 움직이고 킹이 움직이는 로직으로 짜는게 더 적합할지도 모르겠다.
        // 근데 돌이 움직일 수 없으면 킹이 움직일 수 없다. 이건 문제에서 명확하게 드러나지 않음

        int[] dir = getDir(m);

        if(isValid(king.row+dir[0], king.col+dir[1])) {
            king.row += dir[0];
            king.col += dir[1];
        }

        if (king.row == rock.row && king.col == rock.col){
            if(isValid(rock.row+dir[0],rock.col+dir[1])){
                rock.row +=dir[0];
                rock.col +=dir[1];
            }else{
                king.row -= dir[0];
                king.col -= dir[1];
            }
        }


    }

    public static boolean isValid(int row, int col){
        return 0<=row && row<=7 && 0<=col && col<=7;
    }

    public static int[] getDir(String m){
        if(m.equals("R")){
            return directions[0];
        }else if(m.equals("L")){
            return directions[1];
        }else if(m.equals("B")){
            return directions[2];
        }else if(m.equals("T")){
            return directions[3];
        }else if(m.equals("RT")){
            return directions[4];
        }else if(m.equals("LT")){
            return directions[5];
        }else if(m.equals("RB")){
            return directions[6];
        }else{ //LB
            return directions[7];
        }
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
