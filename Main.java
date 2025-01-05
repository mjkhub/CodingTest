import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int count = 0;

    public static int N,P;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static ArrayList<Stack<Integer>> guitar = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); P = Integer.parseInt(s[1]);
        for(int i=0; i<6; i++) guitar.add(new Stack<>());

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int line = Integer.parseInt(input[0]); int p = Integer.parseInt(input[1]);
            action(line, p);
        }
        System.out.println(count);
    }

    public static void action(int line, int p){
        Stack<Integer> stack = guitar.get(line-1);

        if(stack.isEmpty() || stack.peek() < p){ // 오른쪽 조건은 자연스럽게 스택이 비지 않음
            stack.push(p);
            count++;
            return;
        }

        while(!stack.isEmpty() && stack.peek() > p){
            stack.pop();
            count++;
        }

        if(stack.isEmpty() || stack.peek() < p){
            stack.push(p);
            count++;
        }

    }


}
