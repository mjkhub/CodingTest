import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[][] arr;
    public static Queue<D> dQueue = new LinkedList<>();
    public static int n, k, l;
    public static int[][] directions = {{0,1}, {1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1]; //0: nope 1: apple

        for(int i=0; i<k; i++){
            String[] s = br.readLine().split(" ");
            int row = Integer.parseInt(s[0]);
            int col = Integer.parseInt(s[1]);
            arr[row][col] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for(int i=0; i<l; i++){
            String[] s = br.readLine().split(" ");
            dQueue.offer(new D(Integer.parseInt(s[0]),s[1]));
        }

        int time = 0;
        Snake snake = new Snake();
        while(true){
            time++;
            boolean isGoodToGo = snake.move();
            if(!isGoodToGo){
                break;
            }
            if(!dQueue.isEmpty() && dQueue.peek().t == time){ //safe
                snake.changeHeadDirection(dQueue.poll().d);
            }

        }
        System.out.println(time);

    }

    static class Snake{
        List<Body> body = new ArrayList<>(); // 0 head & tail;

        public Snake(){
            body.add(new Body(1,1, directions[0]));
        }

        public boolean move(){
            Body head = body.get(body.size() - 1);
            int row = head.row + head.direction[0];
            int col =  head.col + head.direction[1];

            if(!(1 <=row && row <=n && 1<=col && col<=n)) // 벽에 충돌
                return false;

            for(Body part: body){ // 몸 충돌
                if(part.row == row && part.col == col)
                    return false;
            }

            body.add(new Body(row, col, head.direction));
            if(arr[row][col] == 1) //apple;
                arr[row][col] = 0;
            else //normal
                body.remove(0); // 꼬리 제거

            return true;
        }

        public void changeHeadDirection(String d){
            Body head = body.get(body.size() - 1);
            int index;
            if(d.equals("D")){ // 오른쪽
                index = getRightDirectionIndex(head.direction);
            }else{ // 왼쪽
                index = getLeftDirectionIndex(head.direction);
            }
            head.direction = directions[index];
        }

        private int getRightDirectionIndex(int[] direction){
            for(int i = 0; i<4 ; i++){
                if(directions[i][0] == direction[0] &&
                        directions[i][1] == direction[1] )
                    return (i+1) % 4;
            }
            throw new RuntimeException("인덱스 에러 오른쪽 변환");
        }
        private int getLeftDirectionIndex(int[] direction){
            for(int i = 0; i<4 ; i++){
                if(directions[i][0] == direction[0] &&
                        directions[i][1] == direction[1] ){
                    int index = i-1;
                    if(index <0) return index + 4;
                    else return index;
                }
            }
            throw new RuntimeException("인덱스 에러 왼쪽 변환");
        }
    }

    static class Body{
        int row;
        int col;
        int[] direction;

        public Body(int row, int col, int[] direction){
            this.row = row;
            this.col = col;
            this.direction = direction;
        }
    }

    static class D{
        int t; //time
        String d; //direction

        public D(int t, String d ){
            this.t = t;
            this.d = d;
        }
    }



}
