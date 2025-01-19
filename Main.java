import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            String s = br.readLine();
            System.out.println(getSize(s));
        }

    }

    public static int getSize(String s){

        int dir = 0;
        int x=0; int y = 0;
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'F'){
                x = x + directions[dir][0];
                y = y + directions[dir][1];
            }else if(c == 'B'){
                x = x - directions[dir][0];
                y = y - directions[dir][1];
            }else if(c == 'L'){
                dir  = (dir+3)%4;
            }else{ // R
                dir  = (dir+1)%4;
            }
            minX = Math.min(x,minX);
            maxX = Math.max(x,maxX);
            minY = Math.min(y,minY);
            maxY = Math.max(y,maxY);
        }



        return (maxY-minY) * (maxX - minX);
    }


}
