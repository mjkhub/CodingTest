import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Stack<Task> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while(n-->0){
            String[] s = br.readLine().split(" ");
            int yes = Integer.parseInt(s[0]);
            if(yes == 0){
                if(!stack.isEmpty()){ //내가 부족한 부분
                    Task t = stack.peek();
                    t.time -=1;
                    if(t.time == 0){
                        count += t.score;
                        stack.pop();
                    }
                }
            }else{
                int score = Integer.parseInt(s[1]);
                int t = Integer.parseInt(s[2]);
                if(t == 1)
                    count += score;
                else
                    stack.push(new Task(score,t-1));
            }
        }
        System.out.println(count);

    }

    static class Task{
        int score;
        int time;

        public Task(int score, int time) {
            this.score = score;
            this.time = time;
        }

    }
}
